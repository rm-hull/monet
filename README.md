# monet [![Build Status](https://secure.travis-ci.org/rm-hull/monet.png)](http://travis-ci.org/rm-hull/monet)


monet is a small ClojureScript library to make it easier (and
performant) to work with canvas and visuals. 

## Usage

```clojure
(ns game.core
  (:require [monet.canvas :as canvas])

(canvas/add-entity :background
                   (canvas/entity {:x 0 :y 0 :w 600 :h 600}
                                  nil ;;update function
                                  (fn [ctx box]
                                    (-> ctx
                                        (canvas/fill-style "#191d21")
                                        (canvas/rect box)))))
(canvas/init (.get ($ :#canvas) 0))
```

## License

Copyright (C) 2011 Chris Granger

Distributed under the Eclipse Public License, the same as Clojure.


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/rm-hull/monet/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

