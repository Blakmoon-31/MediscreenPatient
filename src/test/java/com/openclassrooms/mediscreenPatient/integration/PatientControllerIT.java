package com.openclassrooms.mediscreenPatient.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediscreenPatient.controller.PatientController;
import com.openclassrooms.mediscreenPatient.model.Patient;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class PatientControllerIT {

	@Autowired
	private PatientController patientController;

	private static ValidatorFactory validatorFactory;
	private static Validator validator;

	@BeforeAll
	public void setData() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();

		Patient patientToAdd1 = new Patient();
		patientToAdd1.setFamilyName("TestAdd1");
		patientToAdd1.setGivenName("Add1");
		patientToAdd1.setSex("M");
		patientToAdd1.setBirthdate(LocalDateTime.now());
		patientToAdd1.setAddress("Adress 1");
		patientToAdd1.setPhone("111-2222-333");

		patientController.addPatient(patientToAdd1);

		Patient patientToAdd2 = new Patient();
		patientToAdd2.setFamilyName("TestAdd2");
		patientToAdd2.setGivenName("Add2");
		patientToAdd2.setSex("M");
		patientToAdd2.setBirthdate(LocalDateTime.now());

		patientController.addPatient(patientToAdd2);

	}

	@AfterAll
	public void resetData() {

		validatorFactory.close();

		patientController
				.deletePatient(patientController.getPatientByFamilyAndGivenName("TestAdd", "Add").getPatientId());
		patientController
				.deletePatient(patientController.getPatientByFamilyAndGivenName("TestAdd1", "Add1").getPatientId());

	}

	@Test
	public void testGetPatients() {

		List<Patient> patientsList = patientController.getPatients();

		assertThat(patientsList.size()).isGreaterThanOrEqualTo(4);
	}

	@Test
	public void testGetPatientById() {

		Optional<Patient> patientFound = patientController.getPatientById(3);

		assertThat(patientFound.get().getFamilyName()).isEqualTo("TestInDanger");

	}

	@Test
	public void testGetPatientByFamilyAndGivenName() {

		Patient patientFound = patientController.getPatientByFamilyAndGivenName("TestInDanger", "Test");

		assertThat(patientFound.getPatientId()).isEqualTo(3);

	}

	@Test
	public void testAddPatient() {

		Patient patientToAdd = new Patient();
		patientToAdd.setFamilyName("TestAdd");
		patientToAdd.setGivenName("Add");
		patientToAdd.setSex("M");
		patientToAdd.setBirthdate(LocalDateTime.now());

		patientController.addPatient(patientToAdd);

		Patient patientAdded = patientController.getPatientByFamilyAndGivenName("TestAdd", "Add");

		assertThat(patientAdded.getSex()).isEqualTo("M");

	}

	@Test
	public void testPatientValidation() {

		Patient patientToAdd = new Patient();
		patientToAdd.setFamilyName("TestAdd");
		patientToAdd.setGivenName("Add");
		patientToAdd.setBirthdate(LocalDateTime.now());

		Set<ConstraintViolation<Patient>> violations = validator.validate(patientToAdd);

		assertThat(violations.size()).isEqualTo(1);

		ConstraintViolation<Patient> violation = violations.iterator().next();
		assertThat(violation.getMessage()).isEqualTo("Sex is mandatory");
		assertThat(violation.getPropertyPath().toString()).isEqualTo("sex");

	}

	@Test
	public void testUpdatePatient() {

		Patient patientToUpdate = patientController.getPatientByFamilyAndGivenName("TestAdd1", "Add1");

		patientToUpdate.setSex("F");

		patientController.updatePatient(patientToUpdate);

		Patient patientUpdated = patientController.getPatientById(patientToUpdate.getPatientId()).get();

		assertThat(patientUpdated.getSex()).isEqualTo("F");

	}

	@Test
	public void testDeletePatient() {

		List<Patient> patientsBefore = patientController.getPatients();

		Patient patientToDelete = patientController.getPatientByFamilyAndGivenName("TestAdd2", "Add2");

		patientController.deletePatient(patientToDelete.getPatientId());

		List<Patient> patientsAfter = patientController.getPatients();

		assertThat(patientsBefore.size()).isEqualTo(patientsAfter.size() + 1);
	}
}
