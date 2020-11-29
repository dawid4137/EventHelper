package com.example.eventhelper;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    public FirebaseAuth mAuth;
    public Button zarejestruj_sie;
    public Button zaloguj;
    public EditText email_edittext;
    public EditText password_edittext;



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
        zaloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_edittext.getText().toString().trim();
                String pass = password_edittext.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    email_edittext.setError("Wprowadz e-mail");
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    password_edittext.setError("Wpisz ponownie hasło");
                    return;
                }
                if (pass.length() < 5) {
                    password_edittext.setError("Minimum 5 znakow");
                    return;
                }

                mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                   if(task.isSuccessful()){
                       Toast.makeText(LoginActivity.this, "Logowanie poprawne!", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(getApplicationContext(), MenuSelectActivity.class));
                   }
                   else {
                       Toast.makeText(LoginActivity.this, "Logowanie niepoprawne!", Toast.LENGTH_SHORT).show();
                   }


                    }
                });

            }




        });
    }
}






