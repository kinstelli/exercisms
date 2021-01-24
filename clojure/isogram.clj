(ns isogram
  (:require [clojure.string :refer [lower-case]]))

(defn isogram? [w]
  (let [w (filter #(Character/isLetter %) (lower-case w))]
    (= (count (set w)) (count w))))
