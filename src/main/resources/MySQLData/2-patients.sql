-- -----------------------------------------------------
-- Schema mediscreen_patient
-- -----------------------------------------------------
USE `mediscreen_patient` ;

-- -----------------------------------------------------
-- Table `mediscreen_patient`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mediscreen_patient`.`patient` (
  `patient_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `patient_family_name` VARCHAR(45) NULL,
  `patient_given_name` VARCHAR(45) NULL,
  `patient_sexe` VARCHAR(1) NULL,
  `patient_birthdate` DATE NOT NULL,
  `patient_address` VARCHAR(50) NULL,
  `patient_phone` VARCHAR(12) NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE INDEX `patient_id_UNIQUE` (`patient_id` ASC) VISIBLE)
ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_ci;

-- -----------------------------------------------------
-- Insert data
-- -----------------------------------------------------
INSERT INTO patient VALUES ("1","Ferguson","Lucas","M","1968-06-22","2 Warren Street","387-866-1399");
INSERT INTO patient VALUES ("2","Rees","Pippa","F","1952-09-27","745 West Valley Farms Drive","628-423-0993");
INSERT INTO patient VALUES ("3","Arnold","Edward","M","1952-11-11","599 East Garden Ave","123-727-2779");
INSERT INTO patient VALUES ("4","Sharp","Anthony","M","1946-11-26","894 Hall Street","451-761-8383");
INSERT INTO patient VALUES ("5","Ince","Wendy","F","1958-06-29","4 Southampton Road","802-911-9975");
INSERT INTO patient VALUES ("6","Ross","Tracey","F","1949-12-07","40 Sulphur Springs Dr","131-396-5049");
INSERT INTO patient VALUES ("7","Wilson","Claire","F","1966-12-31","12 Cobblestone St","300-452-1091");
INSERT INTO patient VALUES ("8","Buckland","Max","M","1945-06-24","193 Vale St","833-534-0864");
INSERT INTO patient VALUES ("9","Clark","Natalie","F","1964-06-18","12 Beechwood Road","241-467-9197");
INSERT INTO patient VALUES ("10","Bailey","Piers","M","1959-06-28","1202 Bumble Dr","747-815-0557");
