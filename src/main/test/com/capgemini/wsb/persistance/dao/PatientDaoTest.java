package com.capgemini.wsb.persistance.dao;

import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientsByLastName() {
        // given
        String lastName = "Kowalczyk";

        // when
        List<PatientEntity> patientEntities = patientDao.findAllByLastname(lastName);

        // then
        assertThat(patientEntities).isNotEmpty();
        assertThat(patientEntities).allMatch(patient -> patient.getLastName().equals(lastName));
    }

    @Transactional
    @Test
    public void testShouldFindPatientsWithVisitsGreaterThan() {
        // given
        int numberOfVisits = 1;

        // when
        List<PatientEntity> patientEntities = patientDao.findPatientsWithVisitsGreaterThan(numberOfVisits);

        // then
        assertThat(patientEntities).isNotEmpty();
        assertThat(patientEntities).allMatch(patient -> patient.getVisits().size() > numberOfVisits);
    }

    @Transactional
    @Test
    public void testShouldFindPatientsByGender() {
        // given
        String gender = Gender.FEMALE;

        // when
        List<PatientEntity> patientEntities = patientDao.findPatientsByGender(gender);

        // then
        assertThat(patientEntities).isNotEmpty();
        assertThat(patientEntities).allMatch(patient -> patient.getGender() == Gender.FEMALE);
    }

}
