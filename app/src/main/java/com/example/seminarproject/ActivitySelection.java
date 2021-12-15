package com.example.seminarproject;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ActivitySelection extends AppCompatActivity {

    private TextView textView_movieSelect;
    private CardView cardView_act1, cardView_act2, cardView_act3, cardView_act4, cardView_act5;

    public static ArrayList<ModelClass> listQ;
    public static ArrayList<ModelClass> listM;
    DatabaseReference databaseReference;

    String mv1, mv2, mv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection2);
        textView_movieSelect = findViewById(R.id.textView_movieSelect);
        cardView_act1 = findViewById(R.id.cardView_act1);
        cardView_act2 = findViewById(R.id.cardView_act2);
        cardView_act3 = findViewById(R.id.cardView_act3);
        cardView_act4 = findViewById(R.id.cardView_act4);
        cardView_act5 = findViewById(R.id.cardView_act5);

        mv1 = getIntent().getExtras().getString("mv1", "");
        mv2 = getIntent().getExtras().getString("mv2", "");
        mv3 = getIntent().getExtras().getString("mv3", "");

        Log.i("data", mv1);


        listQ = new ArrayList<>();
        if (mv1.equals("Mortal Kombat")) {
            textView_movieSelect.setText("Mortal Kombat Activities");
            listQ.add(new ModelClass("at the present time or moment", "ahora", "campeón", "mundo", "tierra", "ahora"));
            listQ.add(new ModelClass("a series of contests between a number of competitors", "pelear", "campeón", "dragón", "torneo", "torneo"));
            listQ.add(new ModelClass("a building devoted to the worship, or regarded as the dwelling place, of a god or gods or other objects of religious reverence", "tierra", "ahora", "templo", "pelear", "templo"));
            listQ.add(new ModelClass("the earth, together with all of its countries, peoples, and natural features", "tierra", "torneo", "mundo", "dragón", "mundo"));
        }
        if (mv3.equals("Shang-Chi")) {
            textView_movieSelect.setText("Shang-Chi Activities");
            listQ.add(new ModelClass("a group of houses and associated buildings, larger than a hamlet and smaller than a town, situated in a rural area", "siempre", "gente", "aldea", "tiempo", "aldea"));
            listQ.add(new ModelClass("a small circular band, typically of precious metal ", "gente", "anillos", "nombre", "vida", "anillos"));
            listQ.add(new ModelClass("for all future time; for always", "tiempo", "aldea", "siempre", "años", "siempre"));
            listQ.add(new ModelClass("the condition that distinguishes animals and plants from inorganic matter, including the capacity for growth, reproduction, functional activity, and continual change preceding death", "anillos", "tiempo", "vida", "aldea", "vida"));

        }
        if (mv2.equals("The Green Sea")) {
            textView_movieSelect.setText("The Green Sea Activities");
            listQ.add(new ModelClass("activity involving mental or physical effort done in order to achieve a purpose or result", "tiempo", "gracias", "aquí", "trabajo", "trabajo"));
            listQ.add(new ModelClass("a current medium of exchange in the form of coins and banknotes; coins and banknotes collectively", "niña", "trabajo", "lana", "dios", "lana"));
            listQ.add(new ModelClass("the place where one lives permanently, especially as a member of a family or household", "casa", "aquí", "niña", "lana", "casa"));
            listQ.add(new ModelClass("a polite expression used when acknowledging a gift, service, or compliment, or accepting or refusing an offer", "casa", "dios", "tiempo", "gracias", "gracias"));

        }

        listM = new ArrayList<>();
        if (mv1.equals("Mortal Kombat")) {
            listM.add(new ModelClass("Match the word with the spanish translation: now", "ahora", "campeón", "mundo", "tierra", "ahora"));
            listM.add(new ModelClass("Match the word with the spanish translation: tournament", "pelear", "campeón", "dragón", "torneo", "torneo"));
            listM.add(new ModelClass("Match the word with the spanish translation: temple", "tierra", "ahora", "templo", "pelear", "templo"));
            listM.add(new ModelClass("Match the word with the spanish translation: world", "tierra", "torneo", "mundo", "dragón", "mundo"));
        }
        if (mv3.equals("Shang-Chi")) {
            listM.add(new ModelClass("Match the word with the spanish translation: village", "siempre", "gente", "aldea", "tiempo", "aldea"));
            listM.add(new ModelClass("Match the word with the spanish translation: rings", "gente", "anillos", "nombre", "vida", "anillos"));
            listM.add(new ModelClass("Match the word with the spanish translation: forever", "tiempo", "aldea", "siempre", "años", "siempre"));
            listM.add(new ModelClass("Match the word with the spanish translation: life", "anillos", "tiempo", "vida", "aldea", "vida"));

        }
        if (mv2.equals("The Green Sea")) {
            listM.add(new ModelClass("Match the word with the spanish translation: work", "tiempo", "gracias", "aquí", "trabajo", "trabajo"));
            listM.add(new ModelClass("Match the word with the spanish translation: money", "niña", "trabajo", "lana", "dios", "lana"));
            listM.add(new ModelClass("Match the word with the spanish translation: home", "casa", "aquí", "niña", "lana", "casa"));
            listM.add(new ModelClass("Match the word with the spanish translation: Thank you", "casa", "dios", "tiempo", "gracias", "gracias"));

        }

        cardView_act1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }

            private void launchNextActivity(View v) {
                Intent intent = new Intent(ActivitySelection.this, VocabCards.class);
                intent.putExtra("mv1", mv1);
                intent.putExtra("mv2", mv2);
                intent.putExtra("mv3", mv3);
                startActivity(intent);
            }
        });

        cardView_act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity1(v);
            }

            private void launchNextActivity1(View v) {
                Intent intent = new Intent(ActivitySelection.this, MatchingGame.class);
                startActivity(intent);
            }
        });

        cardView_act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity2(v);
            }

            private void launchNextActivity2(View v) {
                Intent intent = new Intent(ActivitySelection.this, QuestionActivity.class);
                //intent.putExtra("data", listofQ);
                startActivity(intent);
            }
        });
        cardView_act4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                launchNextActivity3(v);
            }

            private void launchNextActivity3(View v){
                Intent intent = new Intent(ActivitySelection.this, TranslationActivity.class);
                intent.putExtra("mv1", mv1);
                intent.putExtra("mv2", mv2);
                intent.putExtra("mv3", mv3);
                startActivity(intent);
            }
        });
    }
}
