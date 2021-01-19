(ns luhn
  (:require [clojure.string :as st]))

(defn double-minus9
  "double the number. if it's more than 9, then subtract 9 from result"
  [n]
  (let [nn (* n 2)]
    (if (> nn 9)
      (- nn 9)
      nn)))

(defn string->intlist
  "accepts a string, removes non-nums, converts it into a list of ints"
  [s]
  (map #(Integer/parseInt (str %))
       (filter #(Character/isDigit %) s)))

(defn valid? [s]
  (let [no-ws (st/replace s #"\s" "")
        justnums (string->intlist no-ws)]
    (if (or (<= (count justnums) 1) ; false if not enough elements or had bad nums
            (not= (count no-ws) (count justnums)))
      false
      (= 0 (mod (reduce + (mapcat #(fn [[a b]]
                                     [a (double-minus9 b)])
                                  (partition 2 (reverse justnums)))) 10)))))
