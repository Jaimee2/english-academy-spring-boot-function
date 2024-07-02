package com.example.englishacademyspringbootfunction.student.azure.function;

import com.example.englishacademyspringbootfunction.student.dto.ClassRoomDTO;
import com.example.englishacademyspringbootfunction.student.service.ClassRoomService;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
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
public class ClassRoomAzureFunction {

    private ClassRoomService classRoomService;

    @FunctionName("classRoomRegistration")
    public HttpResponseMessage classRoomRegistration(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    route = "classRoomRegistration"
            ) HttpRequestMessage<Optional<ClassRoomDTO>> request) {

        log.info("Received registration request");

        ClassRoomDTO classRoom = request.getBody().orElse(null);

        if (classRoom == null)
            return request
                    .createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Invalid registration form")
                    .build();

        classRoomService.createClassRoom(classRoom);

        log.info("Processing registration for: {}", classRoom);

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body("Registration processed successfully: " + classRoom)
                .build();
    }

}
