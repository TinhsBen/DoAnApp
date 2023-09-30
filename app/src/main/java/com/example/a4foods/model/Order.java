package com.example.a4foods.model;

import java.io.Serializable;

public class Order implements Serializable {
    int IdOrder;
    int IdUserOrder;
    int IdProOrder;
    int Quantity;
    String Date;
    String Ankem;
    String Nuoc;
    String Name;
    String Phone;
    String Address;
    int Status;

    public Order(int idUserOrder, int idProOrder, int quantity, String date, String ankem, String nuoc, String name, String phone, String address, int status) {
        IdUserOrder = idUserOrder;
        IdProOrder = idProOrder;
        Quantity = quantity;
        Date = date;
        Ankem = ankem;
        Nuoc = nuoc;
        Name = name;
        Phone = phone;
        Address = address;
        Status = status;
    }

    public Order(int idOrder, int idUserOrder, int idProOrder, int quantity, String date, String ankem, String nuoc, String name, String phone, String address, int status) {
        IdOrder = idOrder;
        IdUserOrder = idUserOrder;
        IdProOrder = idProOrder;
        Quantity = quantity;
        Date = date;
        Ankem = ankem;
        Nuoc = nuoc;
        Name = name;
        Phone = phone;
        Address = address;
        Status = status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(int idOrder) {
        IdOrder = idOrder;
    }

    public int getIdUserOrder() {
        return IdUserOrder;
    }

    public void setIdUserOrder(int idUserOrder) {
        IdUserOrder = idUserOrder;
    }

    public int getIdProOrder() {
        return IdProOrder;
    }

    public void setIdProOrder(int idProOrder) {
        IdProOrder = idProOrder;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAnkem() {
        return Ankem;
    }

    public void setAnkem(String ankem) {
        Ankem = ankem;
    }

    public String getNuoc() {
        return Nuoc;
    }

    public void setNuoc(String nuoc) {
        Nuoc = nuoc;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
