package com.example.englishacademyspringbootfunction.student.service.impl;

import com.example.englishacademyspringbootfunction.student.dao.entity.Student;
import com.example.englishacademyspringbootfunction.student.dao.repository.StudentsRepository;
import com.example.englishacademyspringbootfunction.student.dto.RegistrationFormDTO;
import com.example.englishacademyspringbootfunction.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.englishacademyspringbootfunction.student.mapper.StudentMapStruct.STUDENT_MAP_STRUCT;

@Slf4j
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentsRepository studentsRepository;

    public List<Student> findAllStudents() {
        return studentsRepository.findAll();
    }

    public Student saveStudent(RegistrationFormDTO registrationFormDTO) {
        return studentsRepository.save(STUDENT_MAP_STRUCT.dtoToDao(registrationFormDTO));
    }

    public void deleteStudentById(String id) {
        studentsRepository.deleteById(id);
    }

}
