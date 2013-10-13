(defproject rm-hull/monet "0.1.9-SNAPSHOT"
  :description "A ClojureScript visual library"
  :url "https://github.com/rm_hull/monet"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"]]
  :plugins [[lein-cljsbuild "0.3.3"]]
  :hooks [leiningen.cljsbuild]
  :source-path "no-clj-here"
  :cljsbuild {
    :builds [{:source-paths ["src"], :id "main", :jar true}]}
  :min-lein-version "2.3.2"
  :global-vars {*warn-on-reflection* true})
