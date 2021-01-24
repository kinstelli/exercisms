(ns raindrops)

(defn convert [x]
  (let [res (str (if (zero? (mod x 3)) "Pling")
                 (if (zero? (mod x 5)) "Plang")
                 (if (zero? (mod x 7)) "Plong"))]
    (if (empty? res)
      (str x)
      res)))