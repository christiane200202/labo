package com.example.labojava;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AlienSolarSystem alienSolarSystem;
    private AstreDatabaseHelper myDb;
    private TextView lblnom, lbltype, lbldistance, lbldiametre;
    private Context ctx;
    private AstreAdapter adapter;
    private ArrayList<AstreCeleste> als;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ctx = this;

        alienSolarSystem = findViewById(R.id.alienSolarSystem);
        lblnom = findViewById(R.id.nomTextView);
        lbldiametre = findViewById(R.id.diametreTextView);
        lbldistance = findViewById(R.id.distanceTextView);
        lbltype = findViewById(R.id.typeTextView);

        this.myDb = new AstreDatabaseHelper(this, "AstreDb", null, 1);
        this.myDb.Open();

        this.als = new ArrayList<>();
        this.als = this.myDb.getAllAstres();
        if (this.als.size() < 1) {
            this.myDb.seedAstresDatabase();
        }

        alienSolarSystem.setAstres(this.als); // Set the astres list to the AlienSolarSystem view

        this.adapter = new AstreAdapter(this, R.layout.astres, this.als);
        // Use the adapter if needed for the ListView

        this.myDb.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
