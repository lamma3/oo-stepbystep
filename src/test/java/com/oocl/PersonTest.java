package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testIntroduce_shouldReturnNameAndAge() {
        Person person = new Person();
        person.setName("Tom");
        person.setAge(21);

        Assert.assertEquals("My name is Tom. I am 21 years old.", person.introduce());
    }
}