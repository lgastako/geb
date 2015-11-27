(ns geb.mu
  (:require [geb.mu.rules :as rule]))

(defn MI->MU []
  (-> "MI"           ;; MI
      rule/II        ;; MII
      rule/II        ;; MIIII
      rule/III       ;; MUI

      ))
