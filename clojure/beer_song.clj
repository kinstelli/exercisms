(ns beer-song)

(defn bottle-bottles [n]
  (if (= 1 n) "bottle" "bottles"))

(defn how-many [n]
  (if (= n 0) "no more" n))

(defn one-or-it [n]
  (if (= n 1) "it" "one"))

(defn std-verse [n]
  (format (str
           "%s %s of beer on the wall, %s %s of beer.\n"
           "Take %s down and pass it around, %s %s of beer on the wall.\n")
          (how-many n) (bottle-bottles n)
          (how-many n) (bottle-bottles n) (one-or-it n)
          (how-many (dec n)) (bottle-bottles (dec n))))

(defn end-verse []
  (str "No more bottles of beer on the wall, no more bottles of beer.\n"
       "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (cond
    (>= num 1) (std-verse num)
    (= num 0) (end-verse)))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]
   (sing start 0))
  ([start end]
   (clojure.string/join "\n" (map verse (reverse (range end (inc start)))))))

