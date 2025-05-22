# Этап 1: Сборка приложения с использованием Maven
FROM maven:3.9-eclipse-temurin-23 AS builder

WORKDIR /app

COPY pom.xml .
# RUN mvn dependency:go-offline -B
RUN mvn verify --fail-never || true # Загрузит плагины и некоторые зависимости

COPY src ./src

# Собираем приложение. JAR будет называться LW1-${version}.jar
# Например, LW1-1.0-SNAPSHOT.jar или LW1-1.0.0.jar после релиза
RUN mvn package -DskipTests

# Этап 2: Создание минимального образа для запуска
FROM eclipse-temurin:23-jre

WORKDIR /app

# Копируем собранный JAR из этапа 'builder'.
# Используем wildcard для версии, но конкретный artifactId
COPY --from=builder /app/target/LW1-*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]