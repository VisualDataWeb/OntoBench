# OntoBench

## Setup
Run `mvn clean package` to install all Java and JavaScript dependencies and also to build the project.

The Java standalone server is built into the `target` directory and can be run with `java -jar target/ontobench-0.0.1-SNAPSHOT.jar`.
The web application is built into the `static` directory and has to be in the directory from which the server is executed. 

To move the application you always have to move the .jar file and the static directory.
Then you can open a terminal in the directory where these two are placed in just run `java -jar ` followed by the filename of the jar.
