Rodar o banco:
```shell
docker container run --name projeto-dev-web-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_HOST=% -e MYSQL_DATABASE=anuncios -p 3306:3306 -d mysql:latest
```