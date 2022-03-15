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
INSERT INTO patient VALUES ("1","TestNone","Test","F","1966-12-31","1 Brookside St","100-222-3333");
INSERT INTO patient VALUES ("2","TestBorderline","Test","M","1945-06-24","2 High St","200-333-4444");
INSERT INTO patient VALUES ("3","TestInDanger","Test","M","2004-06-18","3 Club Road","300-444-5555");
INSERT INTO patient VALUES ("4","TestEarlyOnset","Test","F","2002-06-28","4 Valley Dr","400-555-6666");
