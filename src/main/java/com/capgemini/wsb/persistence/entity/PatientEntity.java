package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Gender;
import com.capgemini.wsb.persistence.enums.TreatmentType;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String patientNumber;

	@Column(nullable = false)
	private LocalDate dateOfBirth;

	@OneToOne
	@JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)	// Relacja jeden do jednego z AddressEntity (jednostronna od strony dziecka)
	private AddressEntity address;

	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)	// Relacja jeden do wielu z VisitEntity (jednostronna od strony dziecka)
	private Set<VisitEntity> visitEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public Set<VisitEntity> getVisitEntities() {
		return visitEntities;
	}

	public void setVisitEntities(Set<VisitEntity> visits) {
		this.visitEntities = visitEntities;
	}

	public Gender getGender() {return gender;}

	public void setGender(Gender gender) {this.gender = gender;}
}
