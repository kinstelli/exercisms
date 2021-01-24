(ns roman-numerals)

(def num-to-roman {1000 "M"
                   900 "CM"
                   500 "D"
                   400 "CD"
                   100 "C"
                   90 "XC"
                   50 "L"
                   40 "XL"
                   10 "X"
                   9 "IX"
                   5 "V"
                   4 "IV"
                   1 "I"})

(defn numerals [thenum]
  (let [known-vals (reverse (sort (keys num-to-roman)))]
    (loop [remkeys known-vals
           rem thenum
           romanstr ""]
      (if (empty? remkeys)
        romanstr
        (let [n (first remkeys)]
          (if (>= rem n)
            (recur remkeys
                   (- rem n)
                   (str romanstr (get num-to-roman n)))
            (recur (rest remkeys)
                   rem
                   romanstr)))))))
