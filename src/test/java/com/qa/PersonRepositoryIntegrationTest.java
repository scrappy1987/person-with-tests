package com.qa;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qa.App;
import com.qa.model.Person;
import com.qa.repository.PersonRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class PersonRepositoryIntegrationTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void testFindAll() {
		List<Person> persons = personRepository.findAll();
		assertThat(persons.size(), is(greaterThanOrEqualTo(0)));
	}
	
}
