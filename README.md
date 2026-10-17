# api-registro-stefany-558792-m1
API para gerenciamento de registros meteorológicos, desenvolvida com Java, Spring Boot, Maven, MySQL, Spring Data JPA, Flyway, Docker, Swagger e OpenAPI


### Compilar o projeto

```bash
mvnw.cmd clean package -DskipTests
```

### Executar com o perfil de desenvolvimento

```bash
mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=dev
```

### Executar com perfil de testes

```bash
mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=test
```

### Docker

Construção da imagem: 

```bash
docker build -t registro .
```

Execução da aplicação:

```bash
docker run -p 8080:8080 registro
```

### Iniciar o MySQL com Docker

Se o Docker Desktop estiver instalado e em execução, inicie um contêiner MySQL com:

```bash
docker run --name mysql-registro -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=registro_meteorologico -p 3306:3306 -d mysql:8.4
```

### Com a aplicação em execução, acesse:

Swagger UI: http://localhost:8080/swagger-ui/index.html

OpenAPI JSON: http://localhost:8080/v3/api-docs


