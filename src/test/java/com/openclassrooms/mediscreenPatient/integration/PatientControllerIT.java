package com.openclassrooms.mediscreenPatient.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
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
import com.openclassrooms.mediscreenPatient.dto.PatientDto;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class PatientControllerIT {

	@Autowired
	private PatientController patientController;

	private static ValidatorFactory validatorFactory;
	private static Validator validator;

	@BeforeAll
	public void setTestData() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();

		PatientDto patientDtoToAdd1 = new PatientDto();
		patientDtoToAdd1.setFamilyName("TestAdd1");
		patientDtoToAdd1.setGivenName("Add1");
		patientDtoToAdd1.setSex("M");
		patientDtoToAdd1.setBirthdate(LocalDate.now());
		patientDtoToAdd1.setAddress("Adress 1");
		patientDtoToAdd1.setPhone("111-2222-333");

		patientController.addPatient(patientDtoToAdd1);

		PatientDto patientDtoToAdd2 = new PatientDto();
		patientDtoToAdd2.setFamilyName("TestAdd2");
		patientDtoToAdd2.setGivenName("Add2");
		patientDtoToAdd2.setSex("M");
		patientDtoToAdd2.setBirthdate(LocalDate.now());

		patientController.addPatient(patientDtoToAdd2);

	}

	@AfterAll
	public void resetTestData() {

		validatorFactory.close();

		patientController
				.deletePatient(patientController.getPatientByFamilyAndGivenName("TestAdd", "Add").getPatientId());
		patientController
				.deletePatient(patientController.getPatientByFamilyAndGivenName("TestAdd1", "Add1").getPatientId());

	}

	@Test
	public void testGetPatients() {

		List<PatientDto> patientDtosList = patientController.getPatients();

		assertThat(patientDtosList.size()).isGreaterThanOrEqualTo(4);
	}

	@Test
	public void testGetPatientById() {

		PatientDto patientDtoFound = patientController.getPatientById(3);

		assertThat(patientDtoFound.getFamilyName()).isEqualTo("TestInDanger");

	}

	@Test
	public void testGetPatientByFamilyAndGivenName() {

		PatientDto patientDtoFound = patientController.getPatientByFamilyAndGivenName("TestInDanger", "Test");

		assertThat(patientDtoFound.getPatientId()).isEqualTo(3);

	}

	@Test
	public void testAddPatient() {

		PatientDto patientDtoToAdd = new PatientDto();
		patientDtoToAdd.setFamilyName("TestAdd");
		patientDtoToAdd.setGivenName("Add");
		patientDtoToAdd.setSex("M");
		patientDtoToAdd.setBirthdate(LocalDate.now());

		patientController.addPatient(patientDtoToAdd);

		PatientDto patientAdded = patientController.getPatientByFamilyAndGivenName("TestAdd", "Add");

		assertThat(patientAdded.getSex()).isEqualTo("M");

	}

	@Test
	public void testPatientValidation() {

		PatientDto patientDtoToAdd = new PatientDto();
		patientDtoToAdd.setFamilyName("TestAdd");
		patientDtoToAdd.setGivenName("Add");
		patientDtoToAdd.setBirthdate(LocalDate.now());

		Set<ConstraintViolation<PatientDto>> violations = validator.validate(patientDtoToAdd);

		assertThat(violations.size()).isEqualTo(1);

		ConstraintViolation<PatientDto> violation = violations.iterator().next();
		assertThat(violation.getMessage()).isEqualTo("Sex is mandatory");
		assertThat(violation.getPropertyPath().toString()).isEqualTo("sex");

	}

	@Test
	public void testUpdatePatient() {

		PatientDto patientDtoToUpdate = patientController.getPatientByFamilyAndGivenName("TestAdd1", "Add1");

		patientDtoToUpdate.setSex("F");

		patientController.updatePatient(patientDtoToUpdate);

		PatientDto patientDtoUpdated = patientController.getPatientById(patientDtoToUpdate.getPatientId());

		assertThat(patientDtoUpdated.getSex()).isEqualTo("F");

	}

	@Test
	public void testDeletePatient() {

		List<PatientDto> patientsBefore = patientController.getPatients();

		PatientDto patientToDelete = patientController.getPatientByFamilyAndGivenName("TestAdd2", "Add2");

		patientController.deletePatient(patientToDelete.getPatientId());

		Collection<PatientDto> patientsAfter = patientController.getPatients();

		assertThat(patientsBefore.size()).isEqualTo(patientsAfter.size() + 1);
	}
}
