package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testIntroduce_shouldReturnNameAndAge() {
        Person person = new Student();
        person.setName("Tom");
        person.setAge(18);

        Assert.assertEquals("My name is Tom. I am 18 years old. Coding for the glory of OOCL.", person.introduce());
    }
}