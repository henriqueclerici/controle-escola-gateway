# Controle Escola Gateway

Esse exercício tem como objetivo a criação de um CRUD para alunos e turmas, também a criação de algumas rotinas para gerenciar a escola.

## Tecnologias
* Java 8
* Springboot
* Swagger
* Junit
* TravisCI
* Git


## Instalação

Use o maven para a instalação e build

```bash
mvn clean install
```

Depois da instação você pode acessar o swagger pela url abaixo:

```bash
http://localhost:8080/swagger-ui.html
```

Foi utilizado o banco de dados H2, segue abaixo o link para acessar:
```bash
http://localhost:8080/h
```
# Metodologias

Foram utilizados alguns padrões de projeto para o desenvolvimento dessa API, segue abaixo a lista:

* DDD
* Facade
* Builder
* Command

Foram utilizados também boas práticas de programação como SOLID. 


## TravisCI

Foi incluído nesse projeto o teste de integração continua utilizando o travis com o github. Configuração está no arquivo raiz .travis.yml