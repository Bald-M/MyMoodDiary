# Stage 1: Build stage with JDK and Maven
FROM eclipse-temurin:17-jdk-jammy as builder

# Install specific Maven version
ARG MAVEN_VERSION=3.9.9
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz -P /tmp && \
    tar xf /tmp/apache-maven-${MAVEN_VERSION}-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/maven && \
    rm -rf /tmp/*

# Set Maven environment
ENV MAVEN_HOME=/opt/maven
ENV PATH=$MAVEN_HOME/bin:$PATH

# Copy project files (optimize dependency caching)
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Build application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM eclipse-temurin:17-jre-jammy

# Set timezone
ENV TZ=Pacific/Auckland
RUN apt-get update && \
    apt-get install -y --no-install-recommends tzdata && \
    ln -fs /usr/share/zoneinfo/$TZ /etc/localtime && \
    dpkg-reconfigure -f noninteractive tzdata && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Create non-root user
RUN useradd -m myapp
USER myapp
WORKDIR /app

# Copy built JAR
COPY --from=builder /app/target/*.jar /app/app.jar

# Environment variables with defaults (modify as needed)
# ENV DB_HOST=your_db_ip \
#     DB_PORT=your_db_port \
#     DB_USER=your_db_user \
#     DB_PASSWORD=your_db_passwd \
#     DB_NAME=your_db_name

# Expose port
EXPOSE 8080

# Startup command with dynamic database configuration
# ENTRYPOINT ["sh", "-c", "java -jar /app/app.jar \
#   --spring.data.mongodb.host=${DB_HOST} \
#   --spring.data.mongodb.port=${DB_PORT} \
#   --spring.data.mongodb.database=${DB_NAME} \
#   --spring.data.mongodb.username=${DB_USER} \
#   --spring.data.mongodb.password=${DB_PASSWORD}"]
ENTRYPOINT ["sh", "-c", "java -jar /app/app.jar --spring.data.mongodb.uri=${SPRING_DATA_MONGODB_URI}"]