package com.rohit.fragment_parcelable_factory;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rohit Kumar on 18-06-2020.
 */

public class Person implements Parcelable {
    private String name;
    private String email;
    private int id;


    protected Person(Parcel in) {
        name = in.readString();
        email = in.readString();
        id = in.readInt();
    }

    public Person(String sName, String sEmail, int iId) {
        this.name=sName;
        this.email=sEmail;
        this.id=iId;
    }

    public String getname()
    {
        return name;
    }
    public String getemail()
    {
        return email;
    }
    public int getid()
    {
        return id;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeInt(id);
    }

    @SuppressWarnings("unused")
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
}