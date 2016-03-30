(defproject clj-customerio "0.1.1"
  :description "CLI tool to bulk upsert customer data from a csv file to customer.io"
  :url "http://example.com/FIXME"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.1.19"]
                 [clojure-csv/clojure-csv "2.0.2"]
                 [org.clojure/tools.cli "0.3.3"]
                 [org.clojure/data.json "0.2.6"]]
  :main ^:skip-aot clj-customerio.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
