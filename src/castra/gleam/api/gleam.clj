(ns gleam.api.gleam
  (:refer-clojure :exclude [defn])
  (:require [tailrecursion.castra :refer [defn ex error *session*]]))

(def articles {:total 422
               :ingested 419
               :fetched 0
               :errored 0
               :read 315})

(defn get-state []
  {:articles articles})
