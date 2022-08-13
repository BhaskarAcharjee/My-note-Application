package com.bhaskar.mynote;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepo noteRepo;
    public LiveData<List<Note>> notelist;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepo = new NoteRepo(application);
        notelist =noteRepo.getAlldata();
    }

    public void insert(Note note){
        noteRepo.insertData(note);
    }
    public void update(Note note){
        noteRepo.updateData(note);
    }
    public void delete(Note note){
        noteRepo.deleteData(note);
    }
    public LiveData<List<Note>> getAlldata(){
        return notelist;
    }

}
