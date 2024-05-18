insert into address (id, address_line1, address_line2, city, postal_code) values (1, 'xx', 'yy', 'city', '62-030');

insert into address (id, address_line1, address_line2, city, postal_code) values (2, 'Aleje Jerozolimskie 123', 'Lokal 52', 'Warszawa', '00-001');

insert into doctor (id, first_name, last_name, telephone_number, doctor_number, specialization, address_id) values (1, 'Jan', 'Kowalski', '123456789', '123456', 'DERMATOLOGIST', 1);

insert into patient (id, first_name, last_name, gender, telephone_number, patient_number, date_of_birth, address_id) values (1, 'Alicja', 'Kowalczyk', 'FEMALE', '111111111', 'A123', '1990-05-15', 2);

insert into medical_treatment (id, description, type) values (1, 'Regular checkup', 'USG');

insert into visit (id, description, time, patient_id, doctor_id) values(1, 'Checkup 1.', '2024-05-12 10:00:00', 1, 1);

insert into visit (id, description, time, patient_id, doctor_id) values(2, 'Checkup 2.', '2024-05-16 10:00:00', 1, 1);

insert into visit_medical_treatment (visit_id, medical_treatment_id) values (1, 1);

insert into visit_medical_treatment (visit_id, medical_treatment_id) values (2, 1);

