package com.example.pahlawan;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelPahlawan implements Parcelable {
    int image;
    String name,description;

    public ModelPahlawan(){

    }

    protected ModelPahlawan(Parcel in) {
        image = in.readInt();
        name = in.readString();
        description = in.readString();
    }

    public static final Creator<ModelPahlawan> CREATOR = new Creator<ModelPahlawan>() {
        @Override
        public ModelPahlawan createFromParcel(Parcel in) {
            return new ModelPahlawan(in);
        }

        @Override
        public ModelPahlawan[] newArray(int size) {
            return new ModelPahlawan[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(description);
    }
}
