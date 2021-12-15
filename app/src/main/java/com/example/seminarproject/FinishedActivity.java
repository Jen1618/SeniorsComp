package com.example.seminarproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinishedActivity extends AppCompatActivity {
    TextView textView_resultText;
    TextView textView_intro;
    int correct, wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correct = getIntent().getIntExtra("correct", 0);
        wrong = getIntent().getIntExtra("wrong", 0);
        textView_resultText = findViewById(R.id.textView_resultText);
        textView_intro = findViewById(R.id.textView_intro);

        textView_resultText.setText(correct+"/4");
    }
}
