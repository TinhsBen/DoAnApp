package com.example.a4foods.model;

import java.io.Serializable;

public class User implements Serializable {
    int IdUser;
    String NameUser;
    String Email;
    String Password;
    String Phone;
    String Address;
    int role;

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String nameUser) {
        NameUser = nameUser;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User(int idUser, String nameUser, String email, String password, String phone, String address, int role) {
        IdUser = idUser;
        NameUser = nameUser;
        Email = email;
        Password = password;
        Phone = phone;
        Address = address;
        this.role = role;
    }

    public User(String nameUser, String email, String password, String phone, String address, int role) {
        NameUser = nameUser;
        Email = email;
        Password = password;
        Phone = phone;
        Address = address;
        this.role = role;
    }
}
