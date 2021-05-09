## Micronaut 2.5.1 Documentation

- Ejecutar el comando ``./gradlew build`` para compilar el proyecto
- Ejecutar el comando ``./gradlew run`` para correr el proyecto
- Ingresar a la url `http://localhost:8080/v1/api/users` para buscar todos los usuarios `curl http://localhost:8080/hello`
- Para crear un usuario utilizar este curl: `curl --location --request POST 'http://localhost:8080/v1/api/users' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "name": "Juanita",
  "gender": "F",
  "documentType": "CC",
  "documentNumber": "6467766",
  "email": "juanita@gmail.com",
  "phone": 31032134,
  "address": "Cra 100"
  }'`
  

