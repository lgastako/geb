(ns geb.mu.validators
  (:require [geb.platform :refer [ends-with? scontains? starts-with?]]))

(defn I [s]
  (when-not (ends-with? s "I")
    (throw (ex-info "Cannot apply rule to a string that does not end in `I`."
                    {:rule "I"
                     :s s}))))

(defn II [s]
  (when-not (starts-with? s "M")
    (throw (ex-info "Cannot apply rule to a string that does not begin with `M`. "
                    {:rule "II"
                     :s s}))))

(defn III [s n]
  (when-not (> (count (re-seq #"III" s)) n)
    (throw (ex-info "Less than `n` instances of `III` in string."
                    {:rule "III"
                     :s s
                     :n n}))))

(defn IV [s n]
  (when-not (> (count (re-seq #"UU" s)) n)
    (throw (ex-info "Less than `n` instances of `UU` in string."
                    {:rule "IV"
                     :s s
                     :n n}))))
