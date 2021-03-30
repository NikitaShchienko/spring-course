package com.luxoft.springioc.lab1.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

    private UsualPerson expectedPerson;

    private AbstractApplicationContext context;

    @Before
    public void setUp() {
        context = new FileSystemXmlApplicationContext(new String[]{APPLICATION_CONTEXT_XML_FILE_NAME});
        expectedPerson = getExpectedPerson();
    }

    @Test
    public void testInitPerson() {
        UsualPerson person = (UsualPerson) context.getBean("person", Person.class);

        System.out.println("Bean A --> " + person.getCountry().getA());
        assertEquals(expectedPerson, person);
        System.out.println("Bean Person --> " + person);
    }

    private UsualPerson getExpectedPerson() {
        A a = new A(1);
        Country country = new Country(1, "Russia", "RU", a);
        System.out.println("Bean A --> " + country.getA());
        return new UsualPerson(1, "John Smith", country, 35);
    }

    @After
    public void tearDown() {
        if (context != null)
            context.close();
    }
}
