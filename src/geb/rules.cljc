(ns geb.rules
  (:require [geb.platform :refer [ends-with? index-of not-implemented srest]]
            [geb.validators :as validate]
            [its.log :as log]))

(log/set-level! :debug)

(defn I [s]
  (validate/I s)
  (str s "U"))

(defn II [s]
  (validate/II s)
  (str s (srest s)))

(defn III
  ([s]
   (III s 0))
  ([s n]
   (validate/III s n)
   (let [target "III"]
     (loop [left ""
            right s
            m n]
       (if (< m 0)
         (throw (ex-info "Unexpected negative `m`."
                         {:s s :n n :left left :right right :m m}))
         (let [idx (index-of right target)]
           (if (= m 0)
             (str left
                  (subs right 0 idx)
                  "U"
                  (subs right (+ idx 3)))
             (recur (str left (subs right 0 idx))
                    (subs right idx)
                    (dec m)))))))))

(defn IV
  ([s]
   (IV s 0))
  ([s n]
   (validate/IV s n)
   (let [target "UU"]
     (loop [left ""
            right s
            m n]
       (if (< m 0)
         (throw (ex-info "Unexpected negative `m`."
                         {:s s :n n :left left :right right :m m}))
         (let [idx (index-of right target)]
           (if (= m 0)
             (str left
                  (subs right 0 idx)
                  (subs right (+ idx 2)))
             (recur (str left (subs right 0 idx))
                    (subs right idx)
                    (dec m)))))))))
