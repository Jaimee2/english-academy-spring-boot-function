package com.example.englishacademyspringbootfunction;

import com.example.englishacademyspringbootfunction.dto.RegistrationFormDTO;
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

    @FunctionName("processRegistration")
    public HttpResponseMessage processRegistration(
            @HttpTrigger(
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
