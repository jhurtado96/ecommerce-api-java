# Ecommerce Prices API

## Descripción

Aplicación Spring Boot para gestionar y consultar precios de productos en una tienda de comercio electrónico.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok
- RestAssured (Pruebas)
- SwaggerUI

## Requisitos

- JDK 17 o superior
- Maven

## Cómo Ejecutar la Aplicación

## Ejecutar Localmente

1. **Clonar el Repositorio**:

   ```bash
   git clone <https://github.com/jhurtado96/ecommerce-api-java.git>
   cd ecommerce-prices
   
2. **Instalar dependencias**:

   ```bash
   mvn clean install

3. **Ejecuta el proyecto**:

   ```bash
   mvn spring-boot:run

3. **Ejecutar test**:

   ```bash
   mvn test

  
## Swagger

<http://localhost:8080/swagger-ui/index.html>

### Ejemplo

<http://localhost:8080/prices?applicationDate=2020-06-14-10.00.00&productId=35455&brandId=1>