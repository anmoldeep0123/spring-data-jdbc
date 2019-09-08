package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
@ContextConfiguration(classes = CustomerConfiguration.class)
public class SpringDataJdbcApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void testCreateCustomer() {
		Customer c = new Customer("Anmol");
		customerRepository.save(c);
		assertThat(c.getId()).isNotNull();
		c.setFirstName("Anmol-modified");
		customerRepository.save(c);
		Optional<Customer> opCustomer = customerRepository.findById(c.getId());
		assertThat(opCustomer).isNotEmpty();
		assertThat(opCustomer.get().getFirstName()).isEqualTo("Anmol-modified");
	}
	
	@Test
	public void testQuery() {
		Customer c = new Customer("Albert");
		customerRepository.save(c);
		c.setId(null);
		c = new Customer("Bertram");
		customerRepository.save(c);
		c.setId(null);
		c = new Customer("Beth");
		customerRepository.save(c);
		assertThat(customerRepository.findByName("bert")).hasSize(2);
		assertThat(customerRepository.findByLnameSortedId("Beth")).hasSize(1);
	}

}
