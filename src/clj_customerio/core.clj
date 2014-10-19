(ns clj-customerio.core
  (:gen-class)
  (:use clj-customerio.io
        [clojure.string :only (join)])
  (:require [org.httpkit.client :as http]
            [clojure.tools.cli :refer [cli]]
            [clojure.data.json :as json]))

(defn -main
  [& args]
  (let [[opts args banner] (cli args
                                ["-f" "--file" "CSV file" :flag false]
                                ["-u" "--user" "customer.io Site Id" :flag false]
                                ["-p" "--password" "customer.io API Key" :flag false])]

    (def emails (read-customers (:file opts)))

    (defn build-req
      [obj]
      {:headers {"Content-Type" "application/json"}
       :basic-auth [(:user opts) (:password opts)]
       :body (json/write-str obj)})

    (defn path
      [customer]
      (str "https://track.customer.io/api/v1/customers/" (:id customer)))

    (doseq [customer emails]
      (let [{:keys [status headers body error] :as resp}
            @(http/put (path customer) (build-req customer))]
        (if (= 200 status)
          (println "Successfully upserted" (:email customer))
          (println "Failed, exception: " body))))))
