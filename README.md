# Mood Diary Fullstack Application

A simple full-stack application for displaying and tracking daily moods with Vue.js frontend and Spring Boot backend.

## Prerequisites
- Docker 24.0.2 & Docker Compose 2.18.1 (lower version might work)
- Node.js 18.x+ (for manual frontend builds)
- Java 17 JDK (for manual backend builds)
- Maven 3.9+ (for manual backend builds)
- MongoDB 8.0+ (for manual database setup)

## Quick Start with Docker

1. Clone repository
```bash
git clone https://github.com/Bald-M/MyMoodDiary.git
cd MyMoodDiary
```

2. Start service
```bash
docker compose up -d
```

3. Access application
+ Frontend: http://your-machine-ip:80
+ Backend GET API ENDPOINT: http://your-machine-ip:8080/api/moodCards

> If unable to access services, please check firewall rules for these ports.

4. Shut the service
```bash
docker compose down -v
```

## Manul Deployment
**Please go to the corresponding directory to view README.md**