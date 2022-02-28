package com.openclassrooms.mediscreenPatient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatient.dto.PatientDto;
import com.openclassrooms.mediscreenPatient.mapper.PatientMapper;
import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.repository.PatientRepository;

/**
 * Service for CRUD operations on patients. Maps the returns into DTO objects.
 * 
 * @author emmanuel
 *
 */
@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientMapper patientMapper;

	/**
	 * Gets the list of all patients and maps it into a list of PatientDto objects.
	 * 
	 * @return A list of PatientDto objects
	 */
	public List<PatientDto> getPatients() {

		List<Patient> patients = patientRepository.findAll();
		List<PatientDto> patientDtos = patientMapper.mapPatientsToPatientDtos(patients);

		return patientDtos;
	}

	/**
	 * Gets a patient by his ID and maps him into a PatientDto object.
	 * 
	 * @param patientId - The ID to get
	 * @return A PatientDto object
	 */
	public PatientDto getPatientById(int patientId) {

		Patient patient = patientRepository.findById(patientId).get();
		PatientDto patientDto = patientMapper.mapPatientToPatientDto(patient);

		return patientDto;

	}

	/**
	 * Gets a patient by his family name and given name and maps him into a
	 * PatientDto object.
	 * 
	 * @param familyName - The family name to find
	 * @param givenName  - The given name to find
	 * @return A PatientDto object
	 */
	public PatientDto getPatientByFamilyAndGivenName(String familyName, String givenName) {

		Patient patient = patientRepository.findByFamilyNameAndGivenName(familyName, givenName);
		PatientDto patientDto = patientMapper.mapPatientToPatientDto(patient);

		return patientDto;
	}

	/**
	 * Maps a PatientDto object to a Patient object and adds it in the database.
	 * 
	 * @param patientDto - The patient to add
	 */
	public void addPatient(PatientDto patientDto) {

		Patient patientToAdd = patientMapper.mapPatientDtoToPatient(patientDto);
		patientRepository.save(patientToAdd);

	}

	/**
	 * Maps a PatientDto object into a Patient object, updates it in the database
	 * and returns the updated patient as a PatientDto object.
	 * 
	 * @param patientDto - The patient to update
	 * @return A PatientDto object
	 */
	public PatientDto updatePatient(PatientDto patientDto) {

		Patient patientToUpdate = patientMapper.mapPatientDtoToPatient(patientDto);
		patientRepository.save(patientToUpdate);
		Patient patientUpdated = patientRepository.findById(patientToUpdate.getPatientId()).get();
		PatientDto patientDtoUpdated = patientMapper.mapPatientToPatientDto(patientUpdated);

		return patientDtoUpdated;
	}

	/**
	 * Deletes a patient by his ID.
	 * 
	 * @param patientId - The ID of the patient to delete
	 */
	public void deletePatientById(int patientId) {

		patientRepository.deleteById(patientId);

	}

}
