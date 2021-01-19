(ns say
  (:require [clojure.string :as str]))

(defn irreducible [d]
  (case d
    0 "zero "
    1 "one "
    2 "two "
    3 "three "
    4 "four "
    5 "five "
    6 "six "
    7 "seven "
    8 "eight "
    9 "nine "
    10 "ten"
    11 "eleven"
    12 "twelve"
    13 "thirteen"
    14 "fourteen"
    15 "fifteen"
    16 "sixteen"
    17 "seventeen"
    18 "eighteen"
    19 "nineteen"
    ;else
    ""))

(defn tens [x]
  (cond
    (> x 90)
    {:word "ninety-"
     :quotient 0
     :remainder (mod x 90)}
    (= x 90)
    {:word "ninety"
     :quotient 0
     :remainder 0}
    (> x 80)
    {:word "eighty-"
     :quotient 0
     :remainder (mod x 80)}
    (= x 80)
    {:word "eighty"
     :quotient 0
     :remainder 0}
    (> x 70)
    {:word "seventy-"
     :quotient 0
     :remainder (mod x 70)}
    (= x 70)
    {:word "seventy"
     :quotient 0
     :remainder 0}
    (> x 60)
    {:word "sixty-"
     :quotient 0
     :remainder (mod x 60)}
    (= x 60)
    {:word "sixty"
     :quotient 0
     :remainder 0}
    (>= x 50)
    {:word "fifty-"
     :quotient 0
     :remainder (mod x 50)}
    (= x 50)
    {:word "fifty"
     :quotient 0
     :remainder 0}
    (> x 40)
    {:word "forty-"
     :quotient 0
     :remainder (mod x 40)}
    (= x 40)
    {:word "forty"
     :quotient 0
     :remainder 0}
    (> x 30)
    {:word "thirty-"
     :quotient 0
     :remainder (mod x 30)}
    (= x 30)
    {:word "thirty"
     :quotient 0
     :remainder 0}
    (> x 20)
    {:word "twenty-"
     :quotient 0
     :remainder (mod x 20)}
    (= x 20)
    {:word "twenty"
     :quotient 0
     :remainder (mod x 20)}
    :else
    {:word (irreducible x)
     :quotient 0
     :remainder 0}))

(defn num-places [x]
  (cond
    (< x 0)
    (throw (IllegalArgumentException. "Number is too low"))

    (> x 999999999999)
    (throw (IllegalArgumentException. "Number is too high"))

    (>= x 1000000000000)
    {:word "trillion "
     :quotient (quot x 1000000000000)
     :remainder (mod x 1000000000000)}

    (>= x 1000000000)
    {:word "billion "
     :quotient (quot x 1000000000)
     :remainder (mod x 1000000000)}

    (>= x 1000000)
    {:word "million "
     :quotient (quot x 1000000)
     :remainder (mod x 1000000)}

    (>= x 1000)
    {:word "thousand "
     :quotient (quot x 1000)
     :remainder (mod x 1000)}

    (>= x 100)
    {:word "hundred "
     :quotient (quot x 100)
     :remainder (mod x 100)}

    (< x 100)
    (tens x)))

(defn collect-words
  [given-num]
  (loop [word-str nil
         rem-num given-num]
    (cond (< rem-num 0)
          (throw (IllegalArgumentException. "Number is too low"))
          (= rem-num 0)
          word-str
          :else
          (let [trans-res (num-places rem-num)]
            (recur (str word-str (collect-words (:quotient trans-res)) (:word trans-res))
                   (:remainder trans-res))))))

(defn number [given-num]
  (let [word-res (collect-words given-num)]
    (str/trim (if word-res
                word-res
                "zero"))))
