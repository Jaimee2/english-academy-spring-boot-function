package com.example.englishacademyspringbootfunction.student.azure.function;

import com.example.englishacademyspringbootfunction.student.dao.entity.Student;
import com.example.englishacademyspringbootfunction.student.dto.RegistrationFormDTO;
import com.example.englishacademyspringbootfunction.student.service.StudentService;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
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
            ) HttpRequestMessage<Optional<String>> request) {

        log.info("Received request to get all students");

        return request.createResponseBuilder(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(studentService.findAllStudents())
                .build();
    }

    @FunctionName("getStudentById")
    public HttpResponseMessage getStudentById(
            @HttpTrigger(name = "req",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "students/{id}"
            ) HttpRequestMessage<Optional<String>> request,
            @BindingName("id") String id) {
        log.info("Received request to fetch student with id: {}", id);

        return request
                .createResponseBuilder(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(studentService.getStudent(id))
                .build();
    }

    @FunctionName("deleteStudentById")
    public HttpResponseMessage deleteStudentById(
            @HttpTrigger(name = "req",
                    methods = {HttpMethod.DELETE},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "students/{id}"
            ) HttpRequestMessage<Optional<String>> request,
            @BindingName("id") String id) {
        log.info("Received request to delete student with id: {}", id);

        studentService.deleteStudentById(id);

        return request.createResponseBuilder(HttpStatus.OK).build();
    }

    @FunctionName("processRegistration")
    public HttpResponseMessage processRegistration(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "registrations"
            ) HttpRequestMessage<Optional<RegistrationFormDTO>> request) {
        log.info("Received registration request");

        RegistrationFormDTO form = request.getBody().orElse(null);

        if (form == null)
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Invalid registration form").build();

        Student student = studentService.saveStudent(form);
        log.info("Processing registration for: {}", form);

        return request.createResponseBuilder(HttpStatus.OK)
                .body("Registration processed successfully: " + student.toString())
                .build();
    }

    @FunctionName("addClassToStudent")
    public HttpResponseMessage addClassToStudent(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.PUT},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "student/{studentId}/addClass/{classRoomId}"
            ) HttpRequestMessage<Optional<String>> request,
            @BindingName("studentId") String studentId,
            @BindingName("classRoomId") String classRoomId) {
        log.info("Received request to add classRoom {} to student {}", classRoomId, studentId);
        return request
                .createResponseBuilder(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(studentService.addClassToStudent(studentId, classRoomId))
                .build();
    }

//    @FunctionName("warmUp")
//    public void warmUp(// Every 5 minutes
//                       @TimerTrigger(name = "keepWarmTrigger", schedule = "0 */1 * * * *") String timerInfo,
//                       ExecutionContext context) {
//        log.info(System.getProperties().toString());
//        log.info("Warm-up trigger fired at: {}", java.time.LocalDateTime.now());
//    }

}
