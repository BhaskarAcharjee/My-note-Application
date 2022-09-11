package com.bhaskar.mynote.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bhaskar.mynote.Models.Notes;

@Database(entities = Notes.class,version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase noteDatabase;
    private static String databaseName = "note_database";

    public synchronized static NoteDatabase getInstance(Context context){
        if (noteDatabase==null){
            noteDatabase = Room.databaseBuilder(context.getApplicationContext()
                    ,NoteDatabase.class,databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return noteDatabase;
    }
    public abstract NoteDao noteDao();
}