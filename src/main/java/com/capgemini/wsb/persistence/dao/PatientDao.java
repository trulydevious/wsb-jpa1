package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    List<PatientEntity> findAllByLastName(String lastName);
    List<PatientEntity> findPatientsWithVisitsGreaterThan(int numberOfVisits);
    List<PatientEntity> findPatientsByGender(String gender);
}
