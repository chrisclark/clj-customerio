(ns clj-customerio.io-test
  (:require [clojure.test :refer :all]
            [clj-customerio.io :refer :all]))

;; #'clj-customerio.io/<fn> form enables access to private functions

(deftest in-coll?-true-test
  (is (= (#'clj-customerio.io/in-coll? ["c" "a"] ["a" "b" "c"]) true)))

(deftest in-coll?-false-test
  (is (= (#'clj-customerio.io/in-coll? ["d" "b"] ["a" "b" "c"]) false)))

(deftest trim-coll-test
  (is (= (#'clj-customerio.io/trim-coll ["a " "b" "  c "]) ["a" "b" "c"])))

(deftest keywordify-test
  (is (= (#'clj-customerio.io/keywordify ["a" "b "]) [:a :b])))

(deftest structure-test
  (def headers [:a :b])
  (def body [[" a" " b"] [" foo " "bar "] ["qux" "mux "]])
  (is (= (#'clj-customerio.io/structure headers body)
         [{:a "foo", :b "bar"} {:a "qux", :b "mux"}])))
