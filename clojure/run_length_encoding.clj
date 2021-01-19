(ns run-length-encoding)

(defn run-length-encode [givenstr]
  (let [partitioned (partition-by identity  givenstr)]
    (apply str (map #(str (if (> (count  %) 1)
                            (str (count %) (first %))
                            (first %))) partitioned))))

(defn run-length-decode [given]
  (->> given
       (re-seq #"(\d*)([^\d])")
       (mapcat (fn [[_ ct ch]]
                 (if (empty? ct)
                   ch
                   (repeat (Integer/parseInt ct) ch))))
       (apply str)))



