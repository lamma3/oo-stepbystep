package com.oocl;

public class Student extends Person {
    private SchoolClass schoolClass;

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    @Override
    public String introduce() {
        return String.format("My name is %s. I am %d years old. I am a student of class %d. Coding for the glory of OOCL.", this.getName(), this.getAge(), this.getSchoolClass().getClassNumber());
    }

    public void joinSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
