package com.example.eventlistmvvm;

import android.content.Context;

import androidx.room.Room;

import com.example.eventlistmvvm.roomdb.Event;
import com.example.eventlistmvvm.roomdb.EventDb;

import java.util.List;

public class EventRepository {
    private EventDb db;
    private static EventRepository repoInstance;

    private EventRepository() {}

    public static EventRepository getInstance(Context context){
        if (repoInstance == null){
            repoInstance = new EventRepository();
            repoInstance.db = Room.databaseBuilder(context, EventDb.class,
                    EventDb.DATABASE_NAME).allowMainThreadQueries().build();
        }
        return repoInstance;
    }
    public List<Event> getEvents() {
        return db.eventDao().getAllEvent();
    }

    public void insertEvent(Event event) {db.eventDao().insertEvent(event);}

}
