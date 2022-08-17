package com.example.appcrudproject;

public class Person {
    private int Id;
    private String Name;
    private String Address;
    private String PhoneNumber;
    private String Note;
    private boolean IsFavorite;

    public Person(int id, String name, String address, String phoneNumber, String note, boolean isFavorite) {
        Id = id;
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
        Note = note;
        IsFavorite = isFavorite;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public boolean isFavorite() {
        return IsFavorite;
    }

    public void setFavorite(boolean favorite) {
        IsFavorite = favorite;
    }
}