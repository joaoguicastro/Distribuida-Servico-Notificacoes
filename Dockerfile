FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests -B

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
RUN addgroup -S healthsys && adduser -S healthsys -G healthsys
USER healthsys

COPY --from=build /app/target/servico-notificacoes-*.jar app.jar

EXPOSE 8085

ENV SPRING_PROFILES_ACTIVE=docker
ENV DB_HOST=postgres-notificacoes
ENV DB_PORT=5432
ENV DB_NAME=notificacoes_db
ENV DB_USER=healthsys
ENV DB_PASS=healthsys
ENV RABBIT_HOST=rabbitmq
ENV RABBIT_PORT=5672
ENV RABBIT_USER=healthsys
ENV RABBIT_PASS=healthsys

ENTRYPOINT ["java", "-jar", "app.jar"]