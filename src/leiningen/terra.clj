(ns leiningen.terra
  (:require [leiningen.core.eval :refer [eval-in-project]]))

(defn terra
  [project & args]
  (if-let [handler (-> project :terra :handler)]
    (eval-in-project project
                     `(do
                        (require (quote ~(symbol (namespace handler))))
                        (~handler)))
    (println "Terra: Warning! Can't find `:terra {:handler ...}` in `project.clj`")))
