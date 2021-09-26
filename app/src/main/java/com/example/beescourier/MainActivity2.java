package com.example.beescourier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.beescourier.Adapters.Adapter;
import com.example.beescourier.Helper.DatabaseHelper;
import com.example.beescourier.Table.Tables;

import java.util.Calendar;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    EditText editTextDate, editTextAddress;
    TextView textView9;
    DatabaseHelper helper;
    DatePickerDialog.OnDateSetListener setListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        helper = DatabaseHelper.getInstance(this);

        editTextDate = findViewById(R.id.editTextDate);
        editTextAddress = findViewById(R.id.editTextAddress);
        textView9 = findViewById(R.id.textView9);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog =  new DatePickerDialog(
                        MainActivity2.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                textView9.setText(date);
            }
        };

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        editTextDate.setText(date);


                    }
                },year,month,day);
                datePickerDialog.show();



            }
        });




    }


    public void pickSub (View view){
        if ( !editTextDate.getText().toString().isEmpty() && !editTextAddress.getText().toString().isEmpty())
            helper.addNewPickup(editTextDate.getText().toString(),editTextAddress.getText().toString());

    }

    public void showData(View view) {
        startActivity(new Intent(this, DatabaseView.class));
    }
}