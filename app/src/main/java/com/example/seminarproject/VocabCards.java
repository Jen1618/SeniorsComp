package com.example.seminarproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VocabCards extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<VocabCard> vocabcards;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabcards);

        recyclerView = findViewById(R.id.recyclerView_vocabcards);
        vocabcards = new ArrayList<>();
    }
}
