CREATE SCHEMA IF NOT EXISTS `Fito` DEFAULT CHARACTER SET utf8 ;
USE `Fito` ;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `Fito`.`post_office`;
DROP TABLE IF EXISTS `Fito`.`driver`;
DROP TABLE IF EXISTS `Fito`.`post_office_has_driver`;
DROP TABLE IF EXISTS `Fito`.`car`;
DROP TABLE IF EXISTS `Fito`.`driver_has_car`;
SET FOREIGN_KEY_CHECKS=1;

-- -----------------------------------------------------
-- Table `Fito`.`post_office`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fito`.`post_office` (
                                                    `id` INT NOT NULL AUTO_INCREMENT,
                                                    `capacity` INT NOT NULL,
                                                    `phone_number` VARCHAR(45) NOT NULL,
    `hours_of_working` TIME NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Fito`.`driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fito`.`driver` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `name` VARCHAR(45) NOT NULL,
    `surname` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NULL,
    `age` VARCHAR(45) NULL,
    `telephone_number` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fito`.`post_office_has_driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fito`.`post_office_has_driver` (
                                                               `post_office_id` INT NOT NULL,
                                                               `driver_id` INT NOT NULL,
                                                               PRIMARY KEY (`post_office_id`, `driver_id`),
    INDEX `fk_post_office_has_driver_driver1_idx` (`driver_id` ASC) VISIBLE,
    INDEX `fk_post_office_has_driver_post_office1_idx` (`post_office_id` ASC) VISIBLE,
    CONSTRAINT `fk_post_office_has_driver_post_office1`
    FOREIGN KEY (`post_office_id`)
    REFERENCES `Fito`.`post_office` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_post_office_has_driver_driver1`
    FOREIGN KEY (`driver_id`)
    REFERENCES `Fito`.`driver` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fito`.`car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fito`.`car` (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `brand` VARCHAR(45) NOT NULL,
    `number` VARCHAR(45) NOT NULL,
    `color` VARCHAR(45) NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Fito`.`driver_has_car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Fito`.`driver_has_car` (
                                                       `driver_id` INT NOT NULL,
                                                       `car_id` INT NOT NULL,
                                                       PRIMARY KEY (`driver_id`, `car_id`),
    INDEX `fk_driver_has_car_car1_idx` (`car_id` ASC) VISIBLE,
    INDEX `fk_driver_has_car_driver1_idx` (`driver_id` ASC) VISIBLE,
    CONSTRAINT `fk_driver_has_car_driver1`
    FOREIGN KEY (`driver_id`)
    REFERENCES `Fito`.`driver` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_driver_has_car_car1`
    FOREIGN KEY (`car_id`)
    REFERENCES `Fito`.`car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


INSERT INTO `Fito`.`post_office` (`id`, `capacity`, `phone_number`, `hours_of_working`) VALUES
('1','12000','0976767556','19:00:00'),
('2','36500','0678855678','21:00:00'),
('3', '2899', '0237778866', '23:00:00'),
('4', '56778', '0678465774', '18:00:00'),
('5', '1200', '0976733246', '20:00:00'),
('6', '385', '0672844199', '20:00:00'),
('7', '56788', '0854627448', '22:00:00'),
('8', '50000', '0678435667', '21:00:00'),
('9', '4500', '0695744558', '19:00:00'),
('10', '28000', '02345678823', '20:00:00');


INSERT INTO `Fito`.`driver` (`id`, `name`, `surname`, `last_name`, `age`,`telephone_number`,`email`) VALUES
('1', 'Oleg', 'Bornenko', 'Nazarovych', '18', '0675678899', 'joy@gmail.com'),
('2', 'Serhiy', 'Dornenko', 'Stepanovych', '39', '0347855683', 'kinder@gmail.com'),
('3', 'Dmytro', 'Mornenko', 'Petrovych', '65', '0672844187', 'fIker@gmail.com'),
('4', 'Maksym', 'Stepaniv', 'Tarasovych', '23', '0675868773', 'jinjer@gmail.com'),
('5', 'Ivan', 'Lornev', 'Albertovych', '32', '0453856771', 'nastunia@gmail.com'),
('6', 'Petro', 'Fustiy', 'Olegovych', '48', '0976733247', 'masaryka@gmail.com'),
('7', 'Nastia', 'Gorniva', 'Andriyovych', '53', '0123456778', 'Zbyralna@gmail.com'),
('8', 'Nazar', 'Lubomyrenko', 'Arturovych', '19', '0567433892', 'chornyy@gmail.com'),
('9', 'Barsik', 'Fito', 'Filovych', '28', '0675433124', 'kit@gmail.com'),
('10', 'Stiv', 'Moren', 'Ivanovych', '54', '0976744256', 'stivchik@gmail.com');


INSERT INTO `Fito`.`post_office_has_driver` (`post_office_id`, `driver_id`) VALUES
('1','1'),
('2','2'),
('3','3'),
('4','4'),
('5','5'),
('6','6'),
('7','7'),
('8','8'),
('9','9'),
('10','10');


INSERT INTO `Fito`.`car` (`id`, `brand`, `number`, `color`) VALUES
('1', 'mercedes', 'BC3451NM', 'red'),
('2', 'bmw', 'CE3884DM', 'black'),
('3', 'shkoda', 'AA2309KN', 'blue'),
('4', 'audi', 'AI2389KI', 'white'),
('5', 'mazda', 'BM1276BK', 'pink'),
('6', 'honda', 'CM4184AI', 'green'),
('7', 'lada', 'AI8726DK', 'black'),
('8', 'chevrolet', 'AK6839AA', 'purple'),
('9', 'toyota', 'AA3978AM', 'white'),
('10', 'nissan', 'CI7927IB', 'grey');


INSERT INTO `Fito`.`driver_has_car` (`driver_id`, `car_id`) VALUES
('1','1'),
('2','2'),
('3','3'),
('4','4'),
('5','5'),
('6','6'),
('7','7'),
('8','8'),
('9','9'),
('10','10');
