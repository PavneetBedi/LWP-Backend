package com.companydetails.demo.DTO;

public class UserDTO {
    private int userid;
    private String mobilenumber;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(int userid, String mobilenumber, String email, String password) {
        this.userid = userid;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userdto{" +
                "userid=" + userid +
                ", mobilenumber='" + mobilenumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

