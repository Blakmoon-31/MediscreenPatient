package com.openclassrooms.mediscreenPatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediscreenPatient.dto.PatientDto;
import com.openclassrooms.mediscreenPatient.service.PatientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("API pour les opérations CRUD sur les patients.")
@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	/**
	 * Get the list of all patients
	 * 
	 * @return patients - A list of Patient objects
	 */
	@ApiOperation("Récupère la liste de tous les patients.")
	@GetMapping("/patient/list")
	public List<PatientDto> getPatients() {

		List<PatientDto> patientDtos = patientService.getPatients();

		return patientDtos;
	}

	/**
	 * Get a patient by his id
	 * 
	 * @param patientId - The id of the patient
	 * @return A Patient object
	 */
	@ApiOperation("Récupère un patient à partir de son ID.")
	@GetMapping("/patient/get/{id}")
	public PatientDto getPatientById(@PathVariable("id") int patientId) {

		return patientService.getPatientById(patientId);
	}

	/**
	 * Get a patient by his family name and given name
	 * 
	 * @param familyName - The family name of the patient
	 * @param givenName  - The given name of the patient
	 * @return A Patient object
	 */
	@ApiOperation("Récupère un patient à partir de son nom de famille (familyName) et de son prénom (givenName).")
	@GetMapping("/patient/get/{familyName}/{givenName}")
	public PatientDto getPatientByFamilyAndGivenName(@PathVariable("familyName") String familyName,
			@PathVariable("givenName") String givenName) {

		return patientService.getPatientByFamilyAndGivenName(familyName, givenName);
	}

	/**
	 * Add a patient in the database
	 * 
	 * @param patient - The Patient object to add
	 */
	@ApiOperation("Ajoute un patient dans la base de données.")
	@PostMapping("/patient/add")
	public void addPatient(@RequestBody PatientDto patientDto) {

		patientService.addPatient(patientDto);

	}

	/**
	 * Update a patient in the database
	 * 
	 * @param patient - The Patient object to update
	 * @return The Patient updated
	 */
	@ApiOperation("Met à jour un patient.")
	@PutMapping("/patient/update")
	public PatientDto updatePatient(@RequestBody PatientDto patient) {

		return patientService.updatePatient(patient);
	}

	/**
	 * Delete a patient by his id
	 * 
	 * @param patientId - The id of the patient
	 */
	@ApiOperation("Supprime un patient de la base de données à partir de son ID.")
	@DeleteMapping("/patient/delete/{id}")
	public void deletePatient(@PathVariable("id") int patientId) {

		patientService.deletePatientById(patientId);

	}
}
