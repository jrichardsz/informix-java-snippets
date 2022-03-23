# Informix java snippets


## Requirements

### Informix 14

```
docker run -it --name iif_developer_edition --privileged  \
-p 9088:9088  -p 9089:9089 -p 27017:27017 -p 27018:27018 \
-p 27883:27883 -e LICENSE=accept  \
ibmcom/informix-developer-database:latest
```

- default db name : sysmaster
- default username: informix
- default password: in4mix

Tables for test: https://www.ibm.com/docs/da/informix-servers/14.10?topic=database-use-create-table

```
CREATE TABLE person
   (
   rec_num  SERIAL PRIMARY KEY,
   lname    CHAR(20),
   fname    CHAR(20),
   bdate    DATE,
   anniv    DATE,
   email    VARCHAR(25)
   );
```

### Java driver

https://mvnrepository.com/artifact/com.ibm.informix/jdbc/4.50.7.1


## Jdbc url


```
jdbc:informix-sqli://localhost:9088/sysmaster:INFORMIXSERVER=informix;
jdbc:informix-sqli://{host}:{port}/{database}:INFORMIXSERVER={server}
```

## Samples

|name|description|
|--|--|
|jdbc/src/main/java/SimpleConnection.java|Should return the database info in the shell "IBM Informix Dynamic Server Version 14.10.FC7W1DE"|
|jdbc/src/main/java/SimpleSelect.java|Show the rows of person table|
|jdbc/src/main/java/SimpleInsert.java|Inser a row on person table|


## references

- https://github.com/informix/informix-dockerhub-readme/blob/master/14.10.FC7W1/informix-developer-database.md
- https://stackoverflow.com/questions/21572185/informix-jdbc-stuck-connecting
- https://github.com/informix/informix-dockerhub-readme/blob/master/12.10.FC9/informix-developer-database.md
- https://github.com/informix/informix-db-examples/tree/master/sql/ifx-springboot
- https://github.com/informix/informix-dockerhub-readme/issues/3
