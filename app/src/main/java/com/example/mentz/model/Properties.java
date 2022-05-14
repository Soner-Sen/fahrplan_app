package com.example.mentz.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Properties implements Parcelable {

    private String stopId;

    protected Properties(Parcel in) {
        stopId = in.readString();
    }

    public static final Creator<Properties> CREATOR = new Creator<Properties>() {
        @Override
        public Properties createFromParcel(Parcel in) {
            return new Properties(in);
        }

        @Override
        public Properties[] newArray(int size) {
            return new Properties[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(stopId);
    }

    //Getter
    public String getStopId() {
        return stopId;
    }
    //Setter
    public void setStopId(String stopId) {
        this.stopId = stopId;
    }
}
