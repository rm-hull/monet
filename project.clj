(defproject monet "0.1.0-SNAPSHOT"
  :description "A ClojureScript visual library"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojurescript "0.0-1236"]]
  :plugins [[lein-cljsbuild "0.2.1"]]
  :hooks [leiningen.cljsbuild]
  :source-path "no-clj-here"
  :cljsbuild {:builds
              {:main {:source-path "src"
                      :jar true}}})
