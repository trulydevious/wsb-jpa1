package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.stream.Collectors;

public final class VisitMapper {

    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setPatientId(visitEntity.getPatient().getId());
        visitTO.setDoctorId(visitEntity.getDoctor().getId());
        visitTO.setMedicalTreatmentTOS(visitEntity.getMedicalTreatmentEntities().stream()
                .map(MedicalTreatmentMapper::mapToTO)
                .collect(Collectors.toSet()));
        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        visitEntity.setPatientId(visitTO.getPatientId());
        visitEntity.setDoctorId(visitTO.getDoctorId());
        visitEntity.setMedicalTreatmentEntities(visitTO.getMedicalTreatmentTOS().stream()
                .map(MedicalTreatmentMapper::mapToEntity)
                .collect(Collectors.toSet()));
        return visitEntity;
    }
}
