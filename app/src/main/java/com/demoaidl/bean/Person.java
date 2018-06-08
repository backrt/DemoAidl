package com.demoaidl.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author：lhb on 2018/6/8 15:39
 * Mail：lihaibo@znds.com
 */

public class Person implements Parcelable {
    private String name;

    public Person(String s) {
        this.name = s;
    }

    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Person(Parcel in) {
        name = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
