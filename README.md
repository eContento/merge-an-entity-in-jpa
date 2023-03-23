# Merge an entity in JPA

This project uses Quarkus ( https://quarkus.io/)

When a parent entity whith three childs (oneToMany relationship)  (1,2,3) and i want to update with (1,2,5), it must update 1 and 2, insert 5, and remove 3. 

Test to try merge and learn how it works.


## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvn compile quarkus:dev
```


## Related Guides

- Flyway ([guide](https://quarkus.io/guides/flyway)): Handle your database schema migrations
- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, JPA)
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
