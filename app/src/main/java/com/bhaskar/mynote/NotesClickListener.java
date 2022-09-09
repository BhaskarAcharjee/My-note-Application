package com.bhaskar.mynote;

import androidx.cardview.widget.CardView;

import com.bhaskar.mynote.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);

}
