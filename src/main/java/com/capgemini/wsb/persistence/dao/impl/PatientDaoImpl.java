package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findAllByLastName(String lastName) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithVisitsGreaterThan(int numberOfVisits) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE SIZE(p.visitEntities) > :numberOfVisits", PatientEntity.class)
                .setParameter("numberOfVisits", numberOfVisits)
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsByGender(String gender) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE UPPER(p.gender) LIKE CONCAT('%', UPPER(:gender), '%')", PatientEntity.class)
                .setParameter("gender", gender)
                .getResultList();
    }
}
