package com.example.seminarproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VocabCardInfo extends AppCompatActivity {
    private TextView textView_infoTitle, textView_title2, textView_spanishWord,
            textView_title3, textView_engTranslation, textView_title4, textView_definition2,textView_title5, textView_phrases ;
    String spanishWord, engWord, definition, phrase;

    protected void onCreate(Bundle SavedInstance) {
        super.onCreate(SavedInstance);
        setContentView(R.layout.activity_vocabcardinfo);

        textView_infoTitle = findViewById(R.id.textView_infoTitle);
        textView_title2 = findViewById(R.id.textView_title2);
        textView_spanishWord = findViewById(R.id.textView_spanishWord);
        textView_title3 = findViewById(R.id.textView_title3);
        textView_engTranslation = findViewById(R.id.textView_engTranslation);
        textView_title4 = findViewById(R.id.textView_title4);
        textView_definition2 = findViewById(R.id.textView_definition2);
        textView_title5 = findViewById(R.id.textView_title5);
        textView_phrases = findViewById(R.id.textView_phrases);

        spanishWord = getIntent().getExtras().getString("spanish word", "");
        engWord = getIntent().getExtras().getString("english word", "");
        definition = getIntent().getExtras().getString("definition", "");
        phrase = getIntent().getExtras().getString("phrase", "");

        textView_spanishWord.setText(spanishWord);
        textView_engTranslation.setText(engWord);
        textView_definition2.setText(definition);
        textView_phrases.setText(phrase);
    }
}
