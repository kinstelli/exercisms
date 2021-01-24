(ns proverb)

(defn for-want [[wanted lost]]
  (str "For want of a " wanted " the " lost " was lost.\n"))

(defn recite [items]
  (if (empty? items) ""
      (str (clojure.string/join (map for-want (partition 2 1 items)))
           "And all for the want of a " (first items) ".")))

