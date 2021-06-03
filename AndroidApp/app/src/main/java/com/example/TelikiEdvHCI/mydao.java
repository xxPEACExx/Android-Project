package com.example.TelikiEdvHCI;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface mydao {

    /*-------- INSERT GIA TOU TREIS PINAKES  AUTOMATA--------*/
    @Insert
    public void insertAthlete (Athlete athlete);

    @Insert
    public void insertSport (Sport sport);

    @Insert void insertSquad (Squad squad);


    /*--------DELETE GIA TOUS 3 PINAKES AUTOMATA-------- */
    @Delete
    public void deleteAthlete (Athlete athlete);

    @Delete
    public void deleteSport (Sport sport);

    @Delete
    public void deleteSquad (Squad squad);

    /*--------UPDATE GIA TOUS 3 PINAKES AUTOMATA-------- */

    @Update
    public void updateAthlete (Athlete athlete);

    @Update
    public void updateSport (Sport sport);

    @Update
    public void updateSquad (Squad squad);


    /*---------Query for Athletes -----------> */

    @Query("select * from athetes")
    public List<Athlete> getAthletes();

    @Query("select * from sports")
    public List<Sport> getSports();

    @Query("select * from squads")
    public List<Squad> getSquads();


    /*---------Query For The Project ---------? */


    /*------------------Query 1 --------------? */
    @Query("SELECT *"
            +"FROM athetes "
            +"WHERE sportAthlete = 1 AND nationalityAthlete= 'Spain'")
    public  List<Athlete> getQuery1();


    /*------------------Query 2 --------------? */

    @Query("SELECT  nameAthlete as field1, MAX(ageAthlete) as field2 , genderAthlete as field3 " +
            "FROM athetes " +
            "GROUP BY athetes.genderAthlete")
    public List<ResultStringInt> getQuery2();

    /*------------------Query 3 --------------? */

    @Query("SELECT athetes.nameAthlete as field1,athetes.ageAthlete as field2, sports.nameSport as field3 " +
            "FROM athetes INNER JOIN sports ON athetes.sportAthlete = sports.sportSport " +
            "WHERE athetes.genderAthlete = 'Female' ")
    public List<ResultStringInt> getQuery3();



}
