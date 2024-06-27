package com.example.englishacademyspringbootfunction;

import com.example.englishacademyspringbootfunction.student.service.dao.repository.StudentsRepository;
import com.example.englishacademyspringbootfunction.student.service.dto.RegistrationFormDTO;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;


@Slf4j
@Component
@AllArgsConstructor
public class AzureFunction {

    private FunctionCatalog functionCatalog;

    @FunctionName("hello")
    public HttpResponseMessage plainBean(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS
            ) HttpRequestMessage<Optional<String>> request,
            ExecutionContext context) {
        log.info("Received request");

        log.info("Received request for uppercase function");

        String input = request.getQueryParameters().get("input");
        if (input == null || input.isEmpty()) input = "";

        Function<String, String> uppercaseFunction = functionCatalog.lookup(Function.class, "uppercase");
        String result = uppercaseFunction.apply(input);

        return request.createResponseBuilder(HttpStatus.OK).body(result).build();

    }


}
