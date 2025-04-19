# MongoDB Configuration for Mood Diary

This directory contains database initialization scripts and deployment configurations.

## Deployment Methods

### Docker Deployment (Recommended)
```bash
docker run -d `
  -p 27017:27017 `
  --name my-mood-diary-db `
  --restart="always" `
  -e MONGO_INITDB_ROOT_USERNAME=your_username `
  -e MONGO_INITDB_ROOT_PASSWORD=your_password `
  -v /your_folder/mongodb/data:/data/db `
  mongo:8.0.6
```