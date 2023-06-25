# testProject
1) Скачать архив с проектом с Git репозитория, разархивировать на тот диск, где будет храниться проект.
2) Создать базу данных (MySQL)
   create database testdatabase;
3) Открыть проект в среде разработки;
4) Открыть файл pom.xml и обновить зависимости maven
5) В Project Structure выбрать SDK 8+
6) Запустить проект
Необходимо для сохранения данных в SQL-хранилищах с помощью Java Persistence API с использованием Spring Data и Hibernate.

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>


Для создания веб-приложения, включая RESTful, с использованием Spring MVC. 
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
Обеспечивает быстрый перезапуск приложения, повторную загрузку.

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		
Драйвер JDBC для MySQL.	
	
<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		
Библиотека аннотаций Java, которая помогает сократить количество шаблонного кода.	
<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		
		
		
POSTMAN:

POST localhost:8080/create/pet
Body:
{
    "nickName":"Pumka",
    "age":"2",
    "typePet":"dog",
    "gender":"male",
    "weight":"10"
}

POST localhost:8080/create/person
Headers: Key - Accept, Value - application/json
Body:
{
     "name":"Anastasia",
    "lastName":"Avramchik",
    "address":"Matysevicha",
    "numberPhone":"80296457891",
    "town":"Minsk"
}

GET localhost:8080/getAll
Headers: Key - Accept, Value - application/json
Body: none

PUT localhost:8080/person/update
Body:
{
"id": 1,
    "name":"Anastasia",
    "lastName":"Avramchik",
    "address":"Matysevicha",
    "numberPhone":"3708501",
    "town":"Minsk"
}

PUT localhost:8080/add/personPet/1
Body:
{
"id": 1,
    "name":"Anastasia",
    "lastName":"Avramchik",
    "address":"Matysevicha",
    "numberPhone":"3708501",
    "town":"Minsk"
}

DELETE localhost:8080/delete/person/152
Body: none

PUT localhost:8080/update/pet
Body:
{
    "id": 1,
    "nickName":"Pumka",
    "age":"2",
    "typePet":"dog",
    "gender":"male",
    "weight":"10", 
	"personId": 1
}

GET localhost:8080/getAll/pets
Headers: Key - Accept, Value - application/json
Body: none

DELETE localhost:8080/delete/pet/1
Body: none
