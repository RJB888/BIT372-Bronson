package com.example.roomdbexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Event { //this class defines a table
    @ColumnInfo(name = "id") //@ColumnInfo defines the columns (fields) in the table.  Annotate a variable that represents the field and data type
    @PrimaryKey(autoGenerate = true)
    public int _id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "img_id")
    public  int img_id;

    public Event() {}

    public Event(String title, String date, int imgId){
        this.title = title;
        this.date = date;
        this.img_id = imgId;
    }
}
