package com.example.englishacademyspringbootfunction.student.azureFunction;

import com.example.englishacademyspringbootfunction.student.dao.entity.Student;
import com.example.englishacademyspringbootfunction.student.dto.RegistrationFormDTO;
import com.example.englishacademyspringbootfunction.student.service.StudentService;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class StudentAzureFunction {

    private StudentService studentService;

    @FunctionName("getAllStudents")
    public HttpResponseMessage getAllStudents(
            @HttpTrigger(name = "req",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "students"
            ) HttpRequestMessage<Optional<String>> request,
            ExecutionContext context) {
        log.info(context.toString());
        log.info("Received request to get all students");

        return request.createResponseBuilder(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(studentService.findAllStudents())
                .build();
    }

    @FunctionName("deleteStudentById")
    public HttpResponseMessage deleteStudentById(
            @HttpTrigger(name = "req",
                    methods = {HttpMethod.DELETE},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "students/{id}"
            ) HttpRequestMessage<Optional<String>> request,
            @BindingName("id") String id,
            ExecutionContext context) {
        log.info("Received request to delete student with id: {}", id);
        studentService.deleteStudentById(id);
        return request.createResponseBuilder(HttpStatus.OK).build();

    }

    @FunctionName("processRegistration")
    public HttpResponseMessage processRegistration(@HttpTrigger(
            name = "req",
            methods = {HttpMethod.POST},
            authLevel = AuthorizationLevel.ANONYMOUS,
            route = "registrations"
    ) HttpRequestMessage<Optional<RegistrationFormDTO>> request,
                                                   ExecutionContext context) {
        log.info("Received registration request");

        RegistrationFormDTO form = request.getBody().orElse(null);

        if (form == null)
            return request
                    .createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Invalid registration form")
                    .build();

        Student student = studentService.saveStudent(form);
        log.info("Processing registration for: {}", form);

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body("Registration processed successfully: " + student.toString())
                .build();
    }

}
