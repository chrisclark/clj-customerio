(ns clj-customerio.core-test
  (:require [clojure.test :refer :all]
            [clj-customerio.core :refer :all]
            [clj-customerio.io :refer :all]))

(deftest keywordify-test
  (is (= (keywordify ["a" "b"]) [:a :b])))

(deftest structure-test
  (def headers [:a :b])
  (def body [["a" "b"] ["foo" "bar"] ["qux" "mux"]])
  (is (= (structure headers body) [{:a "foo", :b "bar"} {:a "qux", :b "mux"}])))
