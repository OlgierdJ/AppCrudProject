package com.example.appcrudproject;

public class Entity {
    public Entity(int Id){
        this.Id = Id;
    }
    private int Id;
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
}
