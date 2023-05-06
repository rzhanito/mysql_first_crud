package com.example.lab11_stud.model;

public class Student {
    private int id;
    private int course;
    private String fullName;
    private String groupName;
    private String specialty;
    public Student(){

    }

    public Student(int id, int course, String fullName, String groupName, String specialty) {
        this.id = id;
        this.course = course;
        this.fullName = fullName;
        this.groupName = groupName;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
