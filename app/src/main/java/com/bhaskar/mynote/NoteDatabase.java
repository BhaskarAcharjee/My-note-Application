package com.bhaskar.mynote;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class,version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    public static NoteDatabase instance;
    public static String databaseName = "note_database";
    public abstract NoteDao noteDao();
    public static synchronized NoteDatabase getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext()
                    ,NoteDatabase.class,databaseName).fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}