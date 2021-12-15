package com.example.seminarproject;

//import static com.example.seminarproject.ActivitySelection.listQ;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Collections;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue = 20;
    ProgressBar progressBar;
    List<ModelClass> allQuestionsList;
    ModelClass modelclass;
    int index = 0;
    TextView card_Question, card_Option1, card_Option2, card_Option3, card_Option4;
    CardView cardA, cardB, cardC, cardD;
    Button button_next;

    int correctCount = 0;
    int incorrectCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Hooks();

        // ArrayList<String> listofQ = (ArrayList<String>)getIntent().getSerializableExtra("data");
        progressBar = findViewById(R.id.quiz_timer);
        allQuestionsList = ActivitySelection.listQ;
        Collections.shuffle(allQuestionsList);
        modelclass = ActivitySelection.listQ.get(index);

        setAllData();

        countDownTimer = new CountDownTimer(30000, 1000) { //Change to add more time
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue = timerValue - 1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(QuestionActivity.this); //R.style.Dialogue does not work
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                dialog.setContentView(R.layout.timeout_dialog);

                dialog.findViewById(R.id.button_tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuestionActivity.this, QuestionActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();

    }

    private void setAllData() {
        card_Question.setText(modelclass.getQuestion());
        card_Option1.setText(modelclass.getOptionA());
        card_Option2.setText(modelclass.getOptionB());
        card_Option3.setText(modelclass.getOptionC());
        card_Option4.setText(modelclass.getOptionD());
        enableButton();
        button_next.setEnabled(false);

    }

    private void Hooks() {
        progressBar = findViewById(R.id.quiz_timer);
        card_Question = findViewById(R.id.card_Question);
        card_Option1 = findViewById(R.id.card_Option1);
        card_Option2 = findViewById(R.id.card_Option2);
        card_Option3 = findViewById(R.id.card_Option3);
        card_Option4 = findViewById(R.id.card_Option4);

        cardA = findViewById(R.id.cardA);
        cardB = findViewById(R.id.cardB);
        cardC = findViewById(R.id.cardC);
        cardD = findViewById(R.id.cardD);

        button_next = findViewById(R.id.button_next);
    }

    public void Correct(CardView cardView) {
        cardView.setCardBackgroundColor(getResources().getColor(R.color.green));

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                index++;
                modelclass = ActivitySelection.listQ.get(index);
                resetColor();
                setAllData();
            }
        });
    }

    public void Incorrect(CardView cardView1) {

        cardView1.setCardBackgroundColor(getResources().getColor(R.color.red));

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incorrectCount++;
                if (index < ActivitySelection.listQ.size() - 1) {
                    index++;
                    modelclass = ActivitySelection.listQ.get(index);
                    resetColor();
                    setAllData();
                    //enableButton();
                } else {
                    GameFinished();
                }
            }
        });
    }

    private void GameFinished() {
        Intent intent = new Intent(QuestionActivity.this, FinishedActivity.class);
        intent.putExtra("correct", correctCount);
        intent.putExtra("wrong", incorrectCount);
        startActivity(intent);
    }

    public void enableButton() {
        cardA.setClickable(true);
        cardB.setClickable(true);
        cardC.setClickable(true);
        cardD.setClickable(true);
    }

    public void disableButton() {
        cardA.setClickable(false);
        cardB.setClickable(false);
        cardC.setClickable(false);
        cardD.setClickable(false);
    }

    public void resetColor() {
        cardA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardD.setCardBackgroundColor(getResources().getColor(R.color.white));
    }

    public void OptonAClick(View view) {
        disableButton();
        button_next.setEnabled(true);
        if (modelclass.getOptionA().equals(modelclass.getAnswer())) {
           cardA.setCardBackgroundColor(getResources().getColor(R.color.green));
            if (index < ActivitySelection.listQ.size() - 1) {
                Correct(cardA);
            } else {
                GameFinished();
            }

        } else {
            Incorrect(cardA);
        }
    }

    public void OptonBClick(View view) {
        disableButton();
        button_next.setEnabled(true);
        if(modelclass.getOptionB().equals(modelclass.getAnswer())){
           cardB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index< ActivitySelection.listQ.size()-1){
                Correct(cardB);
            }
            else{
                GameFinished();
            }

        }else{
            Incorrect(cardB);
        }
    }

    public void OptonCClick(View view) {
        disableButton();
        button_next.setEnabled(true);
        if(modelclass.getOptionC().equals(modelclass.getAnswer())){
           cardC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index< ActivitySelection.listQ.size()-1){
                Correct(cardC);
            }
            else{
                GameFinished();
            }

        }else{
            Incorrect(cardC);
        }
    }

    public void OptonDClick(View view) {
        disableButton();
        button_next.setEnabled(true);
        if(modelclass.getOptionD().equals(modelclass.getAnswer())){
          cardD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index< ActivitySelection.listQ.size()-1){
                Correct(cardD);
            }
            else{
                GameFinished();
            }

        }else{
            Incorrect(cardD);
        }
    }
}
