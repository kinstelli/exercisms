(ns allergies)

(def allergens {1 :eggs
                2 :peanuts
                4 :shellfish
                8 :strawberries
                16 :tomatoes
                32 :chocolate
                64 :pollen
                128 :cats})

(defn allergies [s]
  (map #(get allergens %)
       (filter #(pos? (bit-and s %)) (keys allergens))))

(defn allergic-to? [x allergen]
  (and  (>= x (first (sort (keys allergens))))
        (some #(= allergen %) (allergies x))))



