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
INSERT INTO trigger_word VALUES ("Hémoglobine A1C");
INSERT INTO trigger_word VALUES ("Microalbumine");
INSERT INTO trigger_word VALUES ("Taille");
INSERT INTO trigger_word VALUES ("Poids");
INSERT INTO trigger_word VALUES ("Fumeur");
INSERT INTO trigger_word VALUES ("Anormal");
INSERT INTO trigger_word VALUES ("Cholestérol");
INSERT INTO trigger_word VALUES ("Vertige");
INSERT INTO trigger_word VALUES ("Rechute");
INSERT INTO trigger_word VALUES ("Réaction");
INSERT INTO trigger_word VALUES ("Anticorps");
