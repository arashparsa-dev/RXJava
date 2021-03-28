package com.example.rxjava.Model;

public class Users {

    private String name, email ;
    private int id;
    private boolean show_item;

    public Users(String name, String email, int id, boolean show_item) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.show_item = show_item;
    }

    public boolean isShow_item() {
        return show_item;
    }

    public void setShow_item(boolean show_item) {
        this.show_item = show_item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
