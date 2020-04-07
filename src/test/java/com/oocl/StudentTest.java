package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testIntroduce_shouldReturnNameAndAge() {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Student student = new Student();
        student.setName("Tom");
        student.setAge(18);
        schoolClass.registerStudent(student);

        Assert.assertEquals("My name is Tom. I am 18 years old. I am a student of class 2. Coding for the glory of OOCL.", student.introduce());
    }
}