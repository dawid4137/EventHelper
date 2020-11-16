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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_select_activity);
        wesele_ImageButton = (ImageButton) findViewById(R.id.wesele);
        chrzest_ImageButton = (ImageButton) findViewById(R.id.chrzest);
        urodziny_ImageButton = (ImageButton) findViewById(R.id.urodziny);
        spotkanie_ImageButton = (ImageButton) findViewById(R.id.spotkanie);
        komunia_ImageButton = (ImageButton) findViewById(R.id.komunia);


       komunia_ImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuSelectActivity.this,InformationActivity.class));
            }


        });
       wesele_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuSelectActivity.this,InformationActivity.class));
            }
        });
       chrzest_ImageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MenuSelectActivity.this,InformationActivity.class));
           }
       });
       urodziny_ImageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MenuSelectActivity.this,InformationActivity.class));

           }
       });
       spotkanie_ImageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MenuSelectActivity.this, InformationActivity.class));
           }
       });



    }
}
