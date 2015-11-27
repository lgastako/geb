(ns geb.core
  (:require [geb.mu :as mu]
            [its.log :as log]))

(log/set-level! :debug)

(log/info :mu/MI->MU (mu/MI->MU))
