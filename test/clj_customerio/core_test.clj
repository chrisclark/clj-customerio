(ns clj-customerio.core-test
  (:require [clojure.test :refer :all]
            [clj-customerio.core :refer :all]))


(deftest path-test
  (is (= (path {:id 123}) "https://track.customer.io/api/v1/customers/123")))
