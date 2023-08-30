package com.example.pgtabme.Model;

import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("code")
    private  String code;


    @SerializedName("title")
    private  String title;


    @SerializedName("description")
    private String description;


    @SerializedName("image_url")
    private String image_url;



    @SerializedName("category")
    private String category;


    public DataModel(String code, String title, String description, String image_url, String category) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.image_url = image_url;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
