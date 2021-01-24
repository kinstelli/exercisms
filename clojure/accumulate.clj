(ns accumulate)

(defn accumulate [f col]
  (loop [remcol col
         acc []]
    (if (empty? remcol)
      acc
      (recur (rest remcol)
             (conj acc (f (first remcol)))))))
