(defproject rm-hull/monet "0.3.0"
  :description "A ClojureScript visual library"
  :url "https://github.com/rm-hull/monet"
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [org.clojure/clojurescript "1.8.51"]]
  :plugins [
    [codox "0.9.5"]
    [lein-codox "0.9.5"]
    [lein-cljsbuild "1.1.3"]]
  :source-path "no-clj-here"
  :cljsbuild {
    :builds [{
      :source-paths ["src"]
      :id "main"
      :jar true}]}
  :codox {
    :language :clojurescript
    :sources ["src"]
    :output-dir "doc/api"
    :src-dir-uri "http://github.com/rm-hull/monet/blob/master/"
    :src-linenum-anchor-prefix "L" }
  :min-lein-version "2.6.1"
  :global-vars {*warn-on-reflection* true})
