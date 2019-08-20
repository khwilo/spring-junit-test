package com.hanselnpetal.tdd.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.hanselnpetal.tdd.data.repos.CustomerContactRepository;
import com.hanselnpetal.tdd.domain.CustomerContact;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementServiceUnitTest {

    @Mock
    private CustomerContactRepository customerContactRepository;

    @InjectMocks
    private ContactsManagementService contactsManagementService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContactHappyPath() {
        // Create a contact
        CustomerContact aMockContact = new CustomerContact();
        aMockContact.setFirstName("Jenny");
        aMockContact.setLastName("Johnson");

        when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aMockContact);

        // Save the contact
        CustomerContact newContact = contactsManagementService.add(aMockContact);

        // Verify the save
        assertEquals("Johnson", newContact.getLastName());
    }
}
