(ns clock)

(defn clock->string [clock]
  (format "%02d:%02d" (:h clock) (:m clock)))

(defn clock [hours minutes]
  (let [m (mod minutes 60)
        m-rem (if (< minutes 0)
                (* -1 (quot (- 60 minutes) 60))
                (quot minutes 60))
        h (mod (+ hours m-rem) 24)]
    {:h h :m m}))

(defn add-time [oldclock time]
  (let [h (:h oldclock)
        m (+ (:m oldclock) time)]
    (clock h m)))
