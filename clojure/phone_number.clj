(ns phone-number
  (:require [clojure.string :as str]))

(defn invalid-length? [d]
  (or (and (= (count d) 11)
           (not (= \1 (first d))))
      (and  (> (count d) 11))
      (< (count d) 7)))

(defn invalid-first-digit? [e]
  (or  (= \1 (first e))
       (= \0 (first e))))

(defn num-segs [num-string]
  (let [digits (filter #(Character/isDigit %) num-string)
        last10 (clojure.string/join (take-last 10 digits))
        area (subs last10 0 3)
        exchange (subs last10 3 6)
        suffix (subs last10 6)]
    (if (or (invalid-length? digits)
            (invalid-first-digit? area)
            (invalid-first-digit? exchange))
      {:area "000"
       :exchange "000"
       :suffix "0000"}
      {:area (str/join area)
       :exchange (str/join exchange)
       :suffix (str/join suffix)})))

(defn area-code [num-string]
  (:area (num-segs num-string)))

(defn number [num-string]
  (let [{:keys [area exchange suffix]} (num-segs num-string)]
    (str area exchange suffix)))

(defn pretty-print [num-string]
  (let [{:keys [area exchange suffix]} (num-segs num-string)]
    (format "(%s) %s-%s" area exchange suffix)))
