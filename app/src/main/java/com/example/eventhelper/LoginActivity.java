package com.example.eventhelper;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    public FirebaseAuth mAuth;
    public Button zarejestruj_sie;
    public Button zaloguj;
    public EditText email_edittext;
    public EditText password_edittext;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mAuth = FirebaseAuth.getInstance();

        zarejestruj_sie = (Button) findViewById(R.id.buttom_zarejestruj_sie);
        zaloguj = (Button) findViewById(R.id.buttom_zaloguj);
        email_edittext = (EditText) findViewById(R.id.mailmail);
        password_edittext = (EditText) findViewById(R.id.pass_first);

        zarejestruj_sie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}






