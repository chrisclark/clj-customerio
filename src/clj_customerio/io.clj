(ns clj-customerio.io
  (:gen-class)
  (:use clojure-csv.core))

(defrecord Customer [email id fields])

(defn read-customers
  [filename]
  (def ingested (-> filename
                    slurp
                    parse-csv))
  (def headers (set (first ingested)))
  (if (and
        (contains? headers "email")
        (contains? headers "id"))
    (do
      (def kheaders (map
                     #(keyword %1)
                     (first ingested)))
      (map
       #(zipmap kheaders %1)
       (next ingested)))
    (println "Error - Could not find 'email' and/or 'id' in csv header.")))
