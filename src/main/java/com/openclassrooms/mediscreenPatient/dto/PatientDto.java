package com.openclassrooms.mediscreenPatient.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfert Object of Patient used for exchange with web UI
 * 
 * @author emmanuel
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class PatientDto {

	private int patientId;

	@NotBlank(message = "Family name is mandatory")
	private String familyName;

	@NotBlank(message = "Given name is mandatory")
	private String givenName;

	@NotBlank(message = "Sex is mandatory")
	private String sex;

	@NotNull(message = "Birthdate is mandatory")
	private LocalDate birthdate;

	private String address;

	private String phone;

}
