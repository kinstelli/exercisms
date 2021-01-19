(ns reverse-string)

(defn reverse-string [s]
  (reduce (fn [v ltr]
            (str ltr v)) "" s))
