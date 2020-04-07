package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class TeacherTest {

    @Test
    public void testIntroduce_shouldReturnNameAndAge() {
        Person person = new Teacher();
        person.setName("Tom");
        person.setAge(18);

        Assert.assertEquals("My name is Tom. I am 18 years old. Teaching for the future of world.", person.introduce());
    }
}