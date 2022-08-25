package com.example.appcrudproject.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Person extends EntityBase {
    private String email;

    private String name;

    private String phoneNumber;

    private String note;

    private boolean favorite;

    public Person(){
        super();
    }

    protected Person(Parcel in) {
        id = in.readLong();
        email = in.readString();
        name = in.readString();
        phoneNumber = in.readString();
        note = in.readString();
        favorite = in.readByte() != 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.email);
        parcel.writeString(this.phoneNumber);
        parcel.writeString(this.note);
        parcel.writeBoolean(this.favorite);
    }
}
