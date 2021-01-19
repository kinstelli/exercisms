(ns robot-simulator)

(def lturns {:east :north
             :north :west
             :west :south
             :south :east})

(def rturns {:east :south
             :south :west
             :west :north
             :north :east})

(defn turn-right [h]
  (get rturns h))

(defn turn-left [h]
  (get lturns h))

(defn advance [robbie]
  "returns new coords, based on existing coords"
  (let [curpos (:coordinates robbie)
        curbearing (:bearing robbie)]
    (case curbearing
      :west (update curpos :x dec)
      :east (update curpos :x inc)
      :north (update curpos :y inc)
      :south (update curpos :y dec))))

(defn robot [loc h]
  {:coordinates loc :bearing h})

(defn do-op [r op]
  (case op
    \R (robot (:coordinates r) (turn-right (:bearing r)))
    \L (robot (:coordinates r) (turn-left (:bearing r)))
    \A (robot (advance r) (:bearing r))))

(defn simulate [commands robot]
  (let [comvec (vec commands)]
    (reduce do-op robot comvec)))
