package com.oocl;

import com.oocl.exception.StudentNotFoundException;
import com.oocl.exception.TeacherClassListFullException;
import com.oocl.observer.AssignLeaderSubject;
import com.oocl.observer.RegisterStudentToClassSubject;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private Integer classNumber;
    private List<Student> studentList = new ArrayList<>();
    private Student classLeader;
    private Teacher teacher;
    private RegisterStudentToClassSubject registerStudentToClassSubject = new RegisterStudentToClassSubject();
    private AssignLeaderSubject assignLeaderSubject = new AssignLeaderSubject();

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
        newStudent.setClassNumber(this.classNumber);
        registerStudentToClassSubject.setState(this, newStudent);
        registerStudentToClassSubject.attachObserver(newStudent);
        assignLeaderSubject.attachObserver(newStudent);
    }

    public void assignClassLeader(Student classLeader) throws StudentNotFoundException {
        if (!studentList.contains(classLeader)) {
            throw new StudentNotFoundException();
        }
        this.classLeader = classLeader;
        assignLeaderSubject.setState(this, classLeader);
    }

    public void assignTeacher(Teacher teacher) throws TeacherClassListFullException {
        teacher.registerClass(this);
        this.teacher = teacher;
        registerStudentToClassSubject.attachObserver(teacher);
        assignLeaderSubject.attachObserver(teacher);
    }
}
