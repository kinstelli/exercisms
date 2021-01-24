(ns atbash-cipher
  (:require [clojure.string :refer [join lower-case]]))

(def all-lowers (map char (range 97 123)))
(def cipher (zipmap all-lowers (reverse all-lowers)))

(defn digit? [s]
  (Character/isDigit s))

(defn alphanumeric? [s]
  (or (Character/isDigit s) (Character/isLetter s)))

(defn part-by-5 [s]
  (join " " (map join (partition-all 5 s))))

(defn encode [s]
  (let [lstr (filter alphanumeric? (lower-case s))]
    (part-by-5 (map #(if (digit? %) % (get cipher %)) lstr))))