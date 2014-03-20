(ns gleam.rpc
  (:require-macros
    [tailrecursion.javelin :refer [defc defc= cell=]])
  (:require [clojure.set           :as cs]
            [clojure.string        :as s]
            [tailrecursion.javelin :as j :refer [cell]]
            [tailrecursion.castra  :as c :refer [mkremote]]))

(set! cljs.core/*print-fn* #(.log js/console %))

(defc state {:articles {}})
(defc error nil)
(defc loading [])

(defc= articles (get state :articles))

(def get-state
  (mkremote 'gleam.api.gleam/get-state state error loading))

(defn init []
  (get-state)
  ;; Check every second for new data
  (js/setInterval get-state 1000))
