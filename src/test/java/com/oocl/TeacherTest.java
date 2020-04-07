package com.oocl;

import com.oocl.exception.TeacherClassListFullException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TeacherTest {

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
        Person person = new Teacher();
        person.setName("Tom");
        person.setAge(18);

        Assert.assertEquals("My name is Tom. I am 18 years old. Teaching for the future of world.", person.introduce());
    }

    @Test
    public void testAssignTeacher_whenLessThan5Class_thenSuccess() throws Exception {
        SchoolClass schoolClass = new SchoolClass();
        Teacher teacher = new Teacher();
        schoolClass.assignTeacher(teacher);

        Assert.assertEquals(teacher, schoolClass.getTeacher());
        Assert.assertTrue(teacher.isTeaching(schoolClass));
    }

    @Test(expected = TeacherClassListFullException.class)
    public void testAssignTeacher_whenLessThan5Class_thenFail() throws Exception {
        SchoolClass schoolClass1 = new SchoolClass();
        SchoolClass schoolClass2 = new SchoolClass();
        SchoolClass schoolClass3 = new SchoolClass();
        SchoolClass schoolClass4 = new SchoolClass();
        SchoolClass schoolClass5 = new SchoolClass();
        SchoolClass schoolClass6 = new SchoolClass();
        Teacher teacher = new Teacher();
        schoolClass1.assignTeacher(teacher);
        schoolClass2.assignTeacher(teacher);
        schoolClass3.assignTeacher(teacher);
        schoolClass4.assignTeacher(teacher);
        schoolClass5.assignTeacher(teacher);
        schoolClass6.assignTeacher(teacher);
    }

    @Test
    public void testPrintWelcomeMessage_whenHaveTeacher_shouldPrint() throws Exception {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Teacher teacher = new Teacher();
        teacher.setName("Woody");
        teacher.setAge(30);
        schoolClass.assignTeacher(teacher);
        Student student = new Student();
        student.setName("Tom");
        schoolClass.registerStudent(student);

        Assert.assertEquals("My name is Woody. I am 30 years old. Teaching for the future of world. Welcome Tom join Class 2." ,outContent.toString());
    }

    @Test
    public void testPrintWelcomeMessage_whenNoTeacher_shouldNotPrint() {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Student student = new Student();
        student.setName("Tom");
        schoolClass.registerStudent(student);

        Assert.assertEquals("" ,outContent.toString());
    }

    @Test
    public void testPrintLeaderMessage_whenHaveTeacher_shouldPrint() throws Exception {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Student student = new Student();
        student.setName("Tom");
        schoolClass.registerStudent(student);
        Teacher teacher = new Teacher();
        teacher.setName("Woody");
        teacher.setAge(30);
        schoolClass.assignTeacher(teacher);
        schoolClass.assignClassLeader(student);

        Assert.assertEquals("My name is Woody. I am 30 years old. Teaching for the future of world. Tom is the leader of Class 2." ,outContent.toString());
    }

    @Test
    public void testPrintLeaderMessage_whenNoTeacher_shouldPrint() throws Exception {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Student student = new Student();
        student.setName("Tom");
        schoolClass.registerStudent(student);
        schoolClass.assignClassLeader(student);

        Assert.assertEquals("" ,outContent.toString());
    }
}