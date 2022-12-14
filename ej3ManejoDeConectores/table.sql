-- MySQL Script generated by MySQL Workbench
-- Thu Mar 24 08:06:23 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`libro` (
  `ISBN` INT NULL,
  `titulo` VARCHAR(30) NOT NULL,
  `autor` VARCHAR(30) NULL,
  `numejemplares` INT(2) NULL,
  `anyopublicacion` INT(4) NULL,
  `editorial` VARCHAR(30) NULL,
  `numpag` INT(4) NULL,
  PRIMARY KEY (`ISBN`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`socio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`socio` (
  `numosocio` INT(5) NOT NULL,
  `nombre` VARCHAR(15) NOT NULL,
  `apellido` VARCHAR(15) NOT NULL,
  `telefono` VARCHAR(10) NULL,
  `edad` INT(5) NULL,
  `falta` DATE NULL,
  PRIMARY KEY (`numosocio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`prestamo` (
  `libro` INT(10) NOT NULL,
  `socio` INT(5) NOT NULL,
  `fprestamo` DATE NOT NULL,
  `fdevolucion` DATE NULL,
  PRIMARY KEY (`libro`, `socio`, `fprestamo`),
  INDEX `socio_idx` (`socio` ASC) VISIBLE,
  CONSTRAINT `libro`
    FOREIGN KEY (`libro`)
    REFERENCES `mydb`.`libro` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `socio`
    FOREIGN KEY (`socio`)
    REFERENCES `mydb`.`socio` (`numosocio`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
