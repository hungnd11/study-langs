(ns octal)

(defn digit?
  [c]
  (and (>= 0 (compare \0 c))
       (>= 0 (compare c \7))))

(defn numeric?
  [s]
  (every? digit? s))

(defn to-decimal-iter
  [octal-string acc base]
  (let [c (last octal-string)]
    (if (= nil c)
      acc
      (to-decimal-iter (drop-last octal-string)
                       (+ acc (* (Character/digit c 10) base))
                       (* base 8)))))

(defn to-decimal
  [s]
  (if (numeric? s)
    (to-decimal-iter s 0 1)
    0))

;; Tests
(= 0 (to-decimal "8"))
(= 155 (to-decimal "233"))