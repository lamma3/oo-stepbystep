package com.oocl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StudentTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

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

    @Test
    public void testPrintWelcomeMessage_shouldPrint() {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Student student1 = new Student();
        student1.setName("Tom");
        student1.setAge(18);
        schoolClass.registerStudent(student1);
        Student student2 = new Student();
        student2.setName("Jim");
        schoolClass.registerStudent(student2);

        Assert.assertEquals("My name is Tom. I am 18 years old. I am a student of class 2. Coding for the glory of OOCL. Welcome Jim join Class 2." ,outContent.toString());
    }
}