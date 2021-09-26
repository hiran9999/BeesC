package com.example.beescourier.Table;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Tables.class},version = 1)
public abstract class PickDatabase extends RoomDatabase {

    public abstract PickDAO pickDAO();
}
