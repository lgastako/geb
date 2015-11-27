(ns geb.core
  (:require [geb.miu :as miu]
            [its.log :as log]))

(log/set-level! :debug)

(log/info :miu/MI->MU (miu/MI->MU))
