package com.example.TelikiEdvHCI;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "squads",
        foreignKeys = {
                @ForeignKey(entity=Sport.class,
                        parentColumns = "sportSport",
                        childColumns = "sportsSquad",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        })

/*@Entity (tableName = "squads") */
public class Squad {


    @PrimaryKey
    @ColumnInfo (name = "idSquad")
    private int idSquad;

    @ColumnInfo (name = "nameSquad")
    private String name;

    @ColumnInfo (name = "stadiumSquad")
    private String stadiumName;

    @ColumnInfo (name = "citySquad")
    private String city;

    @ColumnInfo (name = "nationalitySquad")
    private String nationality;

    @ColumnInfo (name = "sportsSquad")
    private int sportID;

    @ColumnInfo (name = "yearSquad")
    private int year;


    public int getIdSquad() {
        return idSquad;
    }

    public void setIdSquad(int idSquad) {
        this.idSquad = idSquad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
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

    public int getSportID() {
        return sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
