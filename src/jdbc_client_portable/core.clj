(ns jdbc-client-portable.core
  (:gen-class)
  (:require [clojure.java.jdbc :as j]))

(defn -main[& args]
  (try
    
    (catch Exception e
      (.printStackTrace e))))
