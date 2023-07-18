package com.companydetails.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="StudentDetails")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="student_id")
    private int id;

    private String studentname;
    private String emailid;

    @Column(name="isDeleted")
    private boolean isDeleted;

    @ManyToMany(mappedBy = "students")
    private List<Training> trainings;
    public Student() {
    }

    public Student(int id, String studentname, String emailid, boolean isDeleted, List<Training> trainings) {
        this.id = id;
        this.studentname = studentname;
        this.emailid = emailid;
        this.isDeleted = isDeleted;
        this.trainings = trainings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentname='" + studentname + '\'' +
                ", emailid='" + emailid + '\'' +
                ", isDeleted=" + isDeleted +
                ", trainings=" + trainings +
                '}';
    }
}

