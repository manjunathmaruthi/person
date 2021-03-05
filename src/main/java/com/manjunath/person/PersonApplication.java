package com.manjunath.person;

import com.manjunath.person.dao.PersonDAO;
import com.manjunath.person.model.Address;
import com.manjunath.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PersonApplication implements CommandLineRunner {

	@Autowired
	private PersonDAO personDAO;

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person = new Person();
		person.setFirstName("Raj");
		person.setLastName("Kapoor");

		Address address = new Address();
		address.setCity("Bangalore");
		address.setPostalCode("585501");
		address.setState("Karnataka");
		address.setStreet("Sedam Road");
		address.setPerson(person);

		person.getAddresses().add(address);
		personDAO.save(person);

	}

}
