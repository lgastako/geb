(ns geb.platform)

(defn not-implemented [& args]
  (throw (ex-info "Not implemented." {:args (vec args)})))

(defn index-of [s x]
  (.indexOf s x))

(defn ends-with?
  "True if `s` ends with `x`, false otherwise."
  [s x]
  (.endsWith s x))

(defn starts-with?
  "True if `s` ends with `x`, false otherwise."
  [s x]
  (.startsWith s x))

(defn scontains? [s x]
  #?(:clj  (.contains s x)
     :cljs (> (.indexOf s x) -1)))

(defn sfirst
  "Returns the first character of string `s` as a string."
  [s]
  (subs s 0 1))

(defn srest
  "Returns the given string `s` without the first character."
  [s]
  (subs s 1))
