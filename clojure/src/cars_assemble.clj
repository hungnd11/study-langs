(ns cars-assemble)

(defn success-rate [speed]
  (cond (= speed 10) 0.77
        (= speed 9) 0.8
        (>= speed 5) 0.9
        :else 1.0))

(def default-rate 221.0)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (* (* default-rate (success-rate speed)) (double speed)))