package com.bhaskar.mynote.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bhaskar.mynote.Models.Notes;

@Database(entities = Notes.class,version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    public static NoteDatabase noteDatabase;
    public static String databaseName = "note_database";
    public abstract NoteDao noteDao();
    public static synchronized NoteDatabase getInstance(Context context){
        if (noteDatabase==null){
            noteDatabase = Room.databaseBuilder(context.getApplicationContext()
                    ,NoteDatabase.class,databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return noteDatabase;
    }
}