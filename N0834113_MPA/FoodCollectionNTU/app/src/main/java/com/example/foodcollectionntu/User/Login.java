package com.example.foodcollectionntu.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodcollectionntu.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    private EditText log_email;
    private EditText log_password;
    private Button log_but;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        log_email = findViewById(R.id.l_email);
        log_password = findViewById(R.id.l_password);
        log_but = findViewById(R.id.log_btn);

        mAuth= FirebaseAuth.getInstance();

        log_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=log_email.getText().toString();
                String password=log_password.getText().toString();
                if(!email.isEmpty() && !password.isEmpty()){
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Login.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Login.this,Dashboard.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Login.this, ""+task.getException(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Login.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(Login.this, "Please fill empty field!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void registerPage(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }

}