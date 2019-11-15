# Invillia recruitment challenge

[![Build Status](https://travis-ci.org/shelsonjava/invillia.svg?branch=master)](https://travis-ci.org/shelsonjava/invillia)

![Invillia Logo](https://invillia.com/public/assets/img/logo-invillia.svg)
[Invillia](https://https://www.invillia.com/) - A transformação começa aqui.

The ACME company is migrating their monolithic system to a microservice architecture and you’re responsible to build their MVP (minimum viable product)  .
https://en.wikipedia.org/wiki/Minimum_viable_product

Your challenge is:
Build an application with those features described below, if you think the requirements aren’t detailed enough please leave a comment (portuguese or english) and proceed as best as you can.

You can choose as many features you think it’s necessary for the MVP,  IT’S NOT necessary build all the features, we strongly recommend to focus on quality over quantity, you’ll be evaluated by the quality of your solution.

If you think something is really necessary but you don’t have enough time to implement please at least explain how you would implement it.

## Tasks

Your task is to develop one (or more, feel free) RESTful service(s) to:
* Create a **Store**
* Update a **Store** information
* Retrieve a **Store** by parameters
* Create an **Order** with items
* Create a **Payment** for an **Order**
* Retrieve an **Order** by parameters
* Refund **Order** or any **Order Item**

Fork this repository and submit your code with partial commits.

## Business Rules

* A **Store** is composed by name and address
* An **Order** is composed by address, confirmation date and status
* An **Order Item** is composed by description, unit price and quantity.
* A **Payment** is composed by status, credit card number and payment date
* An **Order** just should be refunded until ten days after confirmation and the payment is concluded.

## Non functional requirements

Your service(s) must be resilient, fault tolerant, responsive. You should prepare it/them to be highly scalable as possible.

The process should be closest possible to "real-time", balancing your choices in order to achieve the expected
scalability.

## Nice to have features (describe or implement):
* Asynchronous processing
* Database
* Docker
* AWS
* Security
* Swagger
* Clean Code

criação de store:

url: http://localhost:8080/store : via Post

Dados json:

{
	"name": "Livraria",
	"address": "Rua do Carmo"
}

update de store:

url: http://localhost:8080/store/{idStore} : via Post

buscar de Store:

url: http://localhost:8080/store/filter?name={name}&address={address}: via GET

Dados json:

{
	"name": "Livraria",
	"address": "Rua do Carmo"
}

criação de Product:

url: http://localhost:8080/product: via Post

{
	"unitPrice" : 23.00,
	"description" : "Caneta Azull",
	"storeId": 1
}

criação de Order:

url: http://localhost:8080/product: via Post

{
	"address": "rua firmino",
	"confirmationDate" : "14-11-2019",
	"status": 1,
	"items": [{
	  "unitPrice": 23.00,
	  "quantity" : 4,
	  "productId": 2,
	  "orderId": 1
	}],
	"storeId": 1
}
buscar de Order:

url: http://localhost:8080/order/filter?address={address}: via GET

criação de Payment**:

url: http://localhost:8080/payment: via Post

{
   "paymentDate": "13-11-1983",
   "creditCardNumber": "123456789",
   "status": 1,
   "orderId": 1
}

Na raiz do projeto contém um arquivos de script, o banco ultilizado foi o mysql.







