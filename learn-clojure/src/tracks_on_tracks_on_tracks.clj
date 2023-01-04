(ns tracks-on-tracks-on-tracks)

(defn new-list
  []
  (list))

(defn add-language
  [lang-list lang]
  (conj lang-list lang))

(defn first-language
  [lang-list]
  (first lang-list))

(defn remove-language
  [lang-list]
  (rest lang-list))

(defn count-languages
  [lang-list]
  (count lang-list))

(defn learning-list
  []
  (count-languages (add-language (add-language (remove-language (add-language (add-language (new-list) "Clojure") "Lisp")) "Java") "JavaScript")))