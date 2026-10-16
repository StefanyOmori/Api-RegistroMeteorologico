# Api-RegistroMeteorologico
API para gerenciamento de registros meteorológicos, desenvolvida com Java, Spring Boot, Maven, MySQL, Spring Data JPA, Flyway, Docker, Swagger e OpenAPI


### Compilar o projeto

```bash
mvnw.cmd clean package -DskipTests
```

### Executar com o perfil de desenvolvimento

```bash
mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=dev
```

### Docker

```bash
docker build -t registro .
```
```bash
docker run -p 8080:8080 registro
```



