package com.qa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.qa.controller.PersonController;
import com.qa.model.Person;
import com.qa.repository.PersonRepository;

public class PersonControllerTest {
	@InjectMocks
	private PersonController pc;

	@Mock
	private PersonRepository personRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testpersonGet() {
    	Person john = new Person();
    	john.setId(1l);
		when(personRepository.findOne(1l)).thenReturn(john);

		Person person = pc.get(1L);

		verify(personRepository).findOne(1l);		
		
		assertThat(person.getId(), is(1l));
	}

}
