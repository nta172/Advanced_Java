-- Drop the database if it already exists
DROP DATABASE IF EXISTS TestingSystem;
-- Create database
CREATE DATABASE IF NOT EXISTS TestingSystem;
USE TestingSystem;

-- Create table Department
DROP TABLE IF EXISTS 	`Department`;
CREATE TABLE IF NOT EXISTS `Department` (
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 			NVARCHAR(50) NOT NULL UNIQUE KEY
);

-- =============================================
-- INSERT DATA 
-- =============================================
INSERT INTO `Department` (`name` )

VALUE				('Sale'),			
					('Marketting'),
                    ('Accounting'),
                    ('Audit '),
					('BOD'),
                    ('Training Management'),
                    ('Administration'),
                    ('Human Resources'),
                    ('Customer Service');
                    
                    