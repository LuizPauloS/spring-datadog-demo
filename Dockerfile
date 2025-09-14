FROM eclipse-temurin:17-jdk-alpine

RUN apk add --no-cache curl

WORKDIR /app

RUN curl -L -o /app/dd-java-agent.jar https://dtdg.co/latest-java-tracer

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-javaagent:/app/dd-java-agent.jar", "-jar", "app.jar"]
