(ns bob
  (:require [clojure.string :as str]))

(defn question? [s]
  (= \? (last s)))

(defn nothing? [s]
  (re-matches #"^\s*$" s))

(defn yelling? [s]
  (and (= s (str/upper-case s))
       (re-find #"[A-Z]{1,}" s)))

(defn response-for [s]
  (let [s (str/trim s)]
    (cond
      (and (yelling? s) (question? s)) "Calm down, I know what I'm doing!"
      (yelling? s) "Whoa, chill out!"
      (question? s) "Sure."
      (nothing? s) "Fine. Be that way!"
      :else "Whatever.")))
