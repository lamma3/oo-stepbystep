package com.oocl;

import com.oocl.exception.TeacherClassListFullException;
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
}