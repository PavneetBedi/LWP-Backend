package com.companydetails.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="MappingDetails")
public class Mapping {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="table_id")
    private int id;
   // @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    private int trainingid;
    private int traineesid;

    @Column(name="isDeleted")
    private boolean isDeleted;
    public Mapping() {
    }

    public Mapping(int id, Trainer trainer, int trainingid, int traineesid, boolean isDeleted) {
        this.id = id;
        this.trainer = trainer;
        this.trainingid = trainingid;
        this.traineesid = traineesid;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public int getTrainingid() {
        return trainingid;
    }

    public void setTrainingid(int trainingid) {
        this.trainingid = trainingid;
    }

    public int getTraineesid() {
        return traineesid;
    }

    public void setTraineesid(int traineesid) {
        this.traineesid = traineesid;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Mapping{" +
                "id=" + id +
                ", trainer=" + trainer +
                ", trainingid=" + trainingid +
                ", traineesid=" + traineesid +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
