package com.example.demo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query("select id, first_name from customer where upper(first_name) like '%' || upper(:name) || '%' ")
	List<Customer> findByName(String name);
	
	@Query("select  * from customer where first_name = :lname")
	List<Customer> findByLnameSortedId(String lname);
}
