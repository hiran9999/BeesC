package com.example.beescourier.Table;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    Context context;
    static DatabaseClient client;
    PickDatabase pickDatabase;

    public DatabaseClient(Context context){
        this.context = context;

        pickDatabase = Room.databaseBuilder(context,PickDatabase.class, "PickDatabase").build();
    }
    public static synchronized DatabaseClient getInstance(Context context){
        if (client == null){
            client = new DatabaseClient(context);
        }
        return client;
    }
    public PickDatabase getPickDatabase(){
        return pickDatabase;
    }
}
