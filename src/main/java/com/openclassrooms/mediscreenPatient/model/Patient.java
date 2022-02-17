package com.openclassrooms.mediscreenPatient.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int patientId;

	@NotBlank(message = "Family name is mandatory")
	@Column(name = "patient_family_name")
	private String familyName;

	@NotBlank(message = "Given name is mandatory")
	@Column(name = "patient_given_name")
	private String givenName;

	@NotBlank(message = "Sex is mandatory")
	@Column(name = "patient_sex")
	private String sex;

//	@NotNull(message = "Birthdate is mandatory")
	@Column(name = "patient_birthdate")
	private LocalDateTime birthdate;

	@Column(name = "patient_address")
	private String address;

	@Column(name = "patient_phone")
	private String phone;

}
