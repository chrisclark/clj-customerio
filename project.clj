(defproject clj-customerio "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [http-kit "2.1.18"]
                 [clojure-csv/clojure-csv "2.0.1"]
                 [org.clojure/tools.cli "0.3.1"]
                 [org.clojure/data.json "0.2.5"]]
  :main ^:skip-aot clj-customerio.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
