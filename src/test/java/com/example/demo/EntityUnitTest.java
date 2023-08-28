package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.demo.repositories.AppointmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.example.demo.entities.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestInstance(Lifecycle.PER_CLASS)
class EntityUnitTest {

	@Autowired
	private TestEntityManager entityManager;

    private Appointment a1;
    private Appointment a2;
    private Appointment a3;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @BeforeEach
    void setUp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        LocalDateTime startsAt= LocalDateTime.parse("19:30 24/04/2023", formatter);
        LocalDateTime finishesAt = LocalDateTime.parse("20:30 24/04/2023", formatter);

        Patient p1 = new Patient("Jose Luis", "Olaya", 37, "j.olaya@email.com");
        Doctor d1 = new Doctor("Perla", "Amalia", 24, "p.amalia@hospital.accwe");
        Room r1 = new Room("Dermatology");

        Patient p2 = new Patient("Victor", "Algaba", 20, "j.olaya@email.com");
        Doctor d2 = new Doctor("Javier", "Amalia", 24, "j.amalia@hospital.accwe");
        Room r2 = new Room("Oficina");

        Patient p3 = new Patient("Jose ", "Olaya", 37, "jj.olaya@email.com");
        Doctor d3 = new Doctor("Perla", "Amalia", 20, "p.amalia@hospital.accwe");
        Room r3 = new Room("Casa");

        a1 = new Appointment(p1, d1, r1, startsAt, finishesAt);
        a2 = new Appointment(p2, d2, r2, startsAt, finishesAt);
        a3 = new Appointment(p3, d3, r3, startsAt, finishesAt);
    }

    @Test
    void this_is_a_test(){
        // DELETE THIS TEST

        appointmentRepository.save(a1);
        entityManager.persist(a1);
        appointmentRepository.save(a2);
        entityManager.persist(a2);
        appointmentRepository.save(a3);
        entityManager.persist(a3);
        entityManager.flush();

        List<Appointment> retrievedAppointments = appointmentRepository.findAll();

        assertThat(retrievedAppointments).hasSize(3);
        assertThat(retrievedAppointments.get(0)).isEqualTo(a1);
        assertThat(retrievedAppointments.get(1)).isEqualTo(a2);
        assertThat(retrievedAppointments.get(2)).isEqualTo(a3);
    }

}

    /** TODO
     * Implement tests for each Entity class: Doctor, Patient, Room and Appointment.
     * Make sure you are as exhaustive as possible. Coverage is checked ;)
     */



