package com.capgemini.wsb.persistence.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(name = "patient_id")
    private Long patientId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, insertable = false, updatable = false) // Relacja wiele do jednego z PatientEntity (od strony dziecka)
    private PatientEntity patient;

    @Column(name = "doctor_id")
    private Long doctorId;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false, insertable = false, updatable = false) // Relacja wiele do jednego z DoctorEntity (od strony dziecka)
    private DoctorEntity doctor;

    @ManyToMany // Relacja wiele do wielu z MedicalTreatmentEntity (dwustronna)
    @JoinTable(
            name = "VISIT_MEDICAL_TREATMENT",
            joinColumns = @JoinColumn(name = "visit_id"),
            inverseJoinColumns = @JoinColumn(name = "medical_treatment_id")
    )
    private Set<MedicalTreatmentEntity> medicalTreatmentEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public Set<MedicalTreatmentEntity> getMedicalTreatmentEntities() {
        return medicalTreatmentEntities;
    }

    public void setMedicalTreatmentEntities(Set<MedicalTreatmentEntity> medicalTreatmentEntities) {
        this.medicalTreatmentEntities = medicalTreatmentEntities;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
