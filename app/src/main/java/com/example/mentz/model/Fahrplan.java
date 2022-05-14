package com.example.mentz.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class Fahrplan implements Serializable {

    private String version;
    private List<SystemMessage> systemMessages;
    private List<Location> locations;

    protected Fahrplan(Parcel in) {
        version = in.readString();
        systemMessages = in.createTypedArrayList(SystemMessage.CREATOR);
    }

    public static final Parcelable.Creator<Fahrplan> CREATOR = new Parcelable.Creator<Fahrplan>() {
        @Override
        public Fahrplan createFromParcel(Parcel in) {
            return new Fahrplan(in);
        }

        @Override
        public Fahrplan[] newArray(int size) {
            return new Fahrplan[size];
        }
    };

    //Getter
    public String getVersion() {
        return version;
    }
    public List<SystemMessage> getSystemMessages() {
        return systemMessages;
    }
    public List<Location> getLocations() {
        return locations;
    }

    //Setter
    public void setVersion(String version) {
        this.version = version;
    }
    public void setSystemMessages(List<SystemMessage> systemMessages) {
        this.systemMessages = systemMessages;
    }
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
