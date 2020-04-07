package com.oocl;

import org.junit.Assert;
import org.junit.Test;

public class SchoolClassTest {
    @Test
    public void testAssignClassLeader_whenStudentInClass_thenSuccess() {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Student student = new Student();
        student.setName("Tom");
        student.setAge(18);
        schoolClass.registerStudent(student);
        schoolClass.assignClassLeader(student);

        Assert.assertEquals(student, schoolClass.getClassLeader());
    }

    @Test
    public void testAssignClassLeader_whenStudentNotInClass_thenFail() {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Student student = new Student();
        student.setName("Tom");
        student.setAge(18);
        schoolClass.assignClassLeader(student);

        Assert.assertNull(schoolClass.getClassLeader());
    }
}