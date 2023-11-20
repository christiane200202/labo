package com.example.labojava;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlienSolarSystem extends View {

    private List<AstreCeleste> astres;
    private AstreAdapter astreAdapter;

    public AlienSolarSystem(Context context) {
        super(context);
        astres = new ArrayList<>();
        astreAdapter = new AstreAdapter(getContext(), R.layout.astres, astres);
    }

    public AlienSolarSystem(Context context, AttributeSet attrs) {
        super(context, attrs);
        astres = new ArrayList<>();
        astreAdapter = new AstreAdapter(getContext(), R.layout.astres, astres);
    }

    public AlienSolarSystem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        astres = new ArrayList<>();
        astreAdapter = new AstreAdapter(getContext(), R.layout.astres, astres);
    }

    public void setAstres(List<AstreCeleste> astres) {
        if (astres == null) {
            // Handle null input if needed
            return;
        }

        this.astres = new ArrayList<>(astres);
        if (astreAdapter != null) {
            astreAdapter.clear();
            astreAdapter.addAll(this.astres);
        }
        invalidate(); // Force the view to redraw
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Use the list of astres to draw them at random positions
        Random random = new Random();
        Paint paint = new Paint();

        for (AstreCeleste astre : astres) {
            float x = random.nextFloat() * canvas.getWidth();
            float y = random.nextFloat() * canvas.getHeight();
            paint.setColor(getAstreColor(astre));
            drawAstre(canvas, astre, x, y, paint);
        }
    }

    private void drawAstre(Canvas canvas, AstreCeleste astre, float x, float y, Paint paint) {
        float diametre = Float.parseFloat(astre.getDiametre());
        canvas.drawCircle(x, y, diametre, paint);
    }

    private int getAstreColor(AstreCeleste astre) {
        int color;

        switch (astre.getNom()) {
            case "Soleil":
                color = Color.YELLOW;
                break;
            case "Mercure":
                color = Color.GRAY;
                break;
            case "Venus":
                color = Color.parseColor("#FFD700"); // Gold
                break;
            case "Terre":
                color = Color.BLUE;
                break;
            default:
                color = Color.LTGRAY;
                break;
        }

        return color;
    }
}
