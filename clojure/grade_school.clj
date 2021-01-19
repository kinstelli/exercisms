(ns grade-school)

(defn grade [school grade]
  (or (get school grade) []))

(defn add [school name grade]
  (merge-with into school
              {grade [name]}))

(defn sorted [school]
  (into (sorted-map)
        (map (fn [k]
               {k (sort (grade school k))}) (keys school))))
