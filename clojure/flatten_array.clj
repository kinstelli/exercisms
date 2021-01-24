(ns flatten-array)

(defn flatten [arr]
  (reduce (fn [coll x]
            (if (seqable? x)
              (if (seq x)
                (concat coll (flatten x))
                coll)
              (conj (vec coll) x))) [] arr))
