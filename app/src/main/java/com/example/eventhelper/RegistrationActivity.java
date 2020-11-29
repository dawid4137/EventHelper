package com.example.eventhelper;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegistrationActivity extends AppCompatActivity {

    public static final String TAG ="TAG";
    public EditText imie;
    public Button ukoncz_rejestracje;
    public EditText email_edittext;
    public EditText password_edittext;
    public EditText confirm_password_editext;


    public FirebaseAuth fAuth;
    public FirebaseFirestore fStore;

    String UserID;

    public FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ukoncz_rejestracje = (Button) findViewById(R.id.buttom_rejestracja);
        email_edittext = (EditText) findViewById(R.id.mailmail);
        imie = (EditText) findViewById(R.id.imie_space);
        confirm_password_editext = (EditText) findViewById(R.id.confirmm_pass);
        password_edittext = (EditText) findViewById(R.id.pass_first);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

      // if(fAuth.getCurrentUser()!= null)
     //  {
     //      startActivity(new Intent(getApplicationContext(), LoginActivity.class));
     //      finish();
     //   }
        ukoncz_rejestracje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String name = imie.getText().toString();
                String confirm_password = confirm_password_editext.getText().toString().trim();
                String email = email_edittext.getText().toString().trim();
                String pass = password_edittext.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    imie.setError("Wprowadź imię");
                    return;
                }
                if (TextUtils.isEmpty(confirm_password)) {
                    confirm_password_editext.setError("Wprowadź haslo");
                    return;
                }
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

                if(!pass.equals(confirm_password)) {
                    confirm_password_editext.setError("Hasła różnią się");
                    return;
                }


                fAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "Rejestracja poprawna!", Toast.LENGTH_SHORT).show();
                            UserID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(UserID);
                            Map<String,Object> user = new HashMap<>();
                            user.put("name",name);
                            user.put("email",email);
                            user.put("password",pass);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG","Poprawnie zalogowano" + UserID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"Coś poszło nie tak.." +e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), MenuSelectActivity.class));
                        } else {
                            Toast.makeText(RegistrationActivity.this, "Wprowadz poprawne dane!" , Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });



    }
}





