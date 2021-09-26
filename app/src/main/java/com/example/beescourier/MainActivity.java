package com.example.beescourier;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.beescourier.database.DBHelper;

public class MainActivity extends AppCompatActivity {
    EditText personName,personAddress,personPhone,pkgWeight,pkgW,pkgL,pkgH;
    RadioGroup radioGroup;
    RadioButton radioButton;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);


        personName = findViewById(R.id.personName);
        personAddress = findViewById(R.id.personAddress);
        personPhone = findViewById(R.id.personPhone);
        pkgWeight = findViewById(R.id.pkgWeight);
        pkgW = findViewById(R.id.pkgW);
        pkgL = findViewById(R.id.pkgL);
        pkgH = findViewById(R.id.pkgH);

    }
    public void saveUser(View view){

        String name = personName.getText().toString();
        String address = personAddress.getText().toString();
        String phone = personPhone.getText().toString();
        String weight = pkgWeight.getText().toString();
        String width = pkgW.getText().toString();
        String length = pkgL.getText().toString();
        String height = pkgH.getText().toString();
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        final String delivery = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();

        DBHelper dbHelper = new DBHelper(this);

        if(name.isEmpty()||address.isEmpty()||phone.isEmpty()||weight.isEmpty()||width.isEmpty()||length.isEmpty()||height.isEmpty()){
            Toast.makeText(MainActivity.this,  "Enter values", Toast.LENGTH_SHORT).show();

        }else {
            long inserted = dbHelper.addInfo(name, address, phone, weight, width, length, height, delivery);

            if (inserted>0){
                Toast.makeText(MainActivity.this,  "Ready to shipped Successfully ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MainActivity2.class));

            }else {
                Toast.makeText(MainActivity.this,  "Something went wrong", Toast.LENGTH_SHORT).show();

            }

        }

    }
}