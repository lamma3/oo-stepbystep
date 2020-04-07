package com.oocl;

public class Student extends Person {
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

    public void printWelcomeMessage(Student newStudent) {
        String message = String.format("%s Welcome %s join Class %d.", introduce(), newStudent.getName(), this.getSchoolClass().getClassNumber());
        System.out.print(message);
    }
}
