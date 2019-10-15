CREATE TABLE `booking-service`.`location` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `avgReview` FLOAT NULL,
  `userId` BIGINT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_user_location`
    FOREIGN KEY (`userId`)
    REFERENCES `booking-service`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
