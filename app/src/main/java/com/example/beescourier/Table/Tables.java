package com.example.beescourier.Table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Tables implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "pick_date")
    private String pick_date;

    @ColumnInfo(name = "pick_address")
    private String pick_address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPick_date() {
        return pick_date;
    }

    public void setPick_date(String pick_date) {
        this.pick_date = pick_date;
    }

    public String getPick_address() {
        return pick_address;
    }

    public void setPick_address(String pick_address) {
        this.pick_address = pick_address;
    }

    @Override
    public String toString() {
        return "Tables{" +
                "id=" + id +
                ", pick_date='" + pick_date + '\'' +
                ", pick_address='" + pick_address + '\'' +
                '}';
    }
}
