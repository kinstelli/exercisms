(ns protein-translation
  (:require [clojure.string :refer [join]]))

(def known-proteins {"AUG" "Methionine"
                     "UUU" "Phenylalanine"
                     "UUC" "Phenylalanine"
                     "UUA" "Leucine"
                     "UUG" "Leucine"
                     "UCU" "Serine"
                     "UCC" "Serine"
                     "UCA" "Serine"
                     "UCG" "Serine"
                     "UAU" "Tyrosine"
                     "UAC" "Tyrosine"
                     "UGU" "Cysteine"
                     "UGC" "Cysteine"
                     "UGG" "Tryptophan"
                     "UAA" "STOP"
                     "UAG" "STOP"
                     "UGA" "STOP"})

(defn translate-codon [c]
  (get known-proteins c))

(defn notstop? [w]
  (not= "STOP" w))

(defn translate-rna [rna]
  (->> rna
       (partition 3)
       (map join)
       (map translate-codon)
       (take-while notstop?)))
