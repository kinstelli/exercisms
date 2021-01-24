(ns strain)

(defn retain [f coll]
  (loop [kept []
         rem coll]
    (if (empty? rem)
      kept
      (recur (if (f (first rem))
               (conj kept (first rem))
               kept)
             (rest rem)))))

(defn discard [f coll]
  (retain (complement f) coll))
