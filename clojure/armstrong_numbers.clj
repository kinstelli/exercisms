(ns armstrong-numbers)

(defn num->digitsvec [num]
  (mapv #(Integer/parseInt (str %))
        (filter #(Character/isDigit %) (str num))))

(defn armstrong? [num]
  (let [digits (num->digitsvec num)
        numlen (count digits)
        pows (map #(.pow (biginteger %) numlen)
                  digits)]
    (= num (reduce + pows))))
