package com.example.eventhelper;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WeseleActivity extends AppCompatActivity {

    private ImageButton listaButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.wedding_activity);

        listaButton =(ImageButton) findViewById(R.id.lista_buttonn);


        listaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent_lista = new Intent(WeseleActivity.this,GuestListActivity.class);
                 startActivity(intent_lista);

            }
        });
    }

}
