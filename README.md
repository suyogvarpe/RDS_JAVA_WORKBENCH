

# RDS_JAVA_WORKBENCH

This Project aim to store Records in RDS Mysql database using Java code and Ec2 instance.

I have followed following steps to complete this project.

1)Creat Mysql databse using RDS service.
  Copy Database URl for to provide connection in Java code.
  Url -database-1.c70sos6cgu5d.ap-south-1.rds.amazonaws.com
  Database should be created with All trafic allowed port number -3306

2)Install mysql workbench on you machine.
  Open workbench
  Go to option ->Connect Database.
  Paste copied RDS database URl 
  Enter username
  Enter password.
  Connect database

3)After conncetion Create Database with name -Company
  USE Company; --Select Database

  Create table by using following sql query.
  CREATE TABLE Employee (e_id int ,e_name varchar(10),e_address varchar(10));

4)Create SaveRecordToRDS.java file for to provide records and connection to insert it into database
  In this file provide database Endpoint url ,userid and password.

5)Create Linux EC2 instance.
  Install Jdk version 17 using command 
  #sudo yum install java-17-amazon-corretto -y 

  Check Java version whether it is installed or not.
  #java -version

  Install Java Compiler
  #sudo yum install java-17-amazon-corretto-devel -y

  Create java code file on Ec2 instance using Vim command.
  #File name should be "SaveRecordToRDS.java" Becuase we have create java class of this name in java file.


  Compile this java file using following query
  #javac SaveRecordToRDS.java

  Download Mysql connection zip file for Mysql connection
  #wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j-8.4.0.tar.gz

  Exctract above file by using following command.
  #tar -xvzf mysql-connector-j-8.4.0.tar.gz

  Compile java code again using following command
  #javac -cp .:mysql-connector-j-8.4.0/mysql-connector-j-8.4.0.jar SaveRecordToRDS.java
  
  Run code using following command to save record in database
  #java -cp .:mysql-connector-j-8.4.0/mysql-connector-j-8.4.0.jar SaveRecordToRDS.java

  Finnaly it should show message as 
  1 row(s) inserted successfully.

6)Open Mysql workbench

  Check in table record is inserted succesfully.

