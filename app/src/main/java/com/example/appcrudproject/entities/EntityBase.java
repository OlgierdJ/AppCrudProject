package com.example.appcrudproject.entities;


import android.os.Parcelable;

public abstract class EntityBase implements Parcelable {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
