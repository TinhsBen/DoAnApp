package com.example.a4foods.model;

import java.io.Serializable;

public class Cart implements Serializable {
    int IdOrderCard;
    int IdUserCart;
    int IdProCart;
    int Quantity;
    String Ankem;
    String Nuoc;

    public Cart(int idProCart, int quantity, String ankem, String nuoc) {

        IdProCart = idProCart;
        Quantity = quantity;
        Ankem = ankem;
        Nuoc = nuoc;
    }

    public Cart(int idProCart, int idUserCart, int quantity, String ankem, String nuoc) {

        IdProCart = idProCart;
        IdUserCart = idUserCart;
        Quantity = quantity;
        Ankem = ankem;
        Nuoc= nuoc;
    }

    public Cart(int idOrderCard, int idProCart, int idUserCart, int quantity, String ankem, String nuoc) {
        IdOrderCard = idOrderCard;
        IdUserCart = idUserCart;
        IdProCart = idProCart;
        Quantity = quantity;
        Ankem = ankem;
        Nuoc = nuoc;
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
        Nuoc= nuoc;
    }

    public int getIdOrderCard() {
        return IdOrderCard;
    }

    public void setIdOrderCard(int idOrderCard) {
        IdOrderCard = idOrderCard;
    }

    public int getIdUserCart() {
        return IdUserCart;
    }

    public void setIdUserCart(int idUserCart) {
        IdUserCart = idUserCart;
    }

    public int getIdProCart() {
        return IdProCart;
    }

    public void setIdProCart(int idProCart) {
        IdProCart = idProCart;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
