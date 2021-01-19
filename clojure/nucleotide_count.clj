(ns nucleotide-count)

(def nucleotides #{\A \G \C \T})

(defn count-of-nucleotide-in-strand [n strand]
  (assert (contains? nucleotides n))
  (count  (filter #(= % n) strand)))

(defn nucleotide-counts [strand]
  (merge (zipmap nucleotides (repeat  0))
         (frequencies strand)))

