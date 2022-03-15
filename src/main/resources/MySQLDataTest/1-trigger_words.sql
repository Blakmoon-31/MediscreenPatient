-- -----------------------------------------------------
-- Schema mediscreen_patient
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mediscreen_patient` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `mediscreen_patient` ;

-- -----------------------------------------------------
-- Table `mediscreen_patient`.`trigger_word`
-- -----------------------------------------------------
CREATE TABLE `mediscreen_patient`.`trigger_word` (
  `trigger_word` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`trigger_word`),
  UNIQUE KEY `trigger_word_UNIQUE` (`trigger_word`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_ci;

-- -----------------------------------------------------
-- Insert data
-- -----------------------------------------------------
INSERT INTO trigger_word VALUES ("Hemoglobin A1C");
INSERT INTO trigger_word VALUES ("Microalbumin");
INSERT INTO trigger_word VALUES ("Height");
INSERT INTO trigger_word VALUES ("Weight");
INSERT INTO trigger_word VALUES ("Smoker");
INSERT INTO trigger_word VALUES ("Abnormal");
INSERT INTO trigger_word VALUES ("Cholesterol");
INSERT INTO trigger_word VALUES ("Dizziness");
INSERT INTO trigger_word VALUES ("Relapse");
INSERT INTO trigger_word VALUES ("Reaction");
INSERT INTO trigger_word VALUES ("Antibodies");
