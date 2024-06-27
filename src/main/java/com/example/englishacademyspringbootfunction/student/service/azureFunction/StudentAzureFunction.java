package com.example.englishacademyspringbootfunction.student.service.azureFunction;

import com.example.englishacademyspringbootfunction.student.service.StudentService;
import com.example.englishacademyspringbootfunction.student.service.dto.RegistrationFormDTO;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
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
                .body(studentService.GetAllStudents())
                .build();
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

        log.info("Processing registration for: {}", form);

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body("Registration processed successfully: " + form)
                .build();
    }

}
