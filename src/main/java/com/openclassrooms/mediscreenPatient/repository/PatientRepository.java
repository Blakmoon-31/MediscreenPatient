package com.openclassrooms.mediscreenPatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mediscreenPatient.model.Patient;

/**
 * Repository for CRUD operations on Patient object.
 * 
 * @author emmanuel
 *
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findByFamilyNameAndGivenName(String familyName, String givenName);

}
