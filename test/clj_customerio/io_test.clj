(ns clj-customerio.io-test
  (:require [clojure.test :refer :all]
            [clj-customerio.io :refer :all]))

(deftest do-trim-test
  (is (= (do-trim ["a " "b" "  c "]) ["a" "b" "c"])))

(deftest keywordify-test
  (is (= (keywordify ["a" "b "]) [:a :b])))

(deftest structure-test
  (def headers [:a :b])
  (def body [[" a" " b"] [" foo " "bar "] ["qux" "mux "]])
  (is (= (structure headers body)
         [{:a "foo", :b "bar"} {:a "qux", :b "mux"}])))
