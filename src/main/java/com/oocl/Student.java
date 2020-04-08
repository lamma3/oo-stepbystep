package com.oocl;

import com.oocl.observer.AssignLeaderObserver;
import com.oocl.observer.AssignLeaderSubject;
import com.oocl.observer.RegisterStudentToClassObserver;
import com.oocl.observer.RegisterStudentToClassSubject;

public class Student extends Person implements RegisterStudentToClassObserver, AssignLeaderObserver {

    private Integer classNumber;

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a student of class %d. Coding for the glory of OOCL.", this.getName(), this.getAge(), this.getClassNumber());
    }

    private void printWelcomeMessage(String studentName) {
        String message = String.format("%s Welcome %s join Class %d.", introduce(), studentName, this.getClassNumber());
        System.out.print(message);
    }

    private void printLeaderMessage(String studentName) {
        String message = String.format("%s %s is the leader of Class %d.", introduce(), studentName, this.getClassNumber());
        System.out.print(message);
    }

    public void update(RegisterStudentToClassSubject subject) {
        if (!subject.getNewStudentName().equals(this.getName())) {
            printWelcomeMessage(subject.getNewStudentName());
        }
    }

    public void update(AssignLeaderSubject subject) {
        if (!subject.getLeaderName().equals(this.getName())) {
            printLeaderMessage(subject.getLeaderName());
        }
    }
}
