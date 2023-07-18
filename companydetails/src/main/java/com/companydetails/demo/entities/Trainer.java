package com.companydetails.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="TrainerDetails")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainer_id")
    private int id;
    private String trainername;

    private String gender;

    private String dateofbirth;

    private String email;

    private String contactno;

    private String address;
    private String techstack;
    private String experience;
    private String onboarddate;
    @Column(name="isDeleted")
    private boolean isDeleted;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="TRAINER_TRAINING_TABLE",
            joinColumns = {@JoinColumn(name = "trainer_id",referencedColumnName = "trainer_id")
    },
    inverseJoinColumns = {
            @JoinColumn(name="training_id",referencedColumnName = "training_id")
    })
    private List<Training> trainings;
    public Trainer() {
    }

    public Trainer(int id, String trainername, String gender, String dateofbirth, String email, String contactno, String address, String techstack, String experience, String onboarddate, boolean isDeleted, List<Training> trainings) {
        this.id = id;
        this.trainername = trainername;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.contactno = contactno;
        this.address = address;
        this.techstack = techstack;
        this.experience = experience;
        this.onboarddate = onboarddate;
        this.isDeleted = isDeleted;
        this.trainings = trainings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainername() {
        return trainername;
    }

    public void setTrainername(String trainername) {
        this.trainername = trainername;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTechstack() {
        return techstack;
    }

    public void setTechstack(String techstack) {
        this.techstack = techstack;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getOnboarddate() {
        return onboarddate;
    }

    public void setOnboarddate(String onboarddate) {
        this.onboarddate = onboarddate;
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
        return "Trainer{" +
                "id=" + id +
                ", trainername='" + trainername + '\'' +
                ", gender='" + gender + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", email='" + email + '\'' +
                ", contactno='" + contactno + '\'' +
                ", address='" + address + '\'' +
                ", techstack='" + techstack + '\'' +
                ", experience='" + experience + '\'' +
                ", onboarddate='" + onboarddate + '\'' +
                ", isDeleted=" + isDeleted +
                ", trainings=" + trainings +
                '}';
    }
}
