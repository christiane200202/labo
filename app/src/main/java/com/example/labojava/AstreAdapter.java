package com.example.labojava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AstreAdapter extends ArrayAdapter<AstreCeleste> {
    private Context ctx;
    private ArrayList<AstreCeleste> listAstres;
    private int res;

    public AstreAdapter(@NonNull Context context, int resource, @NonNull List<AstreCeleste> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.res = resource;
        this.listAstres = new ArrayList<>();
        this.listAstres.addAll(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AstreCeleste astre = this.listAstres.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(this.ctx);
        convertView = layoutInflater.inflate(this.res, parent, false);

        TextView nomTextView = convertView.findViewById(R.id.nomTextView);
        TextView typeTextView = convertView.findViewById(R.id.typeTextView);
        TextView distanceTextView = convertView.findViewById(R.id.distanceTextView);
        TextView diametreTextView = convertView.findViewById(R.id.diametreTextView);

        // You can add more widgets here based on the attributes of AstreCeleste

        // Set values based on AstreCeleste properties
        nomTextView.setText("Nom: " + astre.getNom());
        typeTextView.setText("Type: " + astre.getType());
        distanceTextView.setText("Distance: " + astre.getDistance());
        diametreTextView.setText("Diamètre: " + astre.getDiametre());

        return convertView;
    }
}
