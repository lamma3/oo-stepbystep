package com.oocl;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private Integer classNumber;
    private List<Student> studentList = new ArrayList<>();
    private Student classLeader;

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Student getClassLeader() {
        return classLeader;
    }

    public void registerStudent(Student student) {
        studentList.add(student);
        student.setSchoolClass(this);
    }

    public void assignClassLeader(Student classLeader) {
        if (studentList.contains(classLeader)) {
            this.classLeader = classLeader;
        }
    }
}
