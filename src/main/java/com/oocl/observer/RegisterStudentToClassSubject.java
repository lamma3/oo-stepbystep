package com.oocl.observer;

import com.oocl.SchoolClass;
import com.oocl.Student;

import java.util.ArrayList;
import java.util.List;

public class RegisterStudentToClassSubject {

    private List<RegisterStudentToClassObserver> observerList = new ArrayList<>();
    private Integer classNumber;
    private String newStudentName;

    public Integer getClassNumber() {
        return classNumber;
    }

    public String getNewStudentName() {
        return newStudentName;
    }

    public void attachObserver(RegisterStudentToClassObserver observer) {
        observerList.add(observer);
    }

    public void notifyObserver() {
        for (RegisterStudentToClassObserver observer: observerList) {
            observer.update(this);
        }
    }

    public void setState(SchoolClass schoolClass, Student student) {
        this.classNumber = schoolClass.getClassNumber();
        this.newStudentName = student.getName();
        notifyObserver();
    }
}
