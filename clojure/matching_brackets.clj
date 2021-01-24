(ns matching-brackets
  (:require [clojure.string :refer [includes?]]))

(def openers "([{")
(def closers "}])")
(def mates {"}" "{", ")" "(", "]" "["})

(defn valid? [given]
  (loop [pstack []
         remchars (map str given)
         the-res true]
    (if (empty? remchars)
      (and  (empty? pstack) the-res)
      (let [c (first remchars)]
        (cond (includes? openers c)
              (recur (conj (vec pstack) c) (rest remchars) the-res)
              (and (includes? closers c) (= (last pstack) (get mates c)))
              (recur (butlast pstack) (rest remchars) the-res)
              (and (includes? closers c) (not= (last pstack) (get mates c)))
              (recur pstack [] false) ;; curtail recurrences
              :else
              (recur pstack (rest remchars) the-res))))))

