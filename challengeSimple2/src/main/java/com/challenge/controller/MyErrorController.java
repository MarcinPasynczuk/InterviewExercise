package com.challenge.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.challenge.model.Constants;

@Controller
public class MyErrorController implements ErrorController {

    @GetMapping("/404")
    public String handleError() {
    	return Constants.PAGENOTFOUND;
    }
}