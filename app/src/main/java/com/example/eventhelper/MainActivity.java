package com.example.eventhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button zaloguj;
    private Button zarejestruj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       zaloguj= (Button)  findViewById(R.id.buttom_zaloguj);
       findViewById(R.id.buttom_zaloguj).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,MenuSelectActivity.class));
           }
       });

        zarejestruj= (Button)  findViewById(R.id.buttom_zarejestruj_sie);
        findViewById(R.id.buttom_zarejestruj_sie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });

    }
}