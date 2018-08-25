(defproject jdbc-client-portable "0.1-SNAPSHOT"
  :description "Small JDBC SQL Client"
  :url "https://github.com/danielef/jdbc-client-portable"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/java.jdbc "0.7.8"]
                 [org.clojure/tools.cli "0.3.7"]]
  :main jdbc-client-portable.core
  :aot [jdbc-client-portable.core])
