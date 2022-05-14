package com.example.mentz.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SystemMessage implements Parcelable {

    private String type;
    private String module;
    private String text;
    private Integer code;

    protected SystemMessage(Parcel in) {
        if (in.readByte() == 0) {
            code = null;
        } else {
            code = in.readInt();
        }
        module = in.readString();
        text = in.readString();
        type = in.readString();
    }

    public static final Creator<SystemMessage> CREATOR = new Creator<SystemMessage>() {
        @Override
        public SystemMessage createFromParcel(Parcel in) {
            return new SystemMessage(in);
        }

        @Override
        public SystemMessage[] newArray(int size) {
            return new SystemMessage[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (code == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(code);
        }
        parcel.writeString(module);
        parcel.writeString(text);
        parcel.writeString(type);
    }

    //Getter
    public String getType() {
        return type;
    }
    public String getModule() {
        return module;
    }
    public String getText() {
        return text;
    }
    public Integer getCode() {
        return code;
    }

    //Setter
    public void setType(String type) {
        this.type = type;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
}
