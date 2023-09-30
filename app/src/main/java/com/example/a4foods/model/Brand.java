package com.example.a4foods.model;

import java.io.Serializable;

public class Brand implements Serializable {
    private int Id;
    private String NameBrand;
    private String ImageBrand;

    public Brand(int id, String nameBrand, String imageBrand) {
        Id = id;
        NameBrand = nameBrand;
        ImageBrand = imageBrand;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNameBrand() {
        return NameBrand;
    }

    public void setNameBrand(String nameBrand) {
        NameBrand = nameBrand;
    }

    public String getImageBrand() {
        return ImageBrand;
    }

    public void setImageBrand(String imageBrand) {
        ImageBrand = imageBrand;
    }
}
