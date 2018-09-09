(ns jdbc-client-portable.core
  (:gen-class)
  (:require [clojure.data.json :as json]
            [clojure.java.jdbc :as j]
            [clojure.tools.cli :refer [parse-opts]]))

(def cli-options
  [["-T" "--dbtype DBTYPE" "type of the database (the jdbc subprotocol)"]
   ["-N" "--dbname DBNAME" "name of the database"]
   ["-c" "--classname DRIVER" "jdbc driver class name"]
   ["-H" "--host HOST" "host name/IP of the database"]
   ["-p" "--port PORT" "port of the database"]
   ["-U" "--user USERNAME" "database user"]
   ["-P" "--password PASSWORD" "database password"]
   ["-C" "--connection-uri URI" "subprotocol://user:password@host:port/subname"]
   ["-R" "--subprotocol SUBPROTOCOL" "subprotocol associated with driver"]
   ["-S" "--subname SUBNAME_PATH" "jdbcURL without prefix (//localhost:...)"]
   
   ["-Q" "--query QUERY" "database query"]
   ["-j" "--json" "prints result in JSON format"]
   ["-h" "--help" "this usage print"]])

(defn -main[& args]
  (try
    (let [{:keys [options arguments summary errors]} (parse-opts args cli-options)
          {:keys [help json query]} options
          db-params (dissoc options :query :help)]
      (if help
        (println summary))
      (if errors
        (println errors))
      (if query
        (println (cond-> (j/query db-params [query])
                   json (json/write-str)))
        (println (str "--query is nil\n" summary))))
    (catch Exception e
      (println (.getMessage e)))))
