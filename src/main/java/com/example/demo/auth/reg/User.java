package com.example.demo.auth.reg;
public class User {

    private String firstName;
    private String surname;
    private String username;
    private String password;
    private String cpassword;

    public User() {
    }

    public User(String firstName, String surname, String username, String password, String cpassword) {
        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.cpassword = cpassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
}
