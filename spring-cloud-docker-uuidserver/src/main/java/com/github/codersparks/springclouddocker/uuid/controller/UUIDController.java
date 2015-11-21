package com.github.codersparks.springclouddocker.uuid.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by codersparks on 21/11/2015.
 */
@RestController
public class UUIDController {


    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<UUIDResponse> getUUID() {

        UUIDResponse response = new UUIDResponse();
        response.setUuid(UUID.randomUUID().toString());

        return new ResponseEntity<UUIDResponse>(response, HttpStatus.OK);

    }
}
