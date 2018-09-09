# jdbc-client-portable
Small JDBC SQL Client 

### Building
```
$ lein uberjar
```

### Running
```
$ bin/jdbc-portable
Verifying JAVA installation ...
Using JVM installed on : /Library/Java/JavaVirtualMachines/jdk-10.jdk/Contents/Home/bin/java ...
--query is nil
  -T, --dbtype DBTYPE            type of the database (the jdbc subprotocol)
  -N, --dbname DBNAME            name of the database
  -c, --classname DRIVER         jdbc driver class name
  -H, --host HOST                host name/IP of the database
  -p, --port PORT                port of the database
  -U, --user USERNAME            database user
  -P, --password PASSWORD        database password
  -C, --connection-uri URI       subprotocol://user:password@host:port/subname
  -R, --subprotocol SUBPROTOCOL  subprotocol associated with driver
  -S, --subname SUBNAME_PATH     jdbcURL without prefix (//localhost:...)
  -Q, --query QUERY              database query
  -j, --json                     prints result in JSON format
  -h, --help                     this usage print
```

## Querying
```
$ bin/jdbc-portable --dbtype postgresql --dbname postgres --host localhost --user postgres --password postgres --query "select * from pg_user"
({:usename postgres, :usesysid 10, :usecreatedb true, :usesuper true, :userepl true, :usebypassrls true, :passwd ********, :valuntil nil, :useconfig nil} {:usename cpagos, :usesysid 16385, :usecreatedb false, :usesuper false, :userepl false, :usebypassrls false, :passwd ********, :valuntil nil, :useconfig nil})
```

## JSON Output
Using `--json` and python for pretty print
```
$ bin/jdbc-portable --dbtype postgresql --dbname postgres --host localhost --user postgres --password postgres --json --query "select * from pg_user" | python -m json.tool
[
    {
        "passwd": "********",
        "usebypassrls": true,
        "useconfig": null,
        "usecreatedb": true,
        "usename": "postgres",
        "userepl": true,
        "usesuper": true,
        "usesysid": 10,
        "valuntil": null
    },
    {
        "passwd": "********",
        "usebypassrls": false,
        "useconfig": null,
        "usecreatedb": false,
        "usename": "cpagos",
        "userepl": false,
        "usesuper": false,
        "usesysid": 16385,
        "valuntil": null
    }
]
```

## Drivers
Must be placed in `lib/` or `target/` directory
```
$ ls target
$ ls -l target/
total 11720
drwxr-xr-x  5 dan  staff      160 Aug 28 12:07 classes
-rw-r--r--  1 dan  staff  4785799 Aug 28 12:07 jdbc-client-portable-0.1-SNAPSHOT-standalone.jar
-rw-r--r--  1 dan  staff   395545 Aug 28 12:07 jdbc-client-portable-0.1-SNAPSHOT.jar
-rw-r--r--@ 1 dan  staff   814992 Sep  7 00:33 postgresql-42.2.4.jar
```
