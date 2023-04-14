package com.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ModelMap;
import com.challenge.controller.RegistrationController;
import com.challenge.model.Customer;
import com.challenge.repository.CustomerRepository;
import com.challenge.service.CustomerService;

@SpringBootTest
class ChallengeApplicationTests {

	 private Customer customer;

	    @BeforeEach
	    public void setUp() {
	        customer = new Customer();
	    }

	    @Test
	    public void testCustomer() {
	        customer.setId(1L);
	        customer.setRegistered(LocalDateTime.now());
	        customer.setEmailAddress("test@example.com");
	        customer.setTitle("Mr");
	        customer.setFirstName("John");
	        customer.setLastName("Doe");
	        customer.setAddressLine1("123 Main St");
	        customer.setAddressLine2("Apt 4B");
	        customer.setCity("New York");
	        customer.setPostcode("12345");
	        customer.setPhoneNumber("+11234567890");

	        assertNotNull(customer);
	        assertEquals(1L, customer.getId());
	        assertNotNull(customer.getRegistered());
	        assertEquals("test@example.com", customer.getEmailAddress());
	        assertEquals("Mr", customer.getTitle());
	        assertEquals("John", customer.getFirstName());
	        assertEquals("Doe", customer.getLastName());
	        assertEquals("123 Main St", customer.getAddressLine1());
	        assertEquals("Apt 4B", customer.getAddressLine2());
	        assertEquals("New York", customer.getCity());
	        assertEquals("12345", customer.getPostcode());
	        assertEquals("+11234567890", customer.getPhoneNumber());
	    }
	    
	    
	    @Mock
	    private CustomerService customerService;

	    private RegistrationController registrationController;

	    
		@BeforeEach
	    void setUp1() {
	        MockitoAnnotations.openMocks(this);
	        registrationController = new RegistrationController(customerService);
	    }

	   

	    
	    @Test
	    void createCustomer_ShouldReturnNewCustomer() {
	        // Act
	        Customer customer = registrationController.createCustomer();

	        // Assert
	        assertEquals(new Customer(), customer);
	    }

	    @Test
	    void gotoSuccessPage_ShouldReturnSuccessView() {
	        // Arrange
	        ModelMap modelMap = new ModelMap();

	        // Act
	        String viewName = registrationController.gotoSuccessPage(modelMap);

	        // Assert
	        assertEquals("success", viewName);
	    }

	    @Test
	    void gotoRegistrationPage_ShouldReturnRegistrationView() {
	        // Arrange
	        ModelMap modelMap = new ModelMap();

	        // Act
	        String viewName = registrationController.gotoRegistrationPage(modelMap);

	        // Assert
	        assertEquals("registration", viewName);
	    }

	    @Test
	    void gotoMainPage_ShouldReturnIndexView() {
	        // Arrange
	        ModelMap modelMap = new ModelMap();

	        // Act
	        String viewName = registrationController.gotoMainPage(modelMap);

	        // Assert
	        assertEquals("index", viewName);
	    }


	    @Mock
	    private CustomerRepository customerRepository;

	    
	    @BeforeEach
	    void setUp11() {
	        MockitoAnnotations.openMocks(this);
	        customerService = new CustomerService(customerRepository);
	    }

	    @Test
	    void testSaveCustomer() {
	        Customer customer = new Customer();
	        customer.setId(1L);
	        customer.setRegistered(LocalDateTime.now());
	        customer.setEmailAddress("test@example.com");
	        customer.setTitle("Mr");
	        customer.setFirstName("John");
	        customer.setLastName("Doe");
	        customer.setAddressLine1("123 Main St");
	        customer.setAddressLine2("Apt 4B");
	        customer.setCity("New York");
	        customer.setPostcode("12345");
	        customer.setPhoneNumber("+11234567890");

	        when(customerRepository.save(any())).thenReturn(customer);

	        Customer savedCustomer = customerService.saveCustomer(customer);

	        assertNotNull(savedCustomer);
	        assertTrue(savedCustomer.getId() > 0);
	        assertEquals(customer.getRegistered(), savedCustomer.getRegistered());
	        assertEquals(customer.getEmailAddress(), savedCustomer.getEmailAddress());
	        assertEquals(customer.getTitle(), savedCustomer.getTitle());
	        assertEquals(customer.getFirstName(), savedCustomer.getFirstName());
	        assertEquals(customer.getLastName(), savedCustomer.getLastName());
	        assertEquals(customer.getAddressLine1(), savedCustomer.getAddressLine1());
	        assertEquals(customer.getAddressLine2(), savedCustomer.getAddressLine2());
	        assertEquals(customer.getCity(), savedCustomer.getCity());
	        assertEquals(customer.getPostcode(), savedCustomer.getPostcode());
	        assertEquals(customer.getPhoneNumber(), savedCustomer.getPhoneNumber());

	        verify(customerRepository, times(1)).save(any());
	    }

	    @Test
	    void testEmailExists() {
	        String emailAddress = "test@example.com";
	        when(customerRepository.findByEmailAddress(emailAddress)).thenReturn(new Customer());

	        assertTrue(customerService.emailExists(emailAddress));
	        verify(customerRepository, times(1)).findByEmailAddress(emailAddress);
	    }

	    @Test
	    void testEmailNotExists() {
	        String emailAddress = "test@example.com";
	        when(customerRepository.findByEmailAddress(emailAddress)).thenReturn(null);

	        assertFalse(customerService.emailExists(emailAddress));
	        verify(customerRepository, times(1)).findByEmailAddress(emailAddress);
	    }

	    
}
