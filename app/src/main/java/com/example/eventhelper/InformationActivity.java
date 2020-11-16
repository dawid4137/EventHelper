package com.example.eventhelper;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Button czas_Buttton;
    private Button miejsce_Buttton;
    private Button zatwierdz_Buttton;



    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_activity);
        czas_Buttton = (Button) findViewById(R.id.button_czas);
        miejsce_Buttton = (Button) findViewById(R.id.button_miejsce);
        zatwierdz_Buttton = (Button) findViewById(R.id.button_zapisz);

        findViewById(R.id.button_czas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDailog();

            }
        });
        findViewById(R.id.button_zapisz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InformationActivity.this,WeseleActivity.class));
            }
        });

        miejsce_Buttton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(InformationActivity.this);
                 View mView = getLayoutInflater().inflate(R.layout.dialog_spinner,null);
                 mBuilder.setTitle("MIASTO");
                 Spinner mSpinner = (Spinner) mView.findViewById(R.id.spinner1);
                ArrayAdapter <String> adapter = new ArrayAdapter<String>(InformationActivity.this,
                        android.R.layout.simple_spinner_item,
                        getResources().getStringArray(R.array.townlist));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mSpinner.setAdapter(adapter);
                mBuilder.setPositiveButton( "ok",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //if (!mSpinner.getSelectedItem().toString().equalsIgnoreCase("Wybierz miasto"))
                        {
                           Toast.makeText(InformationActivity.this, mSpinner.getSelectedItem().toString(),
                                   Toast.LENGTH_SHORT)
                                   .show();
                            dialogInterface.dismiss();

                        }
                    }

                });
                mBuilder.setNegativeButton("WROC", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog =  mBuilder.create();
                dialog.show();
            }
        });
    }


    public void showDatePickerDailog() {
        DatePickerDialog datePickerDailog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDailog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String date = "month/day/year: " + month + "/" + dayOfMonth + "/" + year;

        ;

    }


}


