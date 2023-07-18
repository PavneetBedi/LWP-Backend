package com.companydetails.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="TrainingDetails", indexes = {
        @Index(name = "idx_training_id", columnList = "training_id")
})
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "training_id")
    private int id;
    private String companyname;
    private int trainer_id;
    private String startdate;

    private String enddate;
    private String techstack;
    private String duration;

    private String email;

    private Long contactno;
    private int StudentId;
    private String trainername;

    @Column(name="isDeleted")
    private boolean isDeleted;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToMany(mappedBy = "trainings",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Trainer> trainers;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Training_Student",
            joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;


    public Training() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getTechstack() {
        return techstack;
    }

    public void setTechstack(String techstack) {
        this.techstack = techstack;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContactno() {
        return contactno;
    }

    public void setContactno(Long contactno) {
        this.contactno = contactno;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Training(int id, String companyname, int trainer_id, String startdate, String enddate, String techstack, String duration, String email, Long contactno, int studentId, String trainername, boolean isDeleted, List<Trainer> trainers, List<Student> students) {
        this.id = id;
        this.companyname = companyname;
        this.trainer_id = trainer_id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.techstack = techstack;
        this.duration = duration;
        this.email = email;
        this.contactno = contactno;
        StudentId = studentId;
        this.trainername = trainername;
        this.isDeleted = isDeleted;
        this.trainers = trainers;
        this.students = students;
    }

    public String getTrainername() {
        return trainername;
    }

    public void setTrainername(String trainername) {
        this.trainername = trainername;
    }
}
