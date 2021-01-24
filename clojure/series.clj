(ns series
  (:require [clojure.string :refer [join]]))

(defn slices [string len]
  (->> string
       (partition len 1)
       (distinct)
       (mapv join)))
