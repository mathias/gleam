#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.2.1"

(set-env!
  :dependencies (read-string (slurp "deps.edn"))
  :out-path     "resources/public"
  :src-paths    #{"src/hoplon" "src/castra" "src/cljs"})

;; Static assets
(add-sync! (get-env :out-path) #{"src/static"})

(require
  '[gleam.core :as gleam]
  '[tailrecursion.castra.handler   :as c]
  '[tailrecursion.boot.task.ring   :as r]
  '[tailrecursion.hoplon.boot      :refer :all]
  '[tailrecursion.boot.task.notify :refer :all])

(deftask castra
  [& specs]
  (r/ring-task (fn [_] (apply c/castra specs))))

(deftask server
  "Start castra dev server (port 8000)."
  []
  (comp (r/head) (r/dev-mode) (r/session-cookie) (r/files) (castra 'gleam.api.gleam) (r/jetty)))

(deftask gleam-app
  "Build the castra gleam app. Runs site on port 8000."
  []
  (comp (watch) (hoplon {:prerender false}) (server)))
