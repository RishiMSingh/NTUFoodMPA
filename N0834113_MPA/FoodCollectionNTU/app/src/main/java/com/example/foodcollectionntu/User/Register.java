package com.example.foodcollectionntu.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodcollectionntu.R;
import com.example.foodcollectionntu.helperClass.dashboardAdapter.UserRegistrationHelperClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {


    private EditText loginName;
    private EditText loginEmail;
    private EditText loginPassword;
    private EditText loginSurname;
    private EditText loginConfPassword;

    private Button mRegBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginName = findViewById(R.id.r_name);
        loginSurname = findViewById(R.id.r_surname);
        loginEmail = findViewById(R.id.r_email);

        loginPassword = findViewById(R.id.r_password);
        mRegBtn = findViewById(R.id.log_btn);
        mAuth = FirebaseAuth.getInstance();

        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = loginName.getText().toString();
                String surname = loginSurname.getText().toString();
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();
                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !surname.isEmpty()) {
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Account successfully created", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, Dashboard.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Register.this, "Password is too short", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(Register.this, "Please fill empty field", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signIn(View view) {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }
}