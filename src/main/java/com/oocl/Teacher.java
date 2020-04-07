package com.oocl;

import com.oocl.exception.TeacherClassListFullException;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private List<SchoolClass> schoolClassList = new ArrayList<>();

    public List<SchoolClass> getSchoolClassList() {
        return schoolClassList;
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
}
