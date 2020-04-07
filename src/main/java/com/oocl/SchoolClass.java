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

    public void registerStudent(Student newStudent) {
        studentList.add(newStudent);
        newStudent.setSchoolClass(this);
        if (teacher != null) {
            teacher.printWelcomeMessage(this, newStudent);
        }
        for (Student existingStudent: this.studentList) {
            if (existingStudent != newStudent) {
                existingStudent.printWelcomeMessage(newStudent);
            }
        }
    }

    public void assignClassLeader(Student classLeader) throws StudentNotFoundException {
        if (!studentList.contains(classLeader)) {
            throw new StudentNotFoundException();
        }
        this.classLeader = classLeader;
        if (teacher != null) {
            teacher.printLeaderMessage(this, classLeader);
        }
    }

    public void assignTeacher(Teacher teacher) throws TeacherClassListFullException {
        teacher.registerClass(this);
        this.teacher = teacher;
    }
}
