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

public class HomePage extends AppCompatActivity {
    private ImageView imageView_mv1;
    private ImageView imageView_mv2;
    private ImageView imageView_mv3;
    private ImageView imageView_mv4;
    private TextView textView_mv1;
    private TextView textView_mv2;
    private TextView textView_mv3;
    private TextView textView_mv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        imageView_mv1 = findViewById(R.id.imageView_mv1);
        imageView_mv2 = findViewById(R.id.imageView_mv2);
        imageView_mv3 = findViewById(R.id.imageView_mv3);
        imageView_mv4 = findViewById(R.id.imageView_mv4);

        textView_mv1 = findViewById(R.id.textView_mv1);
        textView_mv2 = findViewById(R.id.textView_mv2);
        textView_mv3 = findViewById(R.id.textView_mv3);
        textView_mv4 = findViewById(R.id.textView_mv4);

      Picasso.get().load("https://static.metacritic.com/images/products/movies/5/25b32260e228c4e2bdc609cb781443ed.jpg").into(imageView_mv1);
        Picasso.get().load("https://static.metacritic.com/images/products/movies/5/25b32260e228c4e2bdc609cb781443ed.jpg").into(imageView_mv2);
        Picasso.get().load("https://static.metacritic.com/images/products/movies/5/25b32260e228c4e2bdc609cb781443ed.jpg").into(imageView_mv3);
        Picasso.get().load("https://static.metacritic.com/images/products/movies/5/25b32260e228c4e2bdc609cb781443ed.jpg").into(imageView_mv4);


        imageView_mv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }

            private void launchNextActivity(View v) {
                Intent intent = new Intent(HomePage.this, ActivitySelection.class);
                startActivity(intent);
            }
        });
    }
}
