(ns geb.core
  (:require [geb.platform :refer [ends-with? index-of not-implemented srest]]
            [geb.rules :as rule]
            [its.log :as log]))

(log/set-level! :debug)

(defn MI->MU []
  (-> "MI"           ;; MI
      rule/II        ;; MII
      rule/II        ;; MIIII
      rule/III       ;; MUI

      ))
