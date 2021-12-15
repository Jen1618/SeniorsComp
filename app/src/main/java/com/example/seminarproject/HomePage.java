package com.example.seminarproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomePage extends AppCompatActivity {
    private ImageView imageView_mv1;
    private ImageView imageView_mv2;
    private ImageView imageView_mv3;
    private TextView textView_mv1;
    private TextView textView_mv2;
    private TextView textView_mv3;
    private CardView cardView_mv1, cardView_mv2, cardView_mv3;
    private String mv1;
    private String mv2;
    private String mv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        imageView_mv1 = findViewById(R.id.imageView_mv01);
        imageView_mv2 = findViewById(R.id.imageView_mv02);
        imageView_mv3 = findViewById(R.id.imageView_mv03);
        textView_mv1 = findViewById(R.id.textView_mvtitle01);
        textView_mv2 = findViewById(R.id.textView_mvtitle02);
        textView_mv3 = findViewById(R.id.textView_mvtitle03);
        cardView_mv1 = findViewById(R.id.cardView_mv1);
        cardView_mv2 = findViewById(R.id.cardView_mv2);
        cardView_mv3 = findViewById(R.id.cardView_mv3);

        mv1 = "Mortal Kombat";
        mv2 = "The Green Sea";
        mv3 = "Shang-Chi";

        Picasso.get().load("https://m.media-amazon.com/images/M/MV5BY2ZlNWIxODMtN2YwZi00ZjNmLWIyN2UtZTFkYmZkNDQyNTAyXkEyXkFqcGdeQXVyODkzNTgxMDg@._V1_.jpg").into(imageView_mv1);
        Picasso.get().load("https://static.metacritic.com/images/products/movies/5/25b32260e228c4e2bdc609cb781443ed.jpg").into(imageView_mv2);
        Picasso.get().load("https://www.cnet.com/a/img/jIocYxpwSMise2-OhuW3vpHoG-o=/940x0/2021/04/19/111f2cf0-1f0e-4884-8733-a4809195773c/shang-chi-poster-marvel.jpg").into(imageView_mv3);


        cardView_mv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }

            private void launchNextActivity(View v) {
                Intent intent = new Intent(HomePage.this, ActivitySelection.class);
                intent.putExtra("mv1", mv1);
                startActivity(intent);
            }
        });

        cardView_mv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity1(v);
            }

            private void launchNextActivity1(View v) {
                Intent intent = new Intent(HomePage.this, ActivitySelection.class);
                intent.putExtra("mv2", mv2);
                startActivity(intent);
            }
        });

        cardView_mv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity2(v);
            }

            private void launchNextActivity2(View v) {
                Intent intent = new Intent(HomePage.this, ActivitySelection.class);
                intent.putExtra("mv3", mv3);
                startActivity(intent);
            }
        });
    }
}
