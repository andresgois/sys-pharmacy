# Sys pharmacy

## Criando o projeto 

- File > New > Dynamic Web Project

## Configurando
### Libs
- javax.faces-2.2.9
- mysql-connector-java-5.1.39-bin
- primefaces-4.0

- Cole as lib's dentro de WEB-INF > lib

## Configurando o server
- Clique em 
```No servers are available...```
- Basic
- Apache v9
- Selecionar pasta do apache
- URL Inicial
	- http://localhost:8080/farmacia/faces/templates/modeloSistema.xhtml
- Adicionar configuração antes do web app na página web.xml
```
<context-param>
	<param-name>primefaces.THEME</param-name>
	<param-value>bootstrap</param-value>
</context-param>
``` 
## Adicionando tema
- Aula 14

## Banco de dados
### Docker
- Instalação e configuração do container do mysql
```
docker container run -e MYSQL_USER=andre -e MYSQL_PASSWORD=123456 -e MYSQL_DATABASE=farmacia -e MYSQL_ROOT_PASSWORD=123456 --name mysql-farmacia -p 3306:3306 mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```
- Entra no container
```
mysql -h localhost -u andre -p
show databases;
use farmacia;
show tables;
select * from ;
```
#### Script do banco
```
create table fornecedores(
	codigo int primary key auto_increment,
  	descricao varchar(45) not null
);

create table produtos(
	codigo int primary key auto_increment,
  	descricao varchar(45) not null,
  	quantidade int not null,
  	preco decimal(6,2) not null,
  	codigo_for int not null,
  	constraint fk_prod_fornecedores foreign key (codigo_for) references fornecedores (codigo)
  	on delete no action
   	on update no action
);
```

## Estrutura da aplicação
- br.com.farmacia
	- bean
	- DAO
	- domain
		- Camada onde fica as entidades do sistema
	- factory
	- util


## Temas
- [Themes](https://www.primefaces.org/themes/)
- [Todos os temas](https://repository.primefaces.org/org/primefaces/themes/)
- Baixar o .jar e adicionar a pasta lib's no projeto
- 

## Referências
- https://www.primefaces.org/showcase/
- https://jqueryui.com/themeroller/