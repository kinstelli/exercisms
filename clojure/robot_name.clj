(ns robot-name)

(def existing-names (atom #{}))

(defn gen-name []
  (let [n (format "%s%s%03d"
                  (char  (rand-nth (range 65 91)))
                  (char  (rand-nth (range 65 91)))
                  (rand-int 1000))]
    (if (not (contains? @existing-names n))
      (do (reset! existing-names (conj @existing-names n))
          n)
      (gen-name))))

(defn robot []
  (let [n (gen-name)]
    (atom n)))

(defn robot-name [robot]
  @robot)

(defn reset-name [robot]
  (reset! existing-names (disj @existing-names (robot-name robot)))
  (reset! robot (gen-name)))
