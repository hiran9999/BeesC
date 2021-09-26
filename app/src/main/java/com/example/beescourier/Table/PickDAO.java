package com.example.beescourier.Table;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PickDAO {

    //for inserting data
    @Insert
    void insertData(Tables tables);

    //for inserting all data
    @Query("SELECT * FROM tables")
    List<Tables> selectAll();

    @Update
    void updateData(Tables tables);

    @Delete
    void deleteData(Tables tables);
}
