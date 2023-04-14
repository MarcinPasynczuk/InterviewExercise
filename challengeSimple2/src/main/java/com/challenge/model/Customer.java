package com.challenge.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	    private static final String MANDATORY = "This field is mandatory";
	    private static final String INVALID_EMAIL = "Invalid email address";
	    private static final String SIZE_MIN_OR_MAX = "This field must be between {min} and {max} characters";
	    private static final String INVALID_POSTCODE = "Invalid postcode format";
	    private static final String INVALID_PHONE_NUMBER = "Invalid phone number format";

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    @Column(name = "registered")
	    private LocalDateTime registered;

	    @NotNull(message = MANDATORY)
	    @Email(message = INVALID_EMAIL)
	    @Size(max = 255, message = SIZE_MIN_OR_MAX)
	    @Column(name = "email_address", unique = true)
	    private String emailAddress;

	    @NotNull(message = MANDATORY)
	    @Size(min = 2, max = 5, message = SIZE_MIN_OR_MAX)
	    @Column(name = "title")
	    private String title;

	    @NotNull(message = MANDATORY)
	    @Size(min = 1, max = 50, message = SIZE_MIN_OR_MAX)
	    @Column(name = "first_name")
	    private String firstName;

	    @NotNull(message = MANDATORY)
	    @Size(min = 1, max = 50, message = SIZE_MIN_OR_MAX)
	    @Column(name = "last_name")
	    private String lastName;

	    @NotNull(message = MANDATORY)
	    @Size(min = 1, max = 255, message = SIZE_MIN_OR_MAX)
	    @Column(name = "address_line_1")
	    private String addressLine1;

	    @Size(max = 255, message = SIZE_MIN_OR_MAX)
	    @Column(name = "address_line_2")
	    private String addressLine2;

	    @Size(max = 255, message = SIZE_MIN_OR_MAX)
	    @Column(name = "city")
	    private String city;

	    @NotNull(message = MANDATORY)
	    @Size(min = 1, max = 10, message = SIZE_MIN_OR_MAX)
	    @Pattern(regexp = "^[0-9A-Za-z\\s]+$", message = INVALID_POSTCODE)
	    @Column(name = "postcode")
	    private String postcode;

	    @Size(max = 20, message = SIZE_MIN_OR_MAX)
	    @Pattern(regexp = "^(\\+\\d{1,4})?\\d{7,14}$", message = INVALID_PHONE_NUMBER)
	    @Column(name = "phone_number")
	    private String phoneNumber;
	}