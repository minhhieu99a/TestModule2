package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Phonebook implements Serializable{
    private int phonenumbers;
    private String groups;
    private String fullnames;
    private String gender;
    private String address;
    private LocalDate dateofbirth;
    private String email;

    public Phonebook() {
    }

    public Phonebook(int phonenumbers, String groups, String fullnames, String gender, String address, LocalDate dateofbirth, String email) {
        this.phonenumbers = phonenumbers;
        this.groups = groups;
        this.fullnames = fullnames;
        this.gender = gender;
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.email = email;
    }

    public int getPhonenumbers() {
        return phonenumbers;
    }

    public void setPhonenumbers(int phonenumbers) {
        this.phonenumbers = phonenumbers;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getFullnames() {
        return fullnames;
    }

    public void setFullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "phonenumbers=" + phonenumbers +
                ", groups='" + groups + '\'' +
                ", fullnames='" + fullnames + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
