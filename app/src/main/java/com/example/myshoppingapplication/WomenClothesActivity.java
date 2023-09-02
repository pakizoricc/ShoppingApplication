package com.example.myshoppingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class WomenClothesActivity extends AppCompatActivity {
    ViewFlipper flipper;
    Button prev_Button, next_Button;
    ImageView slika1, slika2, slika3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_clothes);

        flipper = findViewById(R.id.view_flipper);
        prev_Button = findViewById(R.id.prev_button);
        next_Button = findViewById(R.id.next_button);
        slika1 = findViewById(R.id.nikedrifitw);
        slika2 = findViewById(R.id.adidastrackpantsw);
        slika3 = findViewById(R.id.nikesportswearw);

        prev_Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // It is used to set the in and out
                        // animation of View flipper.
                        flipper.setInAnimation(WomenClothesActivity.this,
                                R.anim.slide_right);
                        flipper.setOutAnimation(WomenClothesActivity.this,
                                R.anim.slide_left);

                        // It shows previous item.
                        flipper.showPrevious();
                    }
                });

        next_Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // It is used to set the in and out
                        // animation of View flipper.
                        flipper.setInAnimation(WomenClothesActivity.this,
                                R.anim.slide_left);
                        flipper.setOutAnimation(WomenClothesActivity.this,
                                R.anim.slide_right);

                        // It shows next item.
                        flipper.showNext();
                    }
                });

        slika1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CartProductActivity.class);
                intent.putExtra("tekst", "Nike DRIFIT trenerka"); // Promenite ovde tekst za svaku sliku
                startActivity(intent);
            }
        });

        slika2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CartProductActivity.class);
                intent.putExtra("tekst", "Addidas trenerka"); // Promenite ovde tekst za svaku sliku
                startActivity(intent);
            }
        });

        slika3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CartProductActivity.class);
                intent.putExtra("tekst", "Nike Sportswear trenerka"); // Promenite ovde tekst za svaku sliku
                startActivity(intent);
            }
        });
    }
}
