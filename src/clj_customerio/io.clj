(ns clj-customerio.io
  (:gen-class)
  (:use clojure-csv.core
        clojure.string))

(defrecord Customer [email id fields])

(defn structure
  [headers body]
  (map #(zipmap headers %1) (next body)))

(defn keywordify
  [headers]
  (map #(keyword %1) headers))

(defn read-customers
  [filename]
  (let [ingested (-> filename
                    slurp
                    parse-csv)
        headers (set (first ingested))]
    (if (and
          (contains? headers "email")
          (contains? headers "id"))
      (structure (keywordify (first ingested)) ingested)
      (println "Error - Could not find 'email' and/or 'id' in csv header."))))
