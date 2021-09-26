package com.example.beescourier.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserInfo.db";

    public DBHelper(@Nullable Context context) { super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+ UserMaster.Users.TABLE_NAME+ "("+
                        UserMaster.Users._ID+ " INTEGER PRIMARY KEY,"+
                        UserMaster.Users.COLUMN_NAME_NAME+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_ADDRESS+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_PHONE+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_WEIGHT+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_WIDTH+ " TEXT," +
                        UserMaster.Users.COLUMN_NAME_LENGTH+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_HEIGHT+ " TEXT,"+
                        UserMaster.Users.COLUMN_NAME_DELIVERY+ " TEXT)";


        db.execSQL(SQL_CREATE_ENTRIES);

    }
    public long addInfo(String name, String Address, String Phone, String weight,String width, String length, String height, String delivery){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserMaster.Users.COLUMN_NAME_NAME, name);
        values.put(UserMaster.Users.COLUMN_NAME_ADDRESS, Address);
        values.put(UserMaster.Users.COLUMN_NAME_PHONE, Phone);
        values.put(UserMaster.Users.COLUMN_NAME_WEIGHT, weight);
        values.put(UserMaster.Users.COLUMN_NAME_WIDTH, width);
        values.put(UserMaster.Users.COLUMN_NAME_LENGTH, length);
        values.put(UserMaster.Users.COLUMN_NAME_HEIGHT, height);
        values.put(UserMaster.Users.COLUMN_NAME_DELIVERY, delivery);

        return db.insert(UserMaster.Users.TABLE_NAME, null,values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
