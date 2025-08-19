-- create database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- create table 1: Employee
DROP TABLE IF EXISTS `Employee`;
CREATE TABLE `Employee` (
	id					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,		
    `type` 				VARCHAR(50) NOT NULL,	-- regularemployee/contractemployee
    `name`				VARCHAR(50) NOT NULL,
    `salary`			INT,
	`bonus`				INT,
    pay_per_hour		INT,
    contract_duration	VARCHAR(50)
);

/*============================== INSERT EMPLOYEE =======================================*/
/*======================================================================================*/
-- Add Employee
INSERT INTO `Employee`	(		`type`,					`name`, 		`salary`,	`bonus`,	pay_per_hour,	contract_duration	) 
VALUE
						(	'regularemployee'	,	'tran duc hieu'	,	2000	,	100		,		null	,		null			),
						(	'regularemployee'	,	'ngo van nam'	,	2000	,	100		,		null	,		null			),
						(	'contractemployee'	,	'tran van dat'	,	null	,	null	,		10		,		'3 years'		);
                        

                        
                        
                        