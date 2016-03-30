(ns clj-customerio.core
  (:gen-class)
  (:require [clj-customerio.io :refer [read-customers]]
            [clojure.string :refer [join]]
            [org.httpkit.client :as http]
            [clojure.tools.cli :refer [cli]]
            [clojure.data.json :as json]))

(defn build-req
  [auth obj]
  {:headers {"Content-Type" "application/json"}
   :basic-auth auth
   :body (json/write-str obj)})

(defn path
  [customer]
  (str "https://track.customer.io/api/v1/customers/" (:id customer)))

(defn logger
  [status customer body error]
  (if (= 200 status)
    (println "Successfully upserted" (:email customer))
    (println "Failed: " (str body error))))

(defn -main
  [& args]
  (let [[opts args banner] (cli args
                                ["-f" "--file" "CSV file" :flag false]
                                ["-u" "--user" "customer.io Site Id" :flag false]
                                ["-p" "--password" "customer.io API Key" :flag false])
        customer-data (read-customers (:file opts))
        basic-auth [(:user opts) (:password opts)]
        req-builder (partial build-req basic-auth)]

    (doseq [customer customer-data]
      (let [{:keys [status headers body error] :as resp}
            @(http/put (path customer) (req-builder customer))]
        (logger status customer body error)))))
