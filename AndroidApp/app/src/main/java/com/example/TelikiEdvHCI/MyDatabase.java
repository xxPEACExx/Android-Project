package com.example.TelikiEdvHCI;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Athlete.class, Sport.class, Squad.class}, version = 1)

public abstract class MyDatabase extends RoomDatabase {

    public abstract mydao mydao();


}
