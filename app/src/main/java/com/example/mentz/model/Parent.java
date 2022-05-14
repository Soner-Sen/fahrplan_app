package com.example.mentz.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Parent implements Parcelable {
    private String id;
    private String name;
    private String type;

    protected Parent(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<Parent> CREATOR = new Parcelable.Creator<Parent>() {
        @Override
        public Parent createFromParcel(Parcel in) {
            return new Parent(in); }
        @Override
        public Parent[] newArray(int size) {
            return new Parent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(type);
    }

    //Getter
    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    //Setter
    public void setId(String id) {
        this.id = id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
}
