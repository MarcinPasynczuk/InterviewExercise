package com.challenge.controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.challenge.apis.MailApi;
import com.challenge.model.Customer;
import com.challenge.service.CustomerService;


@Controller
public class RegistrationController {
    private final CustomerService customerService;

    public RegistrationController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    private MailApi mailApi;
    
    @ModelAttribute("customer")
    public Customer createCustomer() {
    	
        return new Customer();
    }

    @PostMapping("/registration")
    public String submitRegistrationForm(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    	customer.setRegistered(LocalDateTime.now());
    	if (customerService.emailExists(customer.getEmailAddress())) {
            bindingResult.rejectValue("emailAddress", "email.exists", "Email is already used.");
        }
        if (bindingResult.hasErrors()) {
//            for (ObjectError error : bindingResult.getAllErrors()) {
//                System.out.println(error);
//            }
            return "registration";
        }
        customerService.saveCustomer(customer);
        mailApi.sendConf(customer.getEmailAddress());
        return "redirect:/success";
    }
;
    @GetMapping(value = "/success")
    public String gotoSuccessPage(ModelMap model) {
        return "success";
    }

    @GetMapping(value = "/registration")
    public String gotoRegistrationPage(ModelMap model) {
    	
        return "registration";
    }
    
    @GetMapping(value = "/")
    public String gotoMainPage(ModelMap model) {
    	
        return "index";
    }          
}