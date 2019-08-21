package com.hanselnpetal.tdd.controller;

import com.hanselnpetal.tdd.domain.CustomerContact;
import com.hanselnpetal.tdd.service.ContactsManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addContact")
public class ContactsManagementController {

    private ContactsManagementService contactsManagementService;

    @Autowired
    public ContactsManagementController(ContactsManagementService contactsManagementService) {
        this.contactsManagementService = contactsManagementService;
    }

    // COMMENT OUT THIS CODE FOR THE CONTACTS MANAGEMENT CONTROLLER INTEGRATION TEST
    // TO PASS
    // @PostMapping
    // public String processAddContactSubmit(@RequestBody CustomerContact
    // customerContact) {
    // CustomerContact newContact = contactsManagementService.add(customerContact);

    // if (newContact != null) {
    // return "success";
    // }
    // return "failure";
    // }

    // THIS WORKS FOR THE CONTACTS MANAGEMENT CONTROLLER UNIT TEST
    @PostMapping
    public String processAddContactSubmit(@ModelAttribute CustomerContact customerContact) {
        CustomerContact newContact = contactsManagementService.add(customerContact);

        if (newContact != null) {
            return "/addContactForm";
        }
        return "redirect:/showAddContact";
    }
}
