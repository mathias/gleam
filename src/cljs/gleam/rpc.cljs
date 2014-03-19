(ns gleam.rpc
  (:require-macros
    [tailrecursion.javelin :refer [defc defc= cell=]])
  (:require
    [clojure.set           :as cs]
    [clojure.string        :as s]
    [tailrecursion.javelin :as j :refer [cell]]
    [tailrecursion.castra  :as c :refer [mkremote]]))

(set! cljs.core/*print-fn* #(.log js/console %))

(def articles {:total 422
               :ingested 419
               :fetched 0
               :errored 0
               :read 315})
