package com.oocl.observer;

import com.oocl.SchoolClass;
import com.oocl.Student;

import java.util.ArrayList;
import java.util.List;

public class AssignLeaderSubject {

    private List<AssignLeaderObserver> observerList = new ArrayList<>();
    private Integer classNumber;
    private String leaderName;

    public Integer getClassNumber() {
        return classNumber;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void attachObserver(AssignLeaderObserver observer) {
        observerList.add(observer);
    }

    public void notifyObserver() {
        for (AssignLeaderObserver observer: observerList) {
            observer.update(this);
        }
    }

    public void setState(SchoolClass schoolClass, Student student) {
        this.classNumber = schoolClass.getClassNumber();
        this.leaderName = student.getName();
        notifyObserver();
    }
}
