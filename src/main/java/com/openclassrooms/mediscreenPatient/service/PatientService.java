package com.openclassrooms.mediscreenPatient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatient.dto.PatientDto;
import com.openclassrooms.mediscreenPatient.mapper.PatientMapper;
import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientMapper patientMapper;

	public void addPatient(PatientDto patientDto) {

		Patient patientToAdd = patientMapper.mapPatientDtoToPatient(patientDto);
		patientRepository.save(patientToAdd);

	}

	public PatientDto getPatientById(int patientId) {

		Patient patient = patientRepository.findById(patientId).get();
		PatientDto patientDto = patientMapper.mapPatientToPatientDto(patient);

		return patientDto;

	}

	public List<PatientDto> getPatients() {

		List<Patient> patients = patientRepository.findAll();
		List<PatientDto> patientDtos = patientMapper.mapPatientsToPatientDtos(patients);

		return patientDtos;
	}

	public PatientDto getPatientByFamilyAndGivenName(String familyName, String givenName) {

		Patient patient = patientRepository.findByFamilyNameAndGivenName(familyName, givenName);
		PatientDto patientDto = patientMapper.mapPatientToPatientDto(patient);

		return patientDto;
	}

	public PatientDto updatePatient(PatientDto patientDto) {

		Patient patientToUpdate = patientMapper.mapPatientDtoToPatient(patientDto);
		patientRepository.save(patientToUpdate);
		Patient patientUpdated = patientRepository.findById(patientToUpdate.getPatientId()).get();
		PatientDto patientDtoUpdated = patientMapper.mapPatientToPatientDto(patientUpdated);

		return patientDtoUpdated;
	}

	public void deletePatientById(int patientId) {

		patientRepository.deleteById(patientId);

	}

}
