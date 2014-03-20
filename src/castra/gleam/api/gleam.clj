(ns gleam.api.gleam
  (:refer-clojure :exclude [defn])
  (:require [tailrecursion.castra :refer [defn ex error *session*]]))

(defn articles []
  (let [ingested (rand-int 300)
        fetched (rand-int 300)
        errored (rand-int 300)
        read (rand-int 300)]
    {:total (+ ingested fetched errored read)
     :ingested ingested
     :fetched fetched
     :errored errored
     :read read}))

(defn get-state []
  {:articles (articles)})
