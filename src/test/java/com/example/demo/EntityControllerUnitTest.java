
package com.example.demo;

import static org.mockito.ArgumentMatchers.any;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import java.time.LocalDateTime;
import java.time.format.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.demo.controllers.*;
import com.example.demo.repositories.*;
import com.example.demo.entities.*;
import com.fasterxml.jackson.databind.ObjectMapper;



/** TODO
 * Implement all the unit test in its corresponding class.
 * Make sure to be as exhaustive as possible. Coverage is checked ;)
 */

@WebMvcTest(DoctorController.class)
class DoctorControllerUnitTest{

    @MockBean
    private DoctorRepository doctorRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void this_is_a_test() throws Exception {
        Doctor doctor = new Doctor("Perla", "Amalia", 24, "p.amalia@hospital.accwe");
        when(doctorRepository.save(any(Doctor.class))).thenReturn(doctor);

        mockMvc.perform(post("/api")
                .contentType("doctors/0")
                .content(objectMapper.writeValueAsString(doctor)));


        // Ejemplo de assertThat
        assertThat(doctor.getFirstName()).isEqualTo("Perla");
        assertThat(doctor.getLastName()).isEqualTo("Amalia");
    }
}


@WebMvcTest(PatientController.class)
class PatientControllerUnitTest{

    @MockBean
    private PatientRepository patientRepository;

    @Autowired 
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void this_is_a_test() throws Exception {
        // DELETE ME
        Patient patient = new Patient("Jose Luis", "Olaya", 37, "j.olaya@email.com");
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        mockMvc.perform(post("/api")
                .contentType("patient/0")
                .content(objectMapper.writeValueAsString(patient)));

        assertThat(patient.getFirstName()).isEqualTo("Jose Luis");
        assertThat(patient.getLastName()).isEqualTo("Olaya");
    }

}

@WebMvcTest(RoomController.class)
class RoomControllerUnitTest{

    @MockBean
    private RoomRepository roomRepository;

    @Autowired 
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void this_is_a_test() throws Exception {
        // DELETE ME
        Room room = new Room("Dermatology");
        when(roomRepository.save(any(Room.class))).thenReturn(room);

        mockMvc.perform(post("/api")
                .contentType("room/0")
                .content(objectMapper.writeValueAsString(room)));

        assertThat(room.getRoomName()).isEqualTo("Dermatology");
    }

}

