package com.example.TelikiEdvHCI;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity (tableName = "sports")

public class Sport {

    @PrimaryKey
    @ColumnInfo (name = "sportSport")
    private int sportID;

    @ColumnInfo (name = "nameSport")
    private String name;

    @ColumnInfo (name = "typeSport")
    private String type ;

    @ColumnInfo (name = "genderSport")
    private String gender;

    public int getSportID() {
        return sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
