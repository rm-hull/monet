# monet [![Build Status](https://secure.travis-ci.org/rm-hull/monet.png)](http://travis-ci.org/rm-hull/monet)

monet is a small ClojureScript library to make it easier (and
performant) to work with canvas and visuals.

## Usage

```clojure
(ns game.core
  (:require [monet.canvas :as canvas])

(def canvas-dom (.getElementById js/document "#canvas"))

(def monet-canvas (canvas/init canvas-dom "2d"))

(canvas/add-entity monet-canvas :background
                   (canvas/entity {:x 0 :y 0 :w 600 :h 600} ; val
                                  nil                       ; update function
                                  (fn [ctx val]             ; draw function
                                    (-> ctx
                                        (canvas/fill-style "#191d21")
                                        (canvas/fill-rect val)))))
```

## Api

## monet.core

#### `animation-frame [fn]`
Sets a loop calling `fn` at 60fps

## monet.canvas

Inside `monet.canvas` there two types of functions. Ones for manipulating the
canvas and entities the monet way, and the others are a straight API to the JS
canvas functions.

### Monet canvas and entities

These are monet specific functions for handling canvas drawing and animation
the monet way.

The usual workflow is calling `init` and getting the monet-canvas that returns,
and then start adding entities with `add-entity`. An entity can be created with
the `entity` function.

#### `add-entity [mc k ent]`

#### `remove-entity [mc k]`

#### `get-entity [mc k]`

#### `update-entity [mc k func & extra]`

#### `clear! [mc]`

#### `entity [v update draw]`
Returns a entity map

    {:value v
     :draw draw
     :update update})

#### `draw-loop [{:keys [canvas updating? ctx active entities] :as mc}]`
Bare draw loop, handled by `init` `restart` `stop` `stop-updating`
`start-updating`. No need to manipulate it directly.

#### `monet-canvas [elem context-type]`
Context type defaults to 2d.

    {:canvas elem
     :ctx ctx
     :entities (js-obj)
     :updating? (atom true)
     :active (atom true)}

#### `init [canvas & [context-type]]`
Initializes and returns a monet-canvas based on the `canvas` dom element and
the context-type passed.

#### `stop [mc]`
Stops the canvas animation and loop. To restart use `restart`

#### `restart [mc]`
Reactivates a stopped monet-canvas.

#### `stop-updating [mc]`
Stops updating the entities on each loop tick.

#### `start-updating [mc]`
Starts updating the entities on each loop tick.

### Canvas drawing functions

Idiomatic clojure functions to canvas API. Unless specified, they return the
received context for chaining purposes

For more info on what the functions do look at the camel case versions in JS
docs (for example the [mozilla developer network](https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/Canvas_tutorial?redirectlocale=en-US&redirectslug=Canvas_tutorial))

In parameters `ctx` refers to a dom canvas object in function signatures.


#### `get-context [canvas type]`
Returns the CanvasRenderingContext of a dom canvas element.
`type` has to be one of '2d' or '3d'

#### `begin-path [ctx]`

#### `close-path [ctx]`

#### `fill [ctx]`

#### `stroke [ctx]`

#### `clear-rect [ctx {:keys [x y w h]}]`

#### `stroke-rect [ctx {:keys [x y w h]}]`

#### `fill-rect [ctx {:keys [x y w h]}]`

#### `circle [ctx {:keys [x y r]}]`

#### `text [ctx {:keys [text x y]}]`

#### `font-style [ctx font]`

#### `fill-style [ctx color]`

#### `stroke-style [ctx color]`

#### `stroke-width [ctx w]`

#### `stroke-cap [ctx cap]`

#### `move-to [ctx x y]`

#### `line-to [ctx x y]`

#### `alpha [ctx a]`

#### `composition-operation [ctx operation]`
Accepts keyword or string as operation

#### `text-align [ctx alignment]`
Accepts keyword or string as alignment

#### `text-baseline [ctx alignment]`
Accepts keyword or string as alignment

#### `get-pixel [ctx x y]`
Gets the pixel value as a hash map of RGBA values
Ex: ` {:red 0 :green 0 :blue 0 :alpha 0}`

#### `save [ctx]`

#### `restore [ctx]`

#### `rotate [ctx angle]`

#### `scale [ctx x y]`

#### `translate [ctx x y]`

#### `transform`
```
transform
  [ctx m11 m12 m21 m22 dx dy]
  [ctx {:keys [m11 m12 m21 m22 dx dy]}]
```
Multiplies a custom transformation matrix to the existing
HTML5 canvas transformation according to the follow convention:

    [ x']   [ m11 m21 dx ] [ x ]
    [ y'] = [ m12 m22 dy ] [ y ]
    [ 1 ]   [ 0   0   1  ] [ 1 ]


#### `draw-image`
```
draw-image
  [ctx img x y]
  [ctx img {:keys [x y] :as params}]
  [ctx img {:keys [x y w h] :as params}]
  [ctx img {:keys [sx sy sw sh dx dy dw dh] :as params}]
```
Draws the image onto the canvas at the given position.
If a map of params is given, the number of entries is used to
determine the underlying call to make.

#### `quadratic-curve-to`
```
quadratic-curve-to
  [ctx cpx cpy x y]
  [ctx {:keys [cpx cpy x y]}]
```

#### `bezier-curve-to`
```
bezier-curve-to
  [ctx cp1x cp1y cp2x cp2y x y]
  [ctx {:keys [cp1x cp1y cp2x cp2y x y]}]
```

#### `rounded-rect [ctx {:keys [x y w h r]}]`
Stroke a rectangle with rounded corners of radius r pixels.


## monet.geometry

### Pathing functions

#### `distance [origin target]`

### Bounding functions

#### `bottom-right [{:keys [x y w h r]}]`

#### `top-left [{:keys [x y r]}]`

#### `in-radius? [origin obj radius]`

#### `collision? [obj obj2]`

#### `contained? [container obj]`

#### `in-bounds? [obj x2 y2]`


## License

Copyright (C) 2011 Chris Granger

Distributed under the Eclipse Public License, the same as Clojure.


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/rm-hull/monet/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

