SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `signupdb` ;
CREATE SCHEMA IF NOT EXISTS `signupdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `signupdb` ;

-- -----------------------------------------------------
-- Table `signupdb`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `signupdb`.`role` ;

CREATE  TABLE IF NOT EXISTS `signupdb`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT ,
  `ro_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`ro_id`) ,
  UNIQUE INDEX `ro_id_UNIQUE` (`ro_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `signupdb`.`language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `signupdb`.`language` ;

CREATE  TABLE IF NOT EXISTS `signupdb`.`language` (
  `la_id` INT NOT NULL AUTO_INCREMENT ,
  `la_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`la_id`) ,
  UNIQUE INDEX `la_id_UNIQUE` (`la_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `signupdb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `signupdb`.`user` ;

CREATE  TABLE IF NOT EXISTS `signupdb`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT ,
  `us_name` VARCHAR(50) NULL ,
  `us_email` VARCHAR(245) NULL ,
  `us_password` VARCHAR(20) NULL ,
  `us_ro_id` INT NULL ,
  `us_la_id` INT NULL ,
  PRIMARY KEY (`us_id`) ,
  UNIQUE INDEX `us_id_UNIQUE` (`us_id` ASC) ,
  INDEX `us_ro_id` (`us_ro_id` ASC) ,
  INDEX `us_la_id` (`us_la_id` ASC) ,
  CONSTRAINT `us_ro_id`
    FOREIGN KEY (`us_ro_id` )
    REFERENCES `signupdb`.`role` (`ro_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `us_la_id`
    FOREIGN KEY (`us_la_id` )
    REFERENCES `signupdb`.`language` (`la_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `signupdb`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `signupdb`.`article` ;

CREATE  TABLE IF NOT EXISTS `signupdb`.`article` (
  `ar_id` INT NOT NULL AUTO_INCREMENT ,
  `ar_title` VARCHAR(45) NULL ,
  `ar_desc` VARCHAR(500) NULL ,
  `ar_author` VARCHAR(50) NULL ,
  `ar_content` VARCHAR(500) NULL ,
  `ar_url` VARCHAR(100) NULL ,
  `ar_url_to_image` VARCHAR(100) NULL ,
  `ar_published_at` TIMESTAMP NULL ,
  `ar_la_id` INT NULL ,
  PRIMARY KEY (`ar_id`) ,
  UNIQUE INDEX `ar_id_UNIQUE` (`ar_id` ASC) ,
  INDEX `ar_la_id` (`ar_la_id` ASC) ,
  CONSTRAINT `ar_la_id`
    FOREIGN KEY (`ar_la_id` )
    REFERENCES `signupdb`.`language` (`la_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `signupdb`.`favourite_article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `signupdb`.`favourite_article` ;

CREATE  TABLE IF NOT EXISTS `signupdb`.`favourite_article` (
  `fa_id` INT NOT NULL AUTO_INCREMENT ,
  `fa_ar_id` INT NULL ,
  `fa_us_id` INT NULL ,
  PRIMARY KEY (`fa_id`) ,
  UNIQUE INDEX `fa_id_UNIQUE` (`fa_id` ASC) ,
  INDEX `fa_ar_id` (`fa_ar_id` ASC) ,
  INDEX `fa_us_id` (`fa_us_id` ASC) ,
  CONSTRAINT `fa_ar_id`
    FOREIGN KEY (`fa_ar_id` )
    REFERENCES `signupdb`.`article` (`ar_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fa_us_id`
    FOREIGN KEY (`fa_us_id` )
    REFERENCES `signupdb`.`user` (`us_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
