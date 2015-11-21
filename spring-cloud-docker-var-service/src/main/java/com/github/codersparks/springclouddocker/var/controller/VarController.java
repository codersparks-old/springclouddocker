package com.github.codersparks.springclouddocker.var.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by codersparks on 21/11/2015.
 */
@RestController
public class VarController {

    @Value("${instance.var1}")
    private String var1;

    @Value("${instance.var2}")
    private String var2;

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public ResponseEntity<VarResponse> getVars() {

        VarResponse response = new VarResponse();

        response.setVar1(var1);
        response.setVar2(var2);

        return new ResponseEntity<VarResponse>(response, HttpStatus.OK);
    }
}
