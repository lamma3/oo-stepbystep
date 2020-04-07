package com.oocl;

import com.oocl.exception.StudentNotFoundException;
import com.oocl.exception.TeacherClassListFullException;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private Integer classNumber;
    private List<Student> studentList = new ArrayList<>();
    private Student classLeader;
    private Teacher teacher;

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Student getClassLeader() {
        return classLeader;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void registerStudent(Student student) {
        studentList.add(student);
        student.setSchoolClass(this);
    }

    public void assignClassLeader(Student classLeader) throws StudentNotFoundException {
        if (!studentList.contains(classLeader)) {
            throw new StudentNotFoundException();
        }
        this.classLeader = classLeader;
    }

    public void assignTeacher(Teacher teacher) throws TeacherClassListFullException {
        teacher.registerClass(this);
        this.teacher = teacher;
    }
}
