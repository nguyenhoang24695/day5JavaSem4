package com.fpt.edu.entity;

public class Student {
    private String rollNumber;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String salt;
    private int status;

    public Student() {
    }

    public Student(String rollNumber, String fullName, String email, String phone, String password, String salt, int status) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.status = status;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status ==null){
            status = Status.DEACTIVE;
        }
        this.status = status.getValue();
    }

    public enum Status{
        ACTIVE(1),DEACTIVE(2),DELETED(3);
        int value;
        Status(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
        public static Status findByValue(int value){
            for (Status status: Status.values()){
                if (status.getValue() == value){
                    return status;
                }
            }
            return null;
        }
    }
}
