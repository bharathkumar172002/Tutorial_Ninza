FROM maven:3.9.15-eclipse-temurin-21

WORKDIR /app

COPY . .

# Build dependencies without running tests
RUN mvn clean install -DskipTests

# Run Cucumber tests via JUnit runner
CMD ["mvn", "clean", "verify"]
