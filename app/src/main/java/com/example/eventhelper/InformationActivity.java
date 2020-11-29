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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InformationActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Button czas_Buttton;
    private Button miejsce_Buttton;
    private Button zatwierdz_Buttton;
    private TextView tytul_TextView;


    public static final String EVENT_TYPE = "com.example.eventhelper.EVENT_TYPE";

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_activity);
        czas_Buttton = (Button) findViewById(R.id.button_czas);
        miejsce_Buttton = (Button) findViewById(R.id.button_miejsce);
        zatwierdz_Buttton = (Button) findViewById(R.id.button_zapisz);
        tytul_TextView = (TextView) findViewById(R.id.myDate);


        Intent intent = getIntent();

        //System.out.println("W iInformationActivity: " + intent.getIntExtra(EVENT_TYPE, 0));

        switch(intent.getIntExtra(EVENT_TYPE, 0)) {
            case 1: {
                tytul_TextView.setText("Ustal szczególy " + "wesela");
                findViewById(R.id.button_zapisz).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(InformationActivity.this,WeseleActivity.class);
                        startActivity(intent);
                    }

                });
                break;
            }
            case 2: {
                tytul_TextView.setText("Ustal szczególy " + "komunii");

                findViewById(R.id.button_zapisz).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(InformationActivity.this,KomuniaActivity.class);
                        startActivity(intent);
                    }

                });
                break;
            }
            case 3: {
                tytul_TextView.setText("Ustal szczególy chrztu");
                findViewById(R.id.button_zapisz).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(InformationActivity.this, ChrzestActivity.class);
                        startActivity(intent);
                    }
                    });
                break;
            }
            case 4: {
                tytul_TextView.setText("Ustal szczególy " + "urodzin");

                findViewById(R.id.button_zapisz).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(InformationActivity.this, UrodzinyActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            }
            case 5: {
                tytul_TextView.setText("Ustal szczególy " + "spotkania");
                findViewById(R.id.button_zapisz).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(InformationActivity.this, SpotkanieActivity.class);
                        startActivity(intent);
                    }
                });
                break;
            }
            default: {
                tytul_TextView.setText("cos poszlo nie tak");
                break;
            }

        }


        findViewById(R.id.button_czas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDailog();

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


