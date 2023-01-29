# Company Employee Applications
Dependencies:
* Spring Boot DevTools
* Lombok
* Spring Data JPA
* Spring Data JDBC
* PostgreSQL Driver


### Description[TR]:

spring.datasource.url=${your_db_url}

spring.datasource.username=${your_username}

spring.datasource.password=${your_password}



Spring Boot Projesi olan "company-employee" Spring Boot Maven ile geliştirilmiştir.
Şirketinize eleman ekleyip, silip, güncelleyebilirsiniz. Şirketinizdeki elemanları, şu ana kadar tüm kaydolmuş elemanları,
tüm şirketleride çekebilirsiniz.

_COMPANY EMPLOYEE API'S_

**Swagger Url:** http://127.0.0.1:8080/swagger-ui.html/

![](images/Screenshot%202023-01-28%20at%2018.32.31.png)

POST `api/v1/company/create`
###### Response Example:
`{
"companyName": "enoca",
"employees": null,
"id": 5
}`


POST `api/v1/employees/create`
###### Response Example:
`{
"id": 2,
"fullName": "Kadir Taban",
"email": "kadirtaban08@gmail.com",
"age": 21,
"company": {
"companyName": "enoca",
"id": 5
}
}`

GET `api/v1/company/receiveAll`
###### Response Example:
`[
{
"companyName": "enoca",
"employees": [
{
"id": 3,
"fullName": "Kadir Taban",
"email": "kadirtaban08@gmail.com",
"age": 0
}
],
"id": 5
},
{
"companyName": "companytest",
"employees": [
{
"id": 4,
"fullName": "test",
"email": "test@test.com",
"age": 0
}
],
"id": 6
}
]`

GET `api/v1/company/receive/employee/5` // query with company_id 
###### Response Example:

`[
{
"id": 3,
"fullName": "Kadir Taban",
"email": "kadirtaban08@gmail.com",
"age": 21,
"company": {
"companyName": "enoca",
"id": 5
}
},
{
"id": 6,
"fullName": "test",
"email": "test1@test.com",
"age": 20,
"company": {
"companyName": "enoca",
"id": 5
}
}
]
`

GET `api/v1/employees/receive`
###### Response Example:

`[
{
"id": 3,
"fullName": "Kadir Taban",
"email": "kadirtaban08@gmail.com",
"age": 21,
"company": {
"companyName": "enoca",
"id": 5
}
},
{
"id": 4,
"fullName": "test",
"email": "test@test.com",
"age": 20,
"company": {
"companyName": "companytest",
"id": 6
}
},
{
"id": 6,
"fullName": "test",
"email": "test1@test.com",
"age": 20,
"company": {
"companyName": "enoca",
"id": 5
}
}
]`

GET `api/v1/employees/receive/6`
###### Response Example:

`{
"id": 6,
"fullName": "test",
"email": "test1@test.com",
"age": 20,
"company": {
"companyName": "enoca",
"id": 5
}
}`


PUT `api/v1/company/update/6`
###### Response Example:
`{
"companyName": "updateName",
"employees": [
{
"id": 4,
"fullName": "test",
"email": "test@test.com",
"age": 0
}
],
"id": 6
}
`

PUT `api/v1/employees/update/3`
###### Response Example:
`{
"id": 3,
"fullName": "update",
"email": "update",
"age": 0,
"company": {
"companyName": "enoca",
"id": 5
}
}   `

DELETE `api/v1/company/delete/7`
###### Response Example:

`deneme has deleted succesfully`

DELETE `api/v1/employees/delete/7`
###### Response Example:

`deneme left her/him company.
`
