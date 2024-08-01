FROM openjdk:17-jdk-slim
COPY "./target/ms-alumnos-0.0.1-SNAPSHOT.jar" "ms-alumnos.jar"
EXPOSE 8085
ENTRYPOINT ["java", "-Duser.timezone=UTC", "-jar", "ms-alumnos.jar"]