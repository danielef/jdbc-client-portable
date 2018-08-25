(ns jdbc-client-portable.core
  (:gen-class)
  (:require [clojure.java.jdbc :as j]
            [clojure.tools.cli :refer [parse-opts]]))

(def cli-options 
  [["-a" "--classname DRIVER" "Driver classname"]
   ["-b" "--subprotocol SUBPROTOCOL" "Subprotocol associated with driver"]
   ["-c" "--subname SUBNAME_PATH" "jdbcURL without prefix (//localhost:...)"]
   ["-u" "--user USERNAME" "Database user"]
   ["-p" "--password PASSWORD" "Database password"]
   ["-q" "--query QUERY" "Database query"]
   ["-h" "--help" "This usage print"]])

(defn -main[& args]
  (try
    (let [{:keys [options arguments summary errors]} (parse-opts args cli-options)
          {:keys [help query]} options]
      (if help
        (println summary))
      (if errors
        (println errors))
      
      (println (j/query (dissoc options :query :help)
                        [query])))
    (catch Exception e
      (.printStackTrace e))))
