(ns monet.canvas
  "The canvas namespace provides functions which can be used for
   rendering graphs, game graphics, art, or othe visual images
   on the fly.

   See http://www.w3.org/TR/html5/scripting-1.html#the-canvas-element"
  (:require
    [monet.core :as core]))

;;*********************************************
;; Canvas drawing functions
;;*********************************************

(defn get-context [canvas type]
  (. canvas (getContext (name type))))

(defn begin-path
  "Starts a new path by resetting the list of sub-paths.
   Call this method when you want to create a new path."
  [ctx]
  (. ctx (beginPath))
  ctx)

(defn close-path
  "Tries to draw a straight line from the current point to the start.
   If the shape has already been closed or has only one point, this
   function does nothing."
  [ctx]
  (. ctx (closePath))
  ctx)

(defn fill
  "Fills the subpaths with the current fill style."
  [ctx]
  (. ctx (fill))
  ctx)

(defn stroke
  "Strokes the subpaths with the current stroke style."
  [ctx]
  (. ctx (stroke))
  ctx)

(defn clear-rect
  "Sets all pixels in the rectangle defined by starting point (x, y)
   and size (w, h) to transparent black."
  [ctx {:keys [x y w h]}]
  (. ctx (clearRect x y w h))
  ctx)

(defn ^:deprecated rect
  "DEPRECATED. Prefer fill-rect"
  [ctx {:keys [x y w h]}]
  (begin-path ctx)
  (. ctx (rect x y w h))
  (close-path ctx)
  (fill ctx)
  ctx)

(defn stroke-rect
  "Paints a rectangle which has a starting point at (x, y) and has a
   w width and an h height onto the canvas, using the current stroke
   style."
  [ctx {:keys [x y w h]}]
  (. ctx (strokeRect x y w h))
  ctx)

(defn fill-rect
  "Draws a filled rectangle at (x, y) position whose size is determined
   by width w and height h."
  [ctx {:keys [x y w h]}]
  (. ctx (fillRect x y w h))
  ctx)

(defn circle
  "Draws a circle at position (x, y) with radius r"
  [ctx {:keys [x y r]}]
  (begin-path ctx)
  (. ctx (arc x y r 0 (* (.-PI js/Math) 2) true))
  (close-path ctx)
  (fill ctx)
  ctx)

(defn text
  "Paints the given text at a starting point at (x, y), using the
   current stroke style."
  [ctx {:keys [text x y]}]
  (. ctx (fillText text x y))
  ctx)

(defn font-style
  "Sets the font. Default value 10px sans-serif."
  [ctx font]
  (set! (.-font ctx) font)
  ctx)

(defn fill-style
  "Color or style to use inside shapes. Default #000 (black)."
  [ctx color]
  (set! (.-fillStyle ctx) (name color))
  ctx)

(defn stroke-style
  "Color or style to use for the lines around shapes. Default #000 (black)."
  [ctx color]
  (set! (.-strokeStyle ctx) (name color))
  ctx)

(defn stroke-width
  "Sets the line width. Default 1.0"
  [ctx w]
  (set! (.-lineWidth ctx) w)
  ctx)

(defn stroke-cap
  "Sets the line cap. Possible values (as string or keyword):
   butt (default), round, square"
  [ctx cap]
  (set! (.-lineCap ctx) (name cap))
  ctx)

(defn stroke-join
  "Can be set, to change the line join style. Possible values (as string
   or keyword): bevel, round, and miter. Other values are ignored."
  [ctx join]
  (set! (.-lineJoin ctx) (name join))
  ctx)

(defn move-to
  "Moves the starting point of a new subpath to the (x, y) coordinates."
  [ctx x y]
  (. ctx (moveTo x y))
  ctx)

(defn line-to
  "Connects the last point in the subpath to the x, y coordinates with a
   straight line."
  [ctx x y]
  (. ctx (lineTo x y))
  ctx)

(defn alpha
  "Global Alpha value that is applied to shapes and images before they are
   composited onto the canvas. Default 1.0 (opaque)."
  [ctx a]
  (set! (.-globalAlpha ctx) a)
  ctx)

(defn composition-operation
  "With Global Alpha applied this sets how shapes and images are drawn
   onto the existing bitmap. Possible values (as string or keyword):
   source-atop, source-in, source-out, source-over (default),
   destination-atop, destination-in, destination-out, destination-over,
   lighter, darker, copy, xor"
  [ctx operation]
  (set! (.-globalCompositionOperation ctx) (name operation))
  ctx)

(defn text-align
  "Sets the text alignment attribute. Possible values (specified
   as a string or keyword): start (default), end, left, right or
   center."
  [ctx alignment]
  (set! (.-textAlign ctx) (name alignment))
  ctx)

(defn text-baseline
  "Sets the text baseline attribute. Possible values (specified
   as a string or keyword): top, hanging, middle, alphabetic (default),
   ideographic, bottom"
  [ctx alignment]
  (set! (.-textBaseline ctx) (name alignment))
  ctx)

(defn get-pixel
  "Gets the pixel value as a hash map of RGBA values"
  [ctx x y]
  (let [imgd (.-data (.getImageData ctx x y 1 1))]
      { :red   (aget imgd 0)
        :green (aget imgd 1)
        :blue  (aget imgd 2)
        :alpha (aget imgd 3)}))

(defn save
  "Saves the current drawing style state using a stack so you can revert
   any change you make to it using restore."
  [ctx]
  (. ctx (save))
  ctx)

