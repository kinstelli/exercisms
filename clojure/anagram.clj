(ns anagram
  (:require [clojure.string :as s]))

(defn anagrams-for [word prospect-list]
  (filter #(and
            (not (=
                  (s/lower-case word)
                  (s/lower-case %)))
            (= (sort (s/lower-case %))
               (sort (s/lower-case word))))
          prospect-list))


