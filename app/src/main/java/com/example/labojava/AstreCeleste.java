package com.example.labojava;

import android.graphics.Color;

public class AstreCeleste {
    private long id;
    private String nom;
    private String type;
    private String distance;
    private String diametre;
    private float x = 0;  // Initialisation de x
    private float y = 0;

    public AstreCeleste(int id, String nom, String type, String distance, String diametre) {
        this.id=id;
        this.nom=nom;
        this.type=type;
        this.distance=distance;
        this.diametre=diametre;

    }

    public String getNom(){return nom;}
    public String getType(){return type;}

    public String getDistance(){return distance;}

    public String getDiametre(){return diametre;}
    public void setNom(String nom){this.nom=nom;}

    public void setType(String type){this.type=type;}

    public void setDistance(String distance){this.distance=distance;}

    public void setDiametre(String diametre){this.diametre=diametre;}


    public void setId(long id) {this.id=id;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getAstreColor() {
        // Add your logic to determine the color based on astre properties
        if ("Étoile".equals(type)) {
            return Color.YELLOW;
        } else if ("Planète".equals(type)) {
            return Color.BLUE;
        } else {
            return Color.GRAY;
        }
    }
}
