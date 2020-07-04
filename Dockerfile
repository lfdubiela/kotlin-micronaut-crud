FROM openjdk:14-alpine
COPY build/libs/io-example-helloworld-*-all.jar io-exaple-helloworld.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "io-exaple-helloworld.jar"]