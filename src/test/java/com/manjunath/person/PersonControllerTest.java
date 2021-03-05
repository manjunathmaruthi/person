package com.manjunath.person;

import com.manjunath.person.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getPersonsList() throws Exception {
        String uri = "/persons/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Person[] personlist = super.mapFromJson(content, Person[].class);
        assertTrue(personlist.length > 0);
    }

    @Test
    public void addPerson() throws Exception {
        String uri = "/persons/";
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Paul");
        String inputJson = super.mapToJson(person);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Person is added successfully");
    }
}
