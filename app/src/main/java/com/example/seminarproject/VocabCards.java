package com.example.seminarproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VocabCards extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<VocabCard> vocabcards;
    String mv1, mv2, mv3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabcards);

        recyclerView = findViewById(R.id.recyclerView_vocabcards);
        vocabcards = new ArrayList<>();

        mv1 = getIntent().getExtras().getString("mv1", "");
        mv2 = getIntent().getExtras().getString("mv2", "");
        mv3 = getIntent().getExtras().getString("mv3", "");

        if(mv1.equals("Mortal Kombat")) {
            vocabcards.add(new VocabCard("ahora", "at the present time or moment", "right now", "Hay que empezar a entrenar desde ahora."));
            vocabcards.add(new VocabCard("campeón", "a person who has defeated or surpassed all rivals in a competition", "champion", "La leyenda dice que los campeones entrenaban ahí para el Mortal Kombat."));
            vocabcards.add(new VocabCard("dragón", "a mythical monster like a giant reptile", "dragon", "La leyenda dice que los campeones entrenaban ahí para el Mortal Kombat."));
            vocabcards.add(new VocabCard("mundo", "the earth, together with all of its countries, peoples, and natural features", "world", "Guerrero Matoka en diferentes culturas de todo el mundo semenciona un gran torneo."));
            vocabcards.add(new VocabCard("pelear", "a violent confrontation or struggle", "to fight", "¿Con quién voy a pelear?"));
            vocabcards.add(new VocabCard("templo", "a building devoted to the worship, or regarded as the dwelling place, of a god or gods or other objects of religious reverence", "temple", "Entonces, por eso no te diré dónde está el templo."));
            vocabcards.add(new VocabCard("tierra", "the planet on which we live, the world", "earth", "El destino de la Tierra...está en nuestras manos."));
            vocabcards.add(new VocabCard("torneo", "a series of contests between a number of competitors, who compete for an overall prize", "tournament", "Guerrero Matoka en diferentes culturas de todo el mundo semenciona un gran torneo."));
        }

        if(mv2.equals("The Green Sea")) {
            vocabcards.add(new VocabCard("aquí", "at the present time or moment", "here", "¿Qué están haciendo aquí?"));
            vocabcards.add(new VocabCard("casa", "the place where one lives permanently, the creator and ruler of the universe and source of all moral authority; the supreme being", "home", "Ella está en casa, te vas caminando o te vas arrastrando."));
            vocabcards.add(new VocabCard("gracias", "a polite expression used when acknowledging a gift, service, or compliment, or accepting or refusing an offer", "thank you", "Muchas gracias por todo. Te lo agradezco."));
  // someones name oops  vocabcards.add(new VocabCard("lana", "a current medium of exchange in the form of coins and banknotes; coins and banknotes collectively", "", ""));
            vocabcards.add(new VocabCard("niña", "a female child", "girl", "No necesito ninguna ayuda de una inútil... ¡Joder niña!"));
            vocabcards.add(new VocabCard("tiempo", "the indefinite continued progress of existence and events in the past, present, and future regarded as a whole", "time", "Después de todo, se romperan en poco tiempo."));
            vocabcards.add(new VocabCard("trabajo", "activity involving mental or physical effort done in order to achieve a purpose or result", "work", "Necesito hacer, sólo una cosa para mi trabajo."));
        }
        if(mv3.equals("Shang-Chi")) {
            vocabcards.add(new VocabCard("aldea", "a group of houses and associated buildings, larger than a hamlet and smaller than a town, situated in a rural area", "village", "Una aldea oculta, llena de criaturas míticas y magia antigua."));
            vocabcards.add(new VocabCard("anillos", "a small circular band, typically of precious metal", "rings", "Si los anillos de papá eran tan poderosos, ¿cómo lo venciste?"));
            vocabcards.add(new VocabCard("años", "the time taken by the earth to make one revolution around the sun", "years", "Bueno, tenía 15 años. ¿Sí?"));
            vocabcards.add(new VocabCard("gente", "human beings in general or considered collectively", "people", "Nuestra gente estuvo aquí más de 4000 años..."));
            vocabcards.add(new VocabCard("nombre", "a word or set of words by which a person, animal, place, or thing is known, addressed, or referred to", "name", "Pero como él no sabía mi nombre real se inventó uno nuevo."));
            vocabcards.add(new VocabCard("siempre", "for all future time; for always", "forever", "Siempre sé dónde están mis hijos."));
            vocabcards.add(new VocabCard("tiempo", "the indefinite continued progress of existence and events in the past, present, and future regarded as a whole", "time", "Ganaré algo de tiempo. Sigue adelante."));
            vocabcards.add(new VocabCard("vida", "the condition that distinguishes animals and plants from inorganic matter, including the capacity for growth, reproduction, functional activity, and continual change preceding death", "life", "Estuve la mitad de tu vida a tu lado."));
        }

        VocabCardAdapter adapter = new VocabCardAdapter(vocabcards);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
