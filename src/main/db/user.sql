CREATE TABLE `booking-service`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(128) NULL,
  `password` VARCHAR(32) NULL,
  `first` VARCHAR(45) NULL,
  `last` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
