package com.oocl;

import com.oocl.exception.StudentNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class SchoolClassTest {
    @Test
    public void testAssignClassLeader_whenStudentInClass_thenSuccess() throws Exception {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Student student = new Student();
        student.setName("Tom");
        student.setAge(18);
        schoolClass.registerStudent(student);
        schoolClass.assignClassLeader(student);

        Assert.assertEquals(student, schoolClass.getClassLeader());
    }

    @Test(expected = StudentNotFoundException.class)
    public void testAssignClassLeader_whenStudentNotInClass_thenFail() throws Exception {
        SchoolClass schoolClass = new SchoolClass();
        schoolClass.setClassNumber(2);
        Student student = new Student();
        student.setName("Tom");
        student.setAge(18);
        schoolClass.assignClassLeader(student);
    }
}