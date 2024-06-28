package com.example.englishacademyspringbootfunction.student.service.impl;

import com.example.englishacademyspringbootfunction.student.dao.entity.Student;
import com.example.englishacademyspringbootfunction.student.dao.repository.StudentsRepository;
import com.example.englishacademyspringbootfunction.student.dto.RegistrationFormDTO;
import com.example.englishacademyspringbootfunction.student.mapper.MapperStruct;
import com.example.englishacademyspringbootfunction.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentsRepository studentsRepository;

    public List<Student> findAllStudents() {
        return studentsRepository.findAll();
    }

    public Student saveStudent(RegistrationFormDTO registrationFormDTO) {
        return studentsRepository.save(MapperStruct.INSTANCE.dtoToDao(registrationFormDTO));
    }

}
