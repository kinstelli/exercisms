(ns rna-transcription)

(def pairs {\A \U
            \T \A
            \C \G
            \G \C})

(defn to-rna [dna]
  (apply str
         (map (fn [p]
                (assert (contains? pairs p))
                (get pairs p))
              dna)))