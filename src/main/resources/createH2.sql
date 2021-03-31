drop all objects;

create schema if not exists zoo;
use zoo;
CREATE TABLE if not exists `Country`
(
    `id`   int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE if not exists `Tiger`
(
    `id`        int NOT NULL AUTO_INCREMENT,
    `name`      varchar(45) DEFAULT NULL,
    `countryId` int         DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE if not exists `Food`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `foodName`     varchar(45) DEFAULT NULL,
    `animalId` int         DEFAULT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `zoo`.`Country` (`name`) VALUES ('Madagaskar');
INSERT INTO `zoo`.`Country` (`name`) VALUES ('West-Myanmar');
INSERT INTO `zoo`.`Country` (`name`) VALUES ('Rusland');
INSERT INTO `zoo`.`Country` (`name`) VALUES ('China');

INSERT INTO `zoo`.`Tiger` (`name`, `countryId`) VALUES ('Jef', '1');
INSERT INTO `zoo`.`Tiger` (`name`, `countryId`) VALUES ('Jef', '1');
INSERT INTO `zoo`.`Tiger` (`name`, `countryId`) VALUES ('Tim', '4');
INSERT INTO `zoo`.`Tiger` (`name`, `countryId`) VALUES ('James', '2');
INSERT INTO `zoo`.`Tiger` (`name`, `countryId`) VALUES ('Rock', '2');
INSERT INTO `zoo`.`Tiger` (`name`, `countryId`) VALUES ('Vera', '2');

INSERT INTO `zoo`.`Food` (`foodName`, `animalId`) VALUES ('Antelope', '1');
INSERT INTO `zoo`.`Food` (`foodName`, `animalId`) VALUES ('Giraffe', '1');
INSERT INTO `zoo`.`Food` (`foodName`, `animalId`) VALUES ('Zebra', '2');
INSERT INTO `zoo`.`Food` (`foodName`, `animalId`) VALUES ('Pork', '2');
INSERT INTO `zoo`.`Food` (`foodName`, `animalId`) VALUES ('Chicken', '2');
INSERT INTO `zoo`.`Food` (`foodName`, `animalId`) VALUES ('Chicken', '5');
INSERT INTO `zoo`.`Food` (`foodName`, `animalId`) VALUES ('Pork', '5');





