(defproject rm-hull/monet "0.1.10"
  :description "A ClojureScript visual library"
  :url "https://github.com/rm_hull/monet"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2156"]]
  :plugins [[lein-cljsbuild "1.0.1"]]
  :source-path "no-clj-here"
  :cljsbuild {
    :builds [{:source-paths ["src"], :id "main", :jar true}]}
  :min-lein-version "2.3.4"
  :global-vars {*warn-on-reflection* true})
