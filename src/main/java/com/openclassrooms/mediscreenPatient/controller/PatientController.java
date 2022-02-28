package com.openclassrooms.mediscreenPatient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mediscreenPatient.dto.PatientDto;
import com.openclassrooms.mediscreenPatient.service.PatientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The REST controller for CRUD operations on patients.
 * 
 * @author emmanuel
 *
 */
@Api("API pour les opérations CRUD sur les patients.")
@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	/**
	 * Gets the list of all patients.
	 * 
	 * @return A list of PatientDto objects
	 */
	@ApiOperation("Récupère la liste de tous les patients.")
	@GetMapping("/patient/list")
	public List<PatientDto> getPatients() {

		List<PatientDto> patientDtos = patientService.getPatients();

		return patientDtos;
	}

	/**
	 * Gets a patient by his ID.
	 * 
	 * @param patientId - The ID of the patient
	 * @return A PatientDto object
	 */
	@ApiOperation("Récupère un patient à partir de son ID.")
	@GetMapping("/patient/get/id")
	public PatientDto getPatientById(@RequestParam("patientId") int patientId) {

		return patientService.getPatientById(patientId);
	}

	/**
	 * Gets a patient by his family name and given name.
	 * 
	 * @param familyName - The family name of the patient to find
	 * @param givenName  - The given name of the patient to find
	 * @return A PatientDto object
	 */
	@ApiOperation("Récupère un patient à partir de son nom de famille (familyName) et de son prénom (givenName).")
	@GetMapping("/patient/get/name")
	public PatientDto getPatientByFamilyAndGivenName(@RequestParam("familyName") String familyName,
			@RequestParam("givenName") String givenName) {

		return patientService.getPatientByFamilyAndGivenName(familyName, givenName);
	}

	/**
	 * Adds a patient in the database.
	 * 
	 * @param patientDto - The patient to add
	 */
	@ApiOperation("Ajoute un patient dans la base de données.")
	@PostMapping("/patient/add")
	public void addPatient(@RequestBody PatientDto patientDto) {

		patientService.addPatient(patientDto);

	}

	/**
	 * Updates a patient in the database and returns the patient updated.
	 * 
	 * @param patientDto - The patient to update
	 * @return A PatientDto object
	 */
	@ApiOperation("Met à jour un patient.")
	@PutMapping("/patient/update")
	public PatientDto updatePatient(@RequestBody PatientDto patientDto) {

		return patientService.updatePatient(patientDto);
	}

	/**
	 * Deletes a patient by his ID.
	 * 
	 * @param patientId - The ID of the patient to delete
	 */
	@ApiOperation("Supprime un patient de la base de données à partir de son ID.")
	@DeleteMapping("/patient/delete")
	public void deletePatient(@RequestParam("patientId") int patientId) {

		patientService.deletePatientById(patientId);

	}
}
