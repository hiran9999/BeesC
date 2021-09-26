package com.example.beescourier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.DatabaseView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.beescourier.Helper.DatabaseHelper;
import com.example.beescourier.Table.Tables;

public class UpdateDataActivity extends AppCompatActivity {

    TextView order_no;
    EditText editTextDate,editTextAddress;
    Tables tables;

    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        helper = DatabaseHelper.getInstance(this);

        order_no = findViewById(R.id.order_no);
        editTextDate = findViewById(R.id.editTextDate);
        editTextAddress = findViewById(R.id.editTextAddress);

        if (getIntent() != null){
            tables = (Tables)getIntent().getSerializableExtra("pick_table");

            order_no.setText( "Order No" + tables.getId());
            editTextDate.setText(tables.getPick_date());
            editTextAddress.setText(tables.getPick_address());
        }
    }

    public void UpdateData(View view) {
        if (!editTextDate.getText().toString().isEmpty() && !editTextAddress.getText().toString().isEmpty())
            helper.updateData(tables,editTextDate.getText().toString(),editTextAddress.getText().toString());
    }

    public void showData(View view) {
        startActivity(new Intent(this,MainActivity3.class));
    }
}