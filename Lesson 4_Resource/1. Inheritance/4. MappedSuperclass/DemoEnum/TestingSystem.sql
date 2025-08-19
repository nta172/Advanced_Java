-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table 1: Regular_Employee
DROP TABLE IF EXISTS `Regular_Employee`;
CREATE TABLE `Regular_Employee` (
	id					INT UNSIGNED PRIMARY KEY,	
	`name`				VARCHAR(50) NOT NULL,
    `salary`			INT,
	`bonus`				INT
);

-- create table 2: Contract_Employee
DROP TABLE IF EXISTS `Contract_Employee`;
CREATE TABLE `Contract_Employee` (
	id					INT UNSIGNED PRIMARY KEY,		
    `name`				VARCHAR(50) NOT NULL,
    pay_per_hour		INT,
    contract_duration	VARCHAR(50)
);

/*============================== INSERT EMPLOYEE =======================================*/
/*======================================================================================*/                        
-- Add Regular_Employee
INSERT INTO `Regular_Employee`	(	id	,		`name` 		,	`salary`,	`bonus`	) 
VALUE                           (	1	,	'tran duc hieu'	,	2000	,	100		),
								(	2	,	'ngo van nam'	,	2000	,	100		);
                                 
-- Add Contract_Employee
INSERT INTO `Contract_Employee`	(	id	,	`name`			, pay_per_hour,	contract_duration	) 
VALUE							(	3	, 'tran van dat'	,		10		,		'3 years'	);
                        
                        
                        