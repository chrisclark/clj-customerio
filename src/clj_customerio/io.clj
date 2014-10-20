(ns clj-customerio.io
  (:gen-class)
  (:use clojure-csv.core
        clojure.string))

(defn trim-coll
  [coll]
  (map #(trim %1) coll))

(defn in-coll?
  [elems coll]
  (every? true? (map #(boolean (some #{%1} coll)) elems)))

(defn structure
  [headers body]
  (map #(zipmap headers (trim-coll %1)) (next body)))

(defn keywordify
  [headers]
  (map #(keyword %1) (trim-coll headers)))

(defn read-customers
  [filename]
  (let [ingested (-> filename
                    slurp
                    parse-csv)]
    (if (in-coll? ["email" "id"] (first ingested))
      (structure (keywordify (first ingested)) ingested)
      (println "Error - Could not find 'email' and/or 'id' in csv header."))))
