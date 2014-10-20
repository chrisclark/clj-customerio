(ns clj-customerio.io
  (:gen-class)
  (:use clojure-csv.core
        clojure.string))

(defn do-trim [col] (map #(trim %1) col))

(defn structure
  [headers body]
  (map #(zipmap headers (do-trim %1)) (next body)))

(defn keywordify
  [headers]
  (map #(keyword %1) (do-trim headers)))

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
