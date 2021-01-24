(ns pangram)

(defn haschar? [a-vec c]
  (some #(= c %) a-vec))

(defn pangram? [sentence]
  (let [all-lower-chars (map char (range 97 123))
        lowervec (vec (clojure.string/lower-case sentence))]
    (every? #(haschar? lowervec %) all-lower-chars)))