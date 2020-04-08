package com.oocl;

import com.oocl.observer.AssignLeaderObserver;
import com.oocl.observer.AssignLeaderSubject;
import com.oocl.observer.RegisterStudentToClassObserver;
import com.oocl.observer.RegisterStudentToClassSubject;

public class Student extends Person implements RegisterStudentToClassObserver, AssignLeaderObserver {
    private SchoolClass schoolClass;

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a student of class %d. Coding for the glory of OOCL.", this.getName(), this.getAge(), this.getSchoolClass().getClassNumber());
    }

    private void printWelcomeMessage(String studentName) {
        String message = String.format("%s Welcome %s join Class %d.", introduce(), studentName, this.getSchoolClass().getClassNumber());
        System.out.print(message);
    }

    private void printLeaderMessage(String studentName) {
        String message = String.format("%s %s is the leader of Class %d.", introduce(), studentName, this.getSchoolClass().getClassNumber());
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
