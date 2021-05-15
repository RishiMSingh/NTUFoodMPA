package com.example.foodcollectionntu.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.foodcollectionntu.R;

public class UserPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        launchRegister();
        launchLogin();

    }

    private void launchRegister(){
        Button btn = (Button) findViewById(R.id.butRegister1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserPage.this, "Clicked on button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserPage.this, Register.class);
                startActivity(intent);

            }
        });
    }

    private void launchLogin(){
        Button btn = (Button) findViewById(R.id.buttonLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserPage.this, "Clicked on button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserPage.this, Login.class);
                startActivity(intent);

            }
        });
    }




}