# PollosHermanados

## _Prototipo de backend en SpringBoot_

El puerto por defecto es 8080 
Se puede cambiar desde application.properties

## Tecnologías utilizadas en el proyecto

- Spring Boot 2.7.11
- Open API (para generar documentación automática de la API REST)
- Spring Data
- Base de datos H2 (base de datos en memoria para desarrollo)
- Spring Web
- Thymeleaf

## End-point base de datos H2

- <http://localhost:8080/h2-console> - Acceso a la consola de H2

## End-points API REST

- <http://localhost:8080/swagger-ui.html> - Swagger UI
- <http://localhost:8080/v3/api-docs/> - Documentación JSON de la API REST

## End-point aplicación Thymeleaf

- <http://localhost:8080/app/productos>

## End-points para disparo de pruebas 

pruebas del EntityManager (JPA)

- <http://localhost:8080/em/trigger1>
- <http://localhost:8080/em/trigger2>
- <http://localhost:8080/em/trigger3>
- <http://localhost:8080/em/trigger4>

pruebas de ProductoRepository

- <http://localhost:8080/producto-repository/test1>
- <http://localhost:8080/producto-repository/test2>
- <http://localhost:8080/producto-repository/test3>
- <http://localhost:8080/producto-repository/test4>
- <http://localhost:8080/producto-repository/test5>
- <http://localhost:8080/producto-repository/test6>
- <http://localhost:8080/producto-repository/test7>
- <http://localhost:8080/producto-repository/test8>

pruebas de ProductoServices

- <http://localhost:8080/producto-services/test>