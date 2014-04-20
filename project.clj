(defproject rm-hull/monet "0.1.12"
  :description "A ClojureScript visual library"
  :url "https://github.com/rm_hull/monet"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2202"]]
  :plugins [
    [codox "0.6.7"]
    [lein-cljsbuild "1.0.3"]
  ]
  :source-path "no-clj-here"
  :cljsbuild {
    :builds [{:source-paths ["src"], :id "main", :jar true}]}
  :codox {
    :sources ["src"]
    :output-dir "doc/api"
    :src-dir-uri "http://github.com/rm-hull/monet/blob/master/"
    :src-linenum-anchor-prefix "L" }
  :min-lein-version "2.3.4"
  :global-vars {*warn-on-reflection* true})
