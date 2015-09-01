(defproject rm-hull/monet "0.2.2"
  :description "A ClojureScript visual library"
  :url "https://github.com/rm-hull/monet"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]]
  :plugins [
    [codox "0.8.13"]
    [lein-cljsbuild "1.1.0"]
  ]
  :source-path "no-clj-here"
  :cljsbuild {
    :builds [{:source-paths ["src"], :id "main", :jar true}]}
  :codox {
    :language :clojurescript
    :sources ["src"]
    :output-dir "doc/api"
    :src-dir-uri "http://github.com/rm-hull/monet/blob/master/"
    :src-linenum-anchor-prefix "L" }
  :min-lein-version "2.4.2"
  :global-vars {*warn-on-reflection* true})
