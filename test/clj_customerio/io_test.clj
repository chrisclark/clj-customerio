(ns clj-customerio.io-test
  (:require [clojure.test :refer :all]
            [clj-customerio.io :refer :all]))

(deftest in-coll?-true-test
  (is (= (in-coll? ["c" "a"] ["a" "b" "c"]) true)))

(deftest in-coll?-false-test
  (is (= (in-coll? ["d" "b"] ["a" "b" "c"]) false)))

(deftest trim-coll-test
  (is (= (trim-coll ["a " "b" "  c "]) ["a" "b" "c"])))

(deftest keywordify-test
  (is (= (keywordify ["a" "b "]) [:a :b])))

(deftest structure-test
  (def headers [:a :b])
  (def body [[" a" " b"] [" foo " "bar "] ["qux" "mux "]])
  (is (= (structure headers body)
         [{:a "foo", :b "bar"} {:a "qux", :b "mux"}])))
