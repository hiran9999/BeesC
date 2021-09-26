package com.example.beescourier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.beescourier.Adapters.Adapter;
import com.example.beescourier.Helper.DatabaseHelper;
import com.example.beescourier.Table.Tables;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView recycler_view;
    Adapter adapter;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        helper = DatabaseHelper.getInstance(this);

        recycler_view = findViewById(R.id.recycler_view);
        helper.getAllPickupsData();
    }

    public void setRecyclerView(List<Tables> tablesList) {
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, tablesList);
        recycler_view.setAdapter(adapter);
    }
}