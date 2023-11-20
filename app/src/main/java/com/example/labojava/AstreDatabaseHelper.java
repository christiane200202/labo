package com.example.labojava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AstreDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private SQLiteDatabase db;


    public AstreDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Créer la table pour les astres
        String createTableQuery = "CREATE TABLE astres (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nom TEXT," +
                "type TEXT," +
                "distance TEXT," +
                "diametre TEXT)";
        db.execSQL(createTableQuery);
    }

    public void insertAstre(String nom, String type, String distance, String diametre) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nom", nom);
        values.put("type", type);
        values.put("distance", distance);
        values.put("diametre", diametre);


        db.insert("astres", null, values);


        db.close();
    }
    public void seedAstresDatabase() {
        insertAstre("Soleil", "Étoile", "0", "1391000");
        insertAstre("Mercure", "Planète", "57.9 million km", "4");
        insertAstre("Vénus", "Planète", "108.2 million km", "1");
        insertAstre("Terre", "Planète", "149.6 million km", "1");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void Open()
    {
        this.db = this.getWritableDatabase();
    }
    public ArrayList<AstreCeleste> getAllAstres() {

        ArrayList<AstreCeleste> lstastres = new ArrayList<AstreCeleste>();


        Cursor cursor = db.query("astres", null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex("_id");
                int nomIndex = cursor.getColumnIndex("nom");
                int typeIndex = cursor.getColumnIndex("type");
                int distanceIndex = cursor.getColumnIndex("distance");
                int diametreIndex = cursor.getColumnIndex("diametre");
                int id = cursor.getInt(idIndex);
                String nom = cursor.getString(nomIndex);
                String type = cursor.getString(typeIndex);
                String distance = cursor.getString(distanceIndex);
                String diametre = cursor.getString(diametreIndex);

                AstreCeleste astre = new AstreCeleste(id, nom, type, distance, diametre);
                lstastres.add(astre);
            } while (cursor.moveToNext());

            cursor.close();
        }

        db.close();
        return lstastres;
    }
}

