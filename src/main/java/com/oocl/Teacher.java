package com.oocl;

import com.oocl.exception.TeacherClassListFullException;
import com.oocl.observer.AssignLeaderObserver;
import com.oocl.observer.AssignLeaderSubject;
import com.oocl.observer.RegisterStudentToClassObserver;
import com.oocl.observer.RegisterStudentToClassSubject;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person implements RegisterStudentToClassObserver, AssignLeaderObserver {
    private List<SchoolClass> schoolClassList = new ArrayList<>();

    public boolean isTeaching(SchoolClass schoolClass) {
        return schoolClassList.contains(schoolClass);
    }

    @Override
    public String introduce() {
        return String.format("My name is %s. I am %d years old. Teaching for the future of world.", this.getName(), this.getAge());
    }

    public Boolean isClassListFull() {
        return this.schoolClassList.size() >= 5;
    }

    public void registerClass(SchoolClass schoolClass) throws TeacherClassListFullException {
        if (isClassListFull()) {
            throw new TeacherClassListFullException();
        }
        schoolClassList.add(schoolClass);
    }

    private void printWelcomeMessage(Integer classNumber, String studentName) {
        String message = String.format("%s Welcome %s join Class %d.", introduce(), studentName, classNumber);
        System.out.print(message);
    }

    private void printLeaderMessage(Integer classNumber, String studentName) {
        String message = String.format("%s %s is the leader of Class %d.", introduce(), studentName, classNumber);
        System.out.print(message);
    }

    public void update(RegisterStudentToClassSubject subject) {
        printWelcomeMessage(subject.getClassNumber(), subject.getNewStudentName());
    }

    public void update(AssignLeaderSubject subject) {
        printLeaderMessage(subject.getClassNumber(), subject.getLeaderName());
    }
}
