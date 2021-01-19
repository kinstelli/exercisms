(ns isbn-verifier)

(defn validformat? [s]
  (not (nil? (re-matches #"^[0-9]{9}[0-9X]$" s))))

(defn validarith? [iseq]
  (= 0
     (mod
      (reduce +
              (map (fn [i r]
                     (* r  (if (= i \X) 10
                               (Integer/parseInt (str i)))))
                   iseq
                   (reverse (range 11)))) 11)))

(defn isbn? [isbn]
  (let [iseq (clojure.string/replace isbn #"-" "")]
    (and (validformat? iseq) (validarith? iseq))))


