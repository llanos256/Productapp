Porductapp API

Porductapp involves an api which has insert, update, get, and delete processes. An user can add and update franchises, branches and products

Java Version: 25

Database: MySQL

Database scipt: productdb.sql

For Security protocols, database credentials was replaced for environment variables in application.properties file

Dockerfile was created for Containerization


Import SQL Script for local testing and replace values in application.properties for a local database credentials

Command for execution: mvn spring-boot:run
  
Maven must be installed for the above command to work

It was also configured a documentation UI, you can find it on: https://productapp-n2q5.onrender.com/api-doc
 
<img width="1917" height="947" alt="image" src="https://github.com/user-attachments/assets/76e68aff-b538-425d-91ed-dcbfc2b90b1a" />



Example of testing an endpoint that returns a list of products with the highest stock values by branch


<img width="1812" height="1020" alt="image" src="https://github.com/user-attachments/assets/02a6ee84-346e-4d85-9e7d-d86eee2a40a6" />

