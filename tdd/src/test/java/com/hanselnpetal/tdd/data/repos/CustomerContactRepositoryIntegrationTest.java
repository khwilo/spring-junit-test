package com.hanselnpetal.tdd.data.repos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.hanselnpetal.tdd.domain.CustomerContact;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerContactRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Test
    public void testFindByEmail() {
        // setup data scenario
        CustomerContact aContact = new CustomerContact();
        aContact.setEmail("eddy@gmail.com");
        entityManager.persist(aContact);

        // Find an inserted record using repository class
        CustomerContact foundContact = customerContactRepository.findByEmail("eddy@gmail.com");

        // Assertion
        assertThat(foundContact.getEmail(), is(equalTo("eddy@gmail.com")));
    }
}
