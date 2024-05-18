package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        Long patientId = 1L;

        // when
        PatientTO patientTO = patientService.findById(patientId);

        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(patientId);
        assertThat(patientTO.getFirstName()).isEqualTo("Alicja");
        assertThat(patientTO.getLastName()).isEqualTo("Kowalczyk");
        assertThat(patientTO.getGender()).isEqualTo("FEMALE");
        assertThat(patientTO.getTelephoneNumber()).isEqualTo("111111111");
        assertThat(patientTO.getPatientNumber()).isEqualTo("A123");
        assertThat(patientTO.getDateOfBirth()).isEqualTo("1990-05-15");
        assertThat(patientTO.getAddress()).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(2L);
        assertThat(patientTO.getVisitTOS()).isNotNull();
        assertThat(patientTO.getVisitTOS().size()).isEqualTo(2);
    }

    @Transactional
    @Test
    void shouldDeletePatientById() {
        // given
        Long patientId = 1L;

        // when
        patientService.deleteById(patientId);

        // then
        PatientTO patientTO = patientService.findById(patientId);
        List<VisitTO> visitTOList = visitDao.findAll().stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toList());
        List<DoctorTO> doctorTOList = doctorDao.findAll().stream()
                .map(DoctorMapper::mapToTO)
                .collect(Collectors.toList());
        assertThat(patientTO).isNull();
        assertThat(visitTOList.size()).isEqualTo(0);
        assertThat(doctorTOList.size()).isEqualTo(1);
    }

    @Transactional
    @Test
    void shouldFindVisitsByPatientId() {
        // given
        Long patientId = 1L;

        // when
        List<VisitTO> visitTOList = patientService.findVisitsByPatientId(patientId);

        // then
        assertThat(visitTOList).isNotNull();
        assertThat(visitTOList.size()).isEqualTo(2);
    }

}