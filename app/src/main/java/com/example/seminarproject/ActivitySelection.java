package com.example.seminarproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ActivitySelection extends AppCompatActivity {

    private ImageView imageView_vocabcards;
    private ImageView imageView_match;
    private ImageView imageView_game2;
    private ImageView imageView_game3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        imageView_vocabcards = findViewById(R.id.imageView_vocabCard);
        imageView_match = findViewById(R.id.imageView_match);
        imageView_game2 = findViewById(R.id.imageView_game2);
        imageView_game3 = findViewById(R.id.imageView_game3);

        Picasso.get().load("https://static.metacritic.com/images/products/movies/5/25b32260e228c4e2bdc609cb781443ed.jpg").into(imageView_vocabcards);
        Picasso.get().load("https://static.metacritic.com/images/products/movies/5/25b32260e228c4e2bdc609cb781443ed.jpg").into(imageView_match);
        Picasso.get().load("https://static.metacritic.com/images/products/movies/5/25b32260e228c4e2bdc609cb781443ed.jpg").into(imageView_game2);
        Picasso.get().load("https://static.metacritic.com/images/products/movies/5/25b32260e228c4e2bdc609cb781443ed.jpg").into(imageView_game3);


        imageView_vocabcards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }

            private void launchNextActivity(View v) {
                Intent intent = new Intent(ActivitySelection.this, VocabCards.class);
                startActivity(intent);
            }
        });

        imageView_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity1(v);
            }

            private void launchNextActivity1(View v) {
                Intent intent = new Intent(ActivitySelection.this, MatchingGame.class);
                startActivity(intent);
            }
        });
    }
}
