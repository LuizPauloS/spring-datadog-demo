FROM eclipse-temurin:17-jdk

# Crie diretório da aplicação
WORKDIR /app

# Copie o JAR da aplicação
COPY build/libs/*-SNAPSHOT.jar app.jar

# Baixe o Datadog Java Agent
RUN curl -L -o dd-java-agent.jar https://dtdg.co/latest-java-tracer

# Exponha a porta da aplicação
EXPOSE 8080

# Use JAVA_OPTS e inicie a aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
