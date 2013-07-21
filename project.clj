(defproject rm-hull/monet "0.1.8"
  :description "A ClojureScript visual library"
  :url "https://github.com/rm_hull/monet"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1844"]]
  :plugins [[lein-cljsbuild "0.2.9"]]
  :hooks [leiningen.cljsbuild]
  :source-path "no-clj-here"
  :cljsbuild {
    :builds [{:source-paths ["src"], :id "main", :jar true}]}
  :min-lein-version "2.2.0"
  :global-vars {*warn-on-reflection* true})
