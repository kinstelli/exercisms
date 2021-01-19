(ns wordy)

(def ops {"plus" "+"
          "minus" "-"
          "divided by" "/"
          "multiplied by" "*"
          "What is" ""
          "?" ""})

(defn substitute [sentence]
  (clojure.string/replace sentence
                          #"plus|\?|minus|multiplied by|divided by|What is"
                          ops))

(defn do-operation [[op1 theop op2]]
  (let [op1 (Integer/parseInt op1)
        op2 (Integer/parseInt op2)
        op-f (case theop
               "+" +
               "-" -
               "/" /
               "*" *)]
    (op-f op1 op2)))

(defn evaluable?
  "argument fits the structure of a complete operation"
  [givenvec]
  (true? (and (= (count givenvec) 3)
              (number? (Integer/parseInt (first givenvec)))
              (clojure.string/includes? "+-*/" (second givenvec))
              (number? (Integer/parseInt (last givenvec))))))

(defn has-ops? [termsvec]
  (some #(clojure.string/includes? "+-*/" %) termsvec))

(defn evaluate [sentence]
  (let [terms-vec (re-seq #"\S+" (substitute sentence))]
    (if (not (has-ops? terms-vec))
      (throw (IllegalArgumentException.))
      (Integer/parseInt (first
                         (reduce (fn [res op]
                                   (if (evaluable? (conj res op))
                                     (conj [] (str (do-operation (conj res op))))
                                     (conj res op)))
                                 []
                                 terms-vec))))))
