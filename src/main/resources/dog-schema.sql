DROP TABLE IF EXISTS dog CASCADE;

CREATE TABLE dog(
	`id` int NOT NULL auto_increment,
	`name` VARCHAR(30) NOT NULL,
	`age` DECIMAL,
	PRIMARY KEY (`id`)
	);