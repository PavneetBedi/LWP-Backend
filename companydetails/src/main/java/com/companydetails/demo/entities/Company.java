package com.companydetails.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="CompanyDetails")
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cmp_id")
    private int id;
    private String companyname;

    private String ownername;

    private String foundedyear;

    private Long contactno;

    private String companycode;

    private int noofemployees;

    private String emailid;
    private String location;
    private String onboarddate;
    @Column(name="isDeleted")
    private boolean isDeleted;
    public Company() {
    }

    public Company(int id, String companyname, String ownername, String foundedyear, Long contactno, String companycode, int noofemployees, String emailid, String location, String onboarddate, boolean isDeleted) {
        this.id = id;
        this.companyname = companyname;
        this.ownername = ownername;
        this.foundedyear = foundedyear;
        this.contactno = contactno;
        this.companycode = companycode;
        this.noofemployees = noofemployees;
        this.emailid = emailid;
        this.location = location;
        this.onboarddate = onboarddate;
        this.isDeleted = isDeleted;
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

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getFoundedyear() {
        return foundedyear;
    }

    public void setFoundedyear(String founderyear) {
        this.foundedyear = founderyear;
    }

    public Long getContactno() {
        return contactno;
    }

    public void setContactno(Long contactno) {
        this.contactno = contactno;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public int getNoofemployees() {
        return noofemployees;
    }

    public void setNoofemployees(int noofemployees) {
        this.noofemployees = noofemployees;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                ", ownername='" + ownername + '\'' +
                ", foundedyear='" + foundedyear + '\'' +
                ", contactno=" + contactno +
                ", companycode='" + companycode + '\'' +
                ", noofemployees=" + noofemployees +
                ", emailid='" + emailid + '\'' +
                ", location='" + location + '\'' +
                ", onboarddate='" + onboarddate + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}


