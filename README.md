# spirngboot-sample
Spring Boot 5練習用Task管理アプリケーション

# DB 
DockerのPostgresを使用

Database名、User名、パスワード全て"taskdb"とする。
```
# docker run --name taskdb -p 5432:5432 -e POSTGRES_DB=taskdb -e POSTGRES_USER=taskdb -e POSTGRES_PASSWORD=taskdb -d postgres:11.1
```