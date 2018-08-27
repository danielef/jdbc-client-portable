# jdbc-client-portable
Small JDBC SQL Client 


Building
```
lein uberjar
```

Help `-h` or `--help`
```
java -cp .:./target/jdbc-client-portable-0.1-SNAPSHOT-standalone.jar jdbc_client_portable.core -h
```

Adding drivers & querying
```
java -cp ".:./target/jdbc-client-portable-0.1-SNAPSHOT-standalone.jar:$HOME/Downloads/postgresql-42.2.4.jar" jdbc_client_portable.core --dbtype postgresql --dbname COMPLEMENTO_PAGOS --host localhost --user postgres --password postgres --query "select * from bepagos.transfer_control"
```
