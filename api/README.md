1. In pgAdmin, right click on `Servers` and select `Create new sever`

2. Set Server config:

```
General.Name = DCMS
Connection.Host name / address = localhost
Connection.Port = 5432
Connection.Maintenance database = postgres
Connection.Username = postgres
Connection.password = ${your_local_pgAdmin_password}
```

3. In pgAdmin, right-click newly created server that's called `DCMS` and select `Create Database`

4. Set Database config:

```
General.Database = DCMS
```

5. Initialize Database

- Right-click Database (not Server) called `DCMS`
- Click `Query Tool`
- Copy and paste the `schema-postgres.sql` contents from the Spring Boot Api project.
- Copy and paste the `data.sql` contents from the Spring Boot Api project.
- Run the query. Data should now be initialized in the database.

6. Setup Spring Boot Api:

In `DCMS/api/env.properties` change `DEFAULT_LOCAL_SPRING_PROFILES=postgres,local` to `DEFAULT_LOCAL_SPRING_PROFILES=pgadmin,local`

In `api/src/main/resources/pgadmin.env` input your password in the variable `local_password=your_password_here`
