package com.hanselnpetal.tdd.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.hanselnpetal.tdd.domain.CustomerContact;
import com.hanselnpetal.tdd.service.ContactsManagementService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactsManagementService contactsManagementService;

    @InjectMocks
    private ContactsManagementController contactsManagementController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContactHappyPath() throws Exception {
        // Setup mock Contact returned the mock service component
        CustomerContact mockCustomerContact = new CustomerContact();
        mockCustomerContact.setFirstName("Eddy");

        when(contactsManagementService.add(any(CustomerContact.class))).thenReturn(mockCustomerContact);

        // simulate the form bean that would POST from the web page
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Eddy");
        aContact.setEmail("eddy@gmail.com");

        // simulate the form submit (POST)
        mockMvc.perform(post("/addContact", aContact)).andExpect(status().isOk()).andReturn();
    }
}
