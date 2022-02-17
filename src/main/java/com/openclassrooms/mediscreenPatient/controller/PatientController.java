package com.openclassrooms.mediscreenPatient.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	/**
	 * Get the list of all patients
	 * 
	 * @return patients - A list of Patient objects
	 */
	@GetMapping("/patient/list")
	public List<Patient> getPatients() {

		List<Patient> patients = patientService.getPatients();

		return patients;
	}

	/**
	 * Get a patient by his id
	 * 
	 * @param patientId - The id of the patient
	 * @return An optional Patient object
	 */
	@GetMapping("/patient/get/{id}")
	public Optional<Patient> getPatientById(@PathVariable("id") int patientId) {

		return patientService.getPatientById(patientId);
	}

	/**
	 * Get a patient by his family name and given name
	 * 
	 * @param familyName - The family name of the patient
	 * @param givenName  - The given name of the patient
	 * @return A Patient object
	 */
	@GetMapping("/patient/get/{family}/{given}")
	public Patient getPatientByFamilyAndGivenName(@PathVariable("family") String familyName,
			@PathVariable("given") String givenName) {

		return patientService.getPatientByFamilyAndGivenName(familyName, givenName);
	}

	/**
	 * Add a patient in the database
	 * 
	 * @param patient - The Patient object to add
	 */
	@PostMapping("/patient/add")
	public void addPatient(@RequestBody Patient patient) {

		patientService.addPatient(patient);

	}

	/**
	 * Update a patient in the database
	 * 
	 * @param patient - The Patient object to update
	 * @return The Patient updated
	 */
	@PutMapping("/patient/update")
	public Patient updatePatient(@RequestBody Patient patient) {

		return patientService.updatePatient(patient);
	}

	/**
	 * Delete a patient by his id
	 * 
	 * @param patientId - The id of the patient
	 */
	@DeleteMapping("/patient/delete/{id}")
	public void deletePatient(@PathVariable("id") int patientId) {

		patientService.deletePatientById(patientId);

	}
}
