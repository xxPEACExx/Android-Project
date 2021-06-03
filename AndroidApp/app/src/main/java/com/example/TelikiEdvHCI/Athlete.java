package com.example.TelikiEdvHCI;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "athetes",
        foreignKeys = {
                @ForeignKey(entity=Sport.class,
                        parentColumns = "sportSport",
                        childColumns = "sportAthlete",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        })


/* @Entity(tableName = "athetes") */
public class Athlete {

    @PrimaryKey
    @ColumnInfo(name="idAthlete")
    private int idAthlete;

    @ColumnInfo (name = "nameAthlete")
    private String name;

    @ColumnInfo (name = "surenameAthlete")
    private String surename;

    @ColumnInfo (name = "ageAthlete")
    private int age;

    @ColumnInfo (name = "cityAthlete")
    private String city;

    @ColumnInfo (name = "nationalityAthlete")
    private String nationality;

    @ColumnInfo (name = "sportAthlete")
    private int sportID;

    @ColumnInfo (name = "genderAthlete")
    private String gender;


    public int getIdAthlete() {
        return idAthlete;
    }

    public void setIdAthlete(int idAthlete) {
        this.idAthlete = idAthlete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    public int getSportID() { return sportID; }



    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
