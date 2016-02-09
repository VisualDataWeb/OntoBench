# OntoBench

## Setup
Run `mvn clean package` to install all Java and JavaScript dependencies and also to build the project.

The Java standalone server is built into the `target` directory and can be run with `java -jar target/ontobench-0.0.1-SNAPSHOT.jar`.
The web application is built into the `src/main/resources/static` directory and automatically included in the jar file.

## Development
Start the server from its main class `Application.java`.
The web interface will be accessible by default on `localhost:8080`.

For additional automatic rebuilds of the web interface you can switch to the `src/main/web` directory and execute `npm start`.
