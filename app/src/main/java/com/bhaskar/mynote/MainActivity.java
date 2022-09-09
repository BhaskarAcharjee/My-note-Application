package com.bhaskar.mynote;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bhaskar.mynote.Adapters.NotesListAdapter;
import com.bhaskar.mynote.Database.NoteDatabase;
import com.bhaskar.mynote.Models.Notes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NotesListAdapter notesListAdapter;
    List<Notes> notes = new ArrayList<>();
    NoteDatabase noteDatabase;
    FloatingActionButton fab_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_home);
        fab_add = findViewById(R.id.fab_add);

        noteDatabase = NoteDatabase.getInstance(this);
        notes = noteDatabase.noteDao().getAllData();

        updateRecycler(notes);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DataInsertActivity.class);
                startActivityForResult(intent,101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==101){
            if (requestCode== Activity.RESULT_OK){
                Notes new_notes = (Notes) data.getSerializableExtra("note");
                noteDatabase.noteDao().insert(new_notes);
                notes.clear();
                notes.addAll(noteDatabase.noteDao().getAllData());
            }
        }
    }

    private void updateRecycler(List<Notes> notes) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesListAdapter = new NotesListAdapter(MainActivity.this,notes,notesClickListener);
        recyclerView.setAdapter(notesListAdapter);

    }
    private final NotesClickListener notesClickListener = new NotesClickListener() {
        @Override
        public void onClick(Notes notes) {
        }

        @Override
        public void onLongClick(Notes notes, CardView cardView) {
        }
    };
}