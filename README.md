# monet [![Build Status](https://travis-ci.org/rm-hull/monet.svg?branch=master)](http://travis-ci.org/rm-hull/monet) [![Dependencies Status](https://jarkeeper.com/rm-hull/monet/status.svg)](https://jarkeeper.com/rm-hull/monet) [![Downloads](https://jarkeeper.com/rm-hull/monet/downloads.svg)](https://jarkeeper.com/rm-hull/monet) [![Clojars Project](https://img.shields.io/clojars/v/rm-hull/monet.svg)](https://clojars.org/rm-hull/monet)


monet is a small ClojureScript library to make it easier (and
performant) to work with canvas and visuals.

### Including in your project

There is a version hosted at [Clojars](https://clojars.org/rm-hull/monet).
For leiningen include a dependency:

```clojure
[rm-hull/monet "0.2.2"]
```

For maven-based projects, add the following to your `pom.xml`:

```xml
<dependency>
  <groupId>rm-hull</groupId>
  <artifactId>monet</artifactId>
  <version>0.2.2</version>
</dependency>
```
## Usage

```clojure
(ns game.core
  (:require [monet.canvas :as canvas])

(def canvas-dom (.getElementById js/document "canvas"))

(def monet-canvas (canvas/init canvas-dom "2d"))

(canvas/add-entity monet-canvas :background
                   (canvas/entity {:x 0 :y 0 :w 600 :h 600} ; val
                                  nil                       ; update function
                                  (fn [ctx val]             ; draw function
                                    (-> ctx
                                        (canvas/fill-style "#191d21")
                                        (canvas/fill-rect val)))))
```

## Documentation

See the [API Documentation](http://rm-hull.github.io/monet).

For more info on what the functions do look at the camel case versions
in JS docs (for example the
[mozilla developer network](https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/Canvas_tutorial?redirectlocale=en-US&redirectslug=Canvas_tutorial)).

Some futher usage details can be found in
[doc/GUIDE.md](https://github.com/rm-hull/monet/blob/master/doc/GUIDE.md)

## License

Copyright (C) 2011-14 Chris Granger, Richard Hull & others.

Distributed under the Eclipse Public License, the same as Clojure.
