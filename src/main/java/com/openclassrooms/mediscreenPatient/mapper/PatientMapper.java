package com.openclassrooms.mediscreenPatient.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatient.dto.PatientDto;
import com.openclassrooms.mediscreenPatient.model.Patient;

/**
 * The mapper between Patient and PatientDto objects.
 * 
 * @author emmanuel
 *
 */
@Service
public class PatientMapper {

	/**
	 * Maps a Patient object into a PatientDto object.
	 * 
	 * @param patient - The Patient object to map
	 * @return A PatientDto object
	 */
	public PatientDto mapPatientToPatientDto(Patient patient) {

		PatientDto patientDto = new PatientDto();
		patientDto.setPatientId(patient.getPatientId());
		patientDto.setFamilyName(patient.getFamilyName());
		patientDto.setGivenName(patient.getGivenName());
		patientDto.setSex(patient.getSex());
		patientDto.setBirthdate(patient.getBirthdate());
		patientDto.setAddress(patient.getAddress());
		patientDto.setPhone(patient.getPhone());

		return patientDto;
	}

	/**
	 * Maps a PatientDto object into a Patient object.
	 * 
	 * @param patientDto - The PatientDto object to map
	 * @return A Patient object
	 */
	public Patient mapPatientDtoToPatient(PatientDto patientDto) {

		Patient patient = new Patient();
		patient.setPatientId(patientDto.getPatientId());
		patient.setFamilyName(patientDto.getFamilyName());
		patient.setGivenName(patientDto.getGivenName());
		patient.setSex(patientDto.getSex());
		patient.setBirthdate(patientDto.getBirthdate());
		patient.setAddress(patientDto.getAddress());
		patient.setPhone(patientDto.getPhone());

		return patient;
	}

	/**
	 * Maps a list of Patient objects into a list of PatientDto objects.
	 * 
	 * @param patients - The list of Patient objects to map
	 * @return A list of PatientDto objects
	 */
	public List<PatientDto> mapPatientsToPatientDtos(List<Patient> patients) {

		List<PatientDto> patientDtos = new ArrayList<>();

		for (Patient patient : patients) {
			patientDtos.add(mapPatientToPatientDto(patient));
		}

		return patientDtos;
	}
}
