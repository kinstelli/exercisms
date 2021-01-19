(ns kindergarten-garden)

(def roster [:alice :bob :charlie :david :eve :fred :ginny :harriet
             :ileana :joseph :kincaid :larry])

(def plantcodes {\V :violets
                 \R :radishes
                 \C :clover
                 \G :grass})

(defn letters->plants [c]
  (map #(get plantcodes %) c))

(defn keywordize-roster [ros]
  (sort
   (map #(if (keyword? %)
           %
           (-> %
               clojure.string/lower-case
               keyword))
        ros)))

(defn garden
  ([plantings]
   (garden plantings roster))
  ([plantings student-list]
   (let [students (keywordize-roster student-list)
         [row1 row2] (clojure.string/split-lines plantings)]
     (into {}
           (map (fn [s r1 r2]
                  {s (vec (letters->plants (concat r1 r2)))})
                students
                (partition 2 row1)
                (partition 2 row2))))))
