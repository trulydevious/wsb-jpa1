package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;

import java.util.List;

public interface PatientService {

    PatientTO findById(final Long id);
    void deleteById(final Long id);
    List<VisitTO> findAllByPatientId(Long patientId);

}
