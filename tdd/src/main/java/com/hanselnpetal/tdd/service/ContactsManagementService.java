package com.hanselnpetal.tdd.service;

import com.hanselnpetal.tdd.data.repos.CustomerContactRepository;
import com.hanselnpetal.tdd.domain.CustomerContact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsManagementService {

    private CustomerContactRepository customerContactRepository;

    @Autowired
    public ContactsManagementService(CustomerContactRepository customerContactRepository) {
        this.customerContactRepository = customerContactRepository;
    }

    public CustomerContact add(CustomerContact customerContact) {
        CustomerContact newContact = null;

        if (customerContact.getFirstName() != null) {
            newContact = customerContactRepository.save(customerContact);
        }

        return newContact;
    }
}
