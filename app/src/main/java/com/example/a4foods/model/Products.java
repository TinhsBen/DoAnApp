package com.example.a4foods.model;

import java.io.Serializable;

public class Products implements Serializable {
    private int Id;
    private String Name;
    private String Description;
    private int Category;
    private int Brand;

//    private String Category;
//    private String Brand;
    private int Price;
//    private byte[] ImagePro;
    private String ImagePro;
    private String Nuoc;
    private String Ankem;

    public Products(int id, String name, String description, int category, int brand, int price, String imagePro, String nuoc, String ankem) {
        Id = id;
        Name = name;
        Description = description;
        Category = category;
        Brand = brand;
        Price = price;
        ImagePro = imagePro;
        Nuoc = nuoc;
        Ankem = ankem;
    }

    //    public Products(int id, String name, String category, String brand, String description, int price, byte[] imagePro, int size, String color) {
//        Id = id;
//        Name = name;
//        Category = category;
//        Brand = brand;
//        Description = description;
//        Price = price;
//        ImagePro = imagePro;
//        Size = size;
//        Color = color;
//    }

//    public Products(int id, byte[] imagePro, String name, int price) {
//        Id = id;
//        ImagePro = imagePro;
//        Name = name;
//        Price = price;
//    }


    public Products(String name, String description, int category, int brand, int price, String imagePro, String nuoc, String ankem) {
        Name = name;
        Description = description;
        Category = category;
        Brand = brand;
        Price = price;
        ImagePro = imagePro;
        Nuoc = nuoc;
        Ankem = ankem;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public int getBrand() {
        return Brand;
    }

    public void setBrand(int brand) {
        Brand = brand;
    }

    public String getAnkem() {
        return Ankem;
    }

    public void setAnkem(String ankem) {
        Ankem = ankem;
    }

//    public byte[] getImagePro() {return ImagePro;}

//    public void setImagePro(byte[] imagePro) {
//        ImagePro = imagePro;
//    }

    public String getNuoc() {
        return Nuoc;
    }

    public void setNuoc(String nuoc) {
        Nuoc = nuoc;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }


    public String getImagePro() {
        return ImagePro;
    }
    public void setImagePro(String imagePro) {
        ImagePro = imagePro;
    }
}
