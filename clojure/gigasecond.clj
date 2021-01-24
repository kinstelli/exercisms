(ns gigasecond)

(def gigasec 1000000000)

; pretending clj-time doesnt exist :(
; and using built-in, modern Java options....
(defn from [y m d]
  (let [thedate (java.time.LocalDate/of y m d)
        epochsecs (.toEpochSecond thedate java.time.LocalTime/NOON java.time.ZoneOffset/MIN)
        newlocaldt (java.time.LocalDateTime/ofInstant
                    (java.time.Instant/ofEpochSecond (+ gigasec epochsecs))
                    java.time.ZoneOffset/MIN)]
    [(.getYear newlocaldt) (.getMonthValue newlocaldt) (.getDayOfMonth newlocaldt)]))

; TODO: use Java calendar instead?
; or just clj-time...












