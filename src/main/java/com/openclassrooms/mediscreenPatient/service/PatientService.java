package com.openclassrooms.mediscreenPatient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public void addPatient(Patient patient) {

		patientRepository.save(patient);

	}

	public Optional<Patient> getPatientById(int patientId) {

		return patientRepository.findById(patientId);

	}

	public List<Patient> getPatients() {

		return patientRepository.findAll();
	}

	public Patient getPatientByFamilyAndGivenName(String familyName, String givenName) {

		return patientRepository.findByFamilyNameAndGivenName(familyName, givenName);
	}

	public Patient updatePatient(Patient patient) {

		patientRepository.save(patient);
		Patient patientUpdated = patientRepository.findById(patient.getPatientId()).get();

		return patientUpdated;
	}

	public void deletePatientById(int patientId) {

		patientRepository.deleteById(patientId);

	}

}
