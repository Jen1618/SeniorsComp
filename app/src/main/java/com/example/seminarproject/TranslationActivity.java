package com.example.seminarproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TranslationActivity extends AppCompatActivity {
    //create a list for every movie and have the intent from the activity selection of movie so we know what list to reference
    // can use activity_won
    // cardview for the beginning movies
    // fill in the blank with quiz layout

    String mv1, mv2, mv3;
    private Button button_next1;
    private TextView textView_spanWord;

    protected void onCreate(Bundle SavedInstance) {
        super.onCreate(SavedInstance);
        setContentView(R.layout.activity_writing);

        button_next1 = findViewById(R.id.button_submit);
        textView_spanWord = findViewById(R.id.textView_spanWord);

        mv1 = getIntent().getExtras().getString("mv1", "");
        mv2 = getIntent().getExtras().getString("mv2", "");
        mv3 = getIntent().getExtras().getString("mv3", "");

        ArrayList<String> spanishWord = new ArrayList<>(8);
        ArrayList<String> englishWord = new ArrayList<>(8);


        if(mv1.equals("Mortal Kombat")) {
            spanishWord.add(0, "ahora");
            spanishWord.add(1, "campeón");
            spanishWord.add(2, "dragón");
            spanishWord.add(3, "mundo");
            spanishWord.add(4, "pelear");
            spanishWord.add(5, "templo");
            spanishWord.add(6, "tierra");
            spanishWord.add(7, "torneo");
            englishWord.add(0, "right now");
            englishWord.add(1, "champion");
            englishWord.add(2, "dragon");
            englishWord.add(3, "world");
            englishWord.add(4, "to fight");
            englishWord.add(5, "temple");
            englishWord.add(6, "earth");
            englishWord.add(7, "tournament");

            textView_spanWord.setText(spanishWord.get(0));
        }

        if(mv2.equals("The Green Sea")) {
            spanishWord.add(0, "aquí");
            spanishWord.add(1, "casa");
            spanishWord.add(2, "gracias");
            spanishWord.add(3, "niña");
            spanishWord.add(4, "tiempo");
            spanishWord.add(5, "trabajo");
            englishWord.add(0, "here");
            englishWord.add(1, "home");
            englishWord.add(2, "thank you");
            englishWord.add(3, "girl");
            englishWord.add(4, "time");
            englishWord.add(5, "work");
            textView_spanWord.setText(spanishWord.get(0));
        }

        if(mv3.equals("Shang-Chi")) {
            spanishWord.add(0, "aldea");
            spanishWord.add(1, "anillos");
            spanishWord.add(2, "años");
            spanishWord.add(3, "gente");
            spanishWord.add(4, "nombre");
            spanishWord.add(5, "siempre");
            spanishWord.add(6, "tiempo");
            spanishWord.add(7, "vida");
            englishWord.add(0, "village");
            englishWord.add(1, "rings");
            englishWord.add(2, "years");
            englishWord.add(3, "people");
            englishWord.add(4, "name");
            englishWord.add(5, "forever");
            englishWord.add(6, "time");
            englishWord.add(7, "life");
            textView_spanWord.setText(spanishWord.get(0));
        }

        button_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
