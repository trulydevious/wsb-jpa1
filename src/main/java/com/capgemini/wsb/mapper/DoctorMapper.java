package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import java.util.Set;
import java.util.stream.Collectors;

public final class DoctorMapper {

    public static DoctorTO mapToTO(final DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        doctorTO.setAddress(AddressMapper.mapToTO(doctorEntity.getAddress()));
        doctorTO.setVisitEntities(doctorEntity.getVisitEntities().stream()
                .map(VisitMapper::mapToTO)
                .collect(Collectors.toSet()));
        return doctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTO) {
        if (doctorTO == null) {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorEntity.setEmail(doctorTO.getEmail());
        doctorEntity.setDoctorNumber(doctorTO.getDoctorNumber());
        doctorEntity.setSpecialization(doctorTO.getSpecialization());
        doctorEntity.setAddress(AddressMapper.mapToEntity(doctorTO.getAddress()));
        doctorEntity.setVisits(doctorTO.getVisitEntities().stream()
                .map(VisitMapper::mapToEntity)
                .collect(Collectors.toSet()));
        doctorEntity.setId(doctorTO.getId());
        return doctorEntity;
    }
}

