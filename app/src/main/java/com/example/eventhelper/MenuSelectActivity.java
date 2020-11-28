package com.example.eventhelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuSelectActivity extends AppCompatActivity {

private ImageButton wesele_ImageButton;
private ImageButton chrzest_ImageButton;
private ImageButton urodziny_ImageButton;
private ImageButton spotkanie_ImageButton;
private ImageButton komunia_ImageButton;
private ImageButton wyloguj_ImageButton;

    public static final int WESELE_REQUEST = 1;
    public static final int KOMUNIA_REQUEST = 2;
    public static final int CHRZEST_REQUEST = 3;
    public static final int URODZINY_REQUEST = 4;
    public static final int SPOTKANIE_REQUEST = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.menu_select_activity);
        wesele_ImageButton = (ImageButton) findViewById(R.id.wesele);
        chrzest_ImageButton = (ImageButton) findViewById(R.id.list);
        urodziny_ImageButton = (ImageButton) findViewById(R.id.tort);
        spotkanie_ImageButton = (ImageButton) findViewById(R.id.prezent);
        komunia_ImageButton = (ImageButton) findViewById(R.id.komunia);
        wyloguj_ImageButton = (ImageButton) findViewById(R.id.wylog);


        wyloguj_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuSelectActivity.this,  LoginActivity.class);
                startActivity(intent);

            }
        });


       komunia_ImageButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                //System.out.println("komunia button");
                Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
                intent.putExtra(InformationActivity.EVENT_TYPE, KOMUNIA_REQUEST);
                System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
                startActivity(intent);
            }


        });
       wesele_ImageButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
                intent.putExtra(InformationActivity.EVENT_TYPE, WESELE_REQUEST);
                System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
                startActivity(intent);
            }
        });
       chrzest_ImageButton.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {
               Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
               intent.putExtra(InformationActivity.EVENT_TYPE, CHRZEST_REQUEST);
               System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
               startActivity(intent);
           }
       });
       urodziny_ImageButton.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {
               Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
               intent.putExtra(InformationActivity.EVENT_TYPE, URODZINY_REQUEST);
               System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
               startActivity(intent);


           }
       });
       spotkanie_ImageButton.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {
               Intent intent = new Intent(MenuSelectActivity.this, InformationActivity.class);
               intent.putExtra(InformationActivity.EVENT_TYPE, SPOTKANIE_REQUEST);
               System.out.println("W menu select intent: " + intent.getIntExtra(InformationActivity.EVENT_TYPE,1));
               startActivity(intent);
           }
       });



    }
}
