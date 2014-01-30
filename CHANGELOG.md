Changelog
=========

0.1.10
------
* Updated clojurescript version (b2156) and lein-cljsbuild (1.0.1)
* Updated README.md docs (@joakin)
* Added clojars/pom section

0.1.9
-----
* Support the use of sprite sheets through sub-rectangle drawImage syntax (Matt Gauger)
* Latest clojurescript (b1934) and lein-cljsbuild
* Travis CI config

0.1.8
-----
* Updated clojurescript version
* Added rotate, bezier-curve-to threading functions

0.1.7
-----
* Leiningen 2.1.x reliance
* Deprecated monet.canvas/rect (replaced with fill-rect)

0.1.6
-----
* Added wrapper function for canvas matrix transformation
* Small bug fix - methods should return context
* Moved away from snapshot builds

0.1.5-SNAPSHOT
--------------
* Clojure 1.5.0 dependency
* Allows keywords to be specified (as well as strings) for functions like
  stroke-cap, text-align, eg.

  ```clojure
  (stroke-cap :square)
  ```

0.1.4-SNAPSHOT
--------------
* Merge osberts branch
* Update dependencies versions
