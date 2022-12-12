package com.example.tinderanimal.model;

public class Animal {

    int id, category;
    String img, title, description, number, mail;

    public Animal(int id, String img, String title, String description, String number, String mail, int category) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.description = description;
        this.number = number;
        this.mail = mail;
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
}
