package com.hanselnpetal.tdd.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.hanselnpetal.tdd.domain.CustomerContact;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

    @Autowired
    ContactsManagementController contactsManagementController;

    @Test
    public void testAddContactHappyPath() {
        CustomerContact aContact = new CustomerContact();
        aContact.setFirstName("Jenny");
        aContact.setLastName("Johnson");

        // POST our CustomerContact form bean to the controller; check the outcome
        String outcome = contactsManagementController.processAddContactSubmit(aContact);

        // Assert that the outcome is as expected
        assertThat(outcome, is(equalTo("success")));
    }

    @Test
    public void testAddContactFirstNameMissing() {
        CustomerContact aContact = new CustomerContact();

        // POST our CustomerContact form bean to the controller; check the outcome
        String outcome = contactsManagementController.processAddContactSubmit(aContact);

        // Assert that the outcome is as expected
        assertThat(outcome, is(equalTo("failure")));
    }
}
