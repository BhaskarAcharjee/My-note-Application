package com.bhaskar.mynote.Database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.bhaskar.mynote.Models.Notes;

import java.util.List;

@Dao
public interface NoteDao {
   @Insert(onConflict = REPLACE)
   void insert(Notes notes);
   @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID =:id")
   void update(int id, String title, String notes);
   @Delete
   void delete(Notes notes);

   @Query("SELECT * FROM notes ORDER BY id DESC")
   List<Notes> getAllData();

}