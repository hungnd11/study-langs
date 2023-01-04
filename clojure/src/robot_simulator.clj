(ns robot-simulator)

(def NORTH [0 1])

(def EAST  [1 0])

(def SOUTH [0 -1])

(def WEST  [-1 0])

(defn get-dxdy
  [bearing]
  (cond
    (= bearing :north) NORTH
    (= bearing :east)  EAST
    (= bearing :south) SOUTH
    (= bearing :west)  WEST
    :else [0 0]))

(defn robot
  [coord bearing]
  {:coordinates coord :bearing bearing})

(defn turn-right
  [bearing]
  (cond
    (= bearing :north) :east
    (= bearing :east)  :south
    (= bearing :south) :west
    (= bearing :west)  :north
    :else bearing))

(defn turn-left
  [bearing]
  (cond
    (= bearing :north) :west
    (= bearing :east)  :north
    (= bearing :south) :east
    (= bearing :west)  :south
    :else bearing))

(defn simulate
  [instruction r]
  (let [i (first instruction)]
    (cond
      (= i \R)  (simulate (rest instruction) {:bearing (turn-right (:bearing r)) :coordinates (:coordinates r)})
      (= i \L)  (simulate (rest instruction) {:bearing (turn-left  (:bearing r)) :coordinates (:coordinates r)})
      (= i \A)  (simulate (rest instruction) (let [[dx dy] (get-dxdy (:bearing r))]
                                               {:bearing (:bearing r)
                                                :coordinates {:x (+ (:x (:coordinates r)) dx)
                                                              :y (+ (:y (:coordinates r)) dy)}}))
      :else r)))