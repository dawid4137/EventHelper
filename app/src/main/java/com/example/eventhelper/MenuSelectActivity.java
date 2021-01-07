package com.example.eventhelper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MenuSelectActivity extends AppCompatActivity  {

private ImageButton wesele_ImageButton;
private ImageButton chrzest_ImageButton;
private ImageButton urodziny_ImageButton;
private ImageButton spotkanie_ImageButton;
private ImageButton komunia_ImageButton;

public TextView zaproszenie;

    public FirebaseAuth mAuth;
    public FirebaseFirestore mFire;
    public static final int WESELE_REQUEST = 1;
    public static final int KOMUNIA_REQUEST = 2;
    public static final int CHRZEST_REQUEST = 3;
    public static final int URODZINY_REQUEST = 4;
    public static final int SPOTKANIE_REQUEST = 5;
    public String userId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mFire=FirebaseFirestore.getInstance();

      // zaproszenie = findViewById(R.id.invitation);
        setContentView(R.layout.menu_select_activity);
        zaproszenie =(TextView) findViewById(R.id.invitation);
        wesele_ImageButton = (ImageButton) findViewById(R.id.wesele);
        chrzest_ImageButton = (ImageButton) findViewById(R.id.chrzest);
        urodziny_ImageButton = (ImageButton) findViewById(R.id.urodziny);
        spotkanie_ImageButton = (ImageButton) findViewById(R.id.spotkanie);
        komunia_ImageButton = (ImageButton) findViewById(R.id.komunia);


       userId= mAuth.getUid();
       DocumentReference documentReference = mFire.collection("users").document(userId);

       documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
           public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
               if(documentSnapshot.exists()){
                    zaproszenie.setText("Witaj "+documentSnapshot.getString("name" )+"!");

             }else {
                   Log.d("tag", "onEvent: Document do not exists");
               }
           }
        });


             //   zaproszenie.setText(userId + "!" + "Twoje zdarzenie to....");

       komunia_ImageButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                //System.out.println("komunia button");
                Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
                intent.putExtra(InformationActivity.EVENT_TYPE, KOMUNIA_REQUEST);
                //System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
                startActivity(intent);
            }


        });
       wesele_ImageButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
                intent.putExtra(InformationActivity.EVENT_TYPE, WESELE_REQUEST);

               // System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
                startActivity(intent);
            }
        });
       chrzest_ImageButton.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {
               Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
               intent.putExtra(InformationActivity.EVENT_TYPE, CHRZEST_REQUEST);
             //  System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
               startActivity(intent);
           }
       });
       urodziny_ImageButton.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {
               Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
               intent.putExtra(InformationActivity.EVENT_TYPE, URODZINY_REQUEST);
             //  System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
               startActivity(intent);


           }
       });
       spotkanie_ImageButton.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {
               Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
               intent.putExtra(InformationActivity.EVENT_TYPE, SPOTKANIE_REQUEST);
              // System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
               startActivity(intent);

             //  zaproszenie.setText("Witaj"+ "!" + getText(imie)"Twoje zdarzenie to...");
           }
       });


    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }
}
