package com.hanselnpetal.tdd.data.repos;

import com.hanselnpetal.tdd.domain.CustomerContact;

import org.springframework.data.repository.CrudRepository;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

    public CustomerContact findByEmail(String email);
}
