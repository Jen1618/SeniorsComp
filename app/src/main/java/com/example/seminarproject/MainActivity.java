package com.example.seminarproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private Button button_next;
    private EditText editText_email;
    private EditText editText_password;
    private Button button_login;
    private String email;
    private String password;
    private ImageView start;

    private FirebaseAuth mAuth;
    private FirebaseDatabase db;
    private DatabaseReference refer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.imageView_start);
        Picasso.get().load("https://observer.com/wp-content/uploads/sites/2/2021/05/summer-movies-2021-new-e1620919489437.jpg?quality=80").into(start);
        button_next = findViewById(R.id.button_next);
        button_login = findViewById(R.id.button_login);
        editText_email = findViewById(R.id.editText_emailAddress);
        editText_email.setHint("Email");
        editText_password = findViewById(R.id.editText_password);
        editText_password.setHint("Password");

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        db = FirebaseDatabase.getInstance();
        refer = db.getReference();

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editText_email.getText().toString().trim();
                password = editText_password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    editText_email.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    editText_password.setError("Password is required");
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            refer.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    String uid = user.getUid();
                                    refer.child(uid).child("Email").setValue(email);
                                }
                            });
                            Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            launchNextActivity(v);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Incorrect Credentials, try again", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }
        });
    }

        public void launchNextActivity(View v){
            Intent intent = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent);
        }
}