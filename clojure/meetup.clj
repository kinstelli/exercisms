(ns meetup
  (:require [java-time :as jt]))

(defn matches-day? [dayname ld]
  (= (jt/day-of-week dayname) (jt/day-of-week ld)))

(defn right-month? [m y ld]
  (= (jt/month (jt/local-date y m)) (jt/month ld)))

(defn teenth? [ld]
  (< 12 (.getDayOfMonth ld) 20))

(defn day-matches [dayname m y]
  (vec (take-while #(right-month? m y %)
                   (filter #(matches-day? dayname %)
                           (jt/iterate jt/plus (jt/local-date y m) (jt/days 1))))))

(defn ld->vec [ld]
  [(.getYear ld)
   (.getMonthValue ld)
   (.getDayOfMonth ld)])

(defn meetup [m y dayname whichday]
  (let [poss-dates (day-matches dayname m y)]
    (case whichday
      :first (ld->vec (first poss-dates))
      :second (ld->vec (second poss-dates))
      :teenth (ld->vec (first (filter teenth? poss-dates)))
      :third (ld->vec (nth poss-dates 2))
      :fourth (ld->vec (nth poss-dates 3))
      :last (ld->vec (last poss-dates))
      (throw (Exception. "Unknown day option keyword.")))))