(defn restore
  "Restores the drawing style state to the last element on the 'state stack'
   saved by save."
  [ctx]
  (. ctx (restore))
  ctx)

(defn rotate
  "Rotate the context "
  [ctx angle]
  (. ctx (rotate angle))
  ctx)

(defn scale
  "Scales the context by a floating-point factor in each direction"
  [ctx x y]
  (. ctx (scale x y))
  ctx)

(defn translate
  "Moves the origin point of the context to (x, y)."
  [ctx x y]
  (. ctx (translate x y))
  ctx)

(defn transform
  "Multiplies a custom transformation matrix to the existing
   HTML5 canvas transformation according to the follow convention:

   [ x']   [ m11 m21 dx ] [ x ]
   [ y'] = [ m12 m22 dy ] [ y ]
   [ 1 ]   [ 0   0   1  ] [ 1 ]"
  ([ctx m11 m12 m21 m22 dx dy]
    (. ctx (transform m11 m12 m21 m22 dx dy))
    ctx)
  ([ctx {:keys [m11 m12 m21 m22 dx dy]}]
    (. ctx (transform m11 m12 m21 m22 dx dy))
    ctx))

(defn draw-image
  "Draws the image onto the canvas at the given position.
   If a map of params is given, the number of entries is used to
   determine the underlying call to make."
  ([ctx img x y]
    (. ctx (drawImage img x y))
    ctx)
  ([ctx img {:keys [x y w h
                    sx sy sw sh dx dy dw dh] :as params}]
    (condp = (count params)
      2 (. ctx (drawImage img x y))
      4 (. ctx (drawImage img x y w h))
      8 (. ctx (drawImage img sx sy sw sh dx dy dw dh)))
      ctx))

(defn quadratic-curve-to
  ([ctx cpx cpy x y]
    (. ctx (quadraticCurveTo cpx cpy x y))
    ctx)
  ([ctx {:keys [cpx cpy x y]}]
    (. ctx (quadraticCurveTo cpx cpy x y))
    ctx))

(defn bezier-curve-to
  ([ctx cp1x cp1y cp2x cp2y x y]
    (. ctx (bezierCurveTo cp1x cp1y cp2x cp2y x y))
    ctx)
  ([ctx {:keys [cp1x cp1y cp2x cp2y x y]}]
    (. ctx (bezierCurveTo cp1x cp1y cp2x cp2y x y))
    ctx))

(defn rounded-rect [ctx {:keys [x y w h r]}]
  "Stroke a rectangle with rounded corners of radius r pixels."
  (-> ctx
      begin-path
      (move-to x (+ y r))
      (line-to x (- (+ y h) r))
      (quadratic-curve-to x (+ y h) (+ x r) (+ y h))
      (line-to (- (+ x w) r) (+ y h))
      (quadratic-curve-to (+ x w) (+ y h) (+ x w) (- (+ y h) r))
      (line-to (+ x w) (+ y r))
      (quadratic-curve-to (+ x w) y (- (+ x w) r) y)
      (line-to (+ x r) y)
      (quadratic-curve-to x y x (+ y r))
      stroke)
  ctx)

;;*********************************************
;; Canvas Entities
;;*********************************************

(defn add-entity [mc k ent]
  (aset (:entities mc) k ent))

(defn remove-entity [mc k]
  (js-delete (:entities mc) k))

(defn get-entity [mc k]
  (:value (aget (:entities mc) k)))

(defn update-entity [mc k func & extra]
  (let [cur (aget (:entities mc) k)
        res (apply func cur extra)]
    (aset (:entities mc) k res)))

(defn clear! [mc]
  (let [ks (js-keys (:entities mc))]
    (doseq [k ks]
      (remove-entity mc k))))

(defn entity [v update draw]
  {:value v
   :draw draw
   :update update})

(defn- attr [e a]
  (.getAttribute e a))

(defn draw-loop [{:keys [canvas updating? ctx active entities] :as mc}]
  (clear-rect ctx {:x 0 :y 0 :w (attr canvas "width") :h (attr canvas "height")})
  (when @active
    (let [ks (js-keys entities)
          cnt (alength ks)]
      (loop [i 0]
        (when (< i cnt)
          (let [k (aget ks i)
                {:keys [draw update value] :as ent} (aget entities k)]
            (when (and update @updating?)
              (let [updated (or (try (update value)
                                  (catch js/Error e
                                    (.log js/console e)
                                    value))
                                value)]
                (when (aget entities k)
                  (aset entities k (assoc ent :value updated)))))
            (when draw
              (try
                (draw ctx (:value (aget entities k)))
                (catch js/Error e
                  (.log js/console e))))
            (recur (inc i))))))
    (core/animation-frame #(draw-loop mc))))

(defn monet-canvas [elem context-type]
  (let [ct (or context-type "2d")
        ctx (get-context elem ct)]
    {:canvas elem
     :ctx ctx
     :entities (js-obj)
     :updating? (atom true)
     :active (atom true)}))

(defn init [canvas & [context-type]]
  (let [mc (monet-canvas canvas context-type)]
    ;;(update-loop mc)
    (draw-loop mc)
    mc))

(defn stop [mc] (reset! (:active mc) false))
(defn stop-updating [mc] (reset! (:updating? mc) false))
(defn start-updating [mc] (reset! (:updating? mc) true))
(defn restart [mc]
  (reset! (:active mc) true)
  ;;(update-loop mc)
  (draw-loop mc))
