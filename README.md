# CSE5322-Group4-NTSS

Project Setup

1. Import Project to STS/IntelliJ
2. Clean & Build
3. Setup DB based on the Steps below
4. Run as SpringBoot Application
5. http://localhost:8086/


DB Setup
1. Install MySQL and setup the server per the port username and password provided in application.properties
2. Run the below commands

CREATE DATABASE ntss;
use ntss;

CREATE TABLE `user` (
`userId` int(11) NOT NULL AUTO_INCREMENT,
`email` varchar(45) NOT NULL,
`password` varchar(45) NOT NULL,
`userType` varchar(45) NOT NULL,
PRIMARY KEY (`userId`)
);
