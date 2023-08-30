package com.example.myshoppingapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class WomenClothesActivity extends AppCompatActivity {
    ViewFlipper flipper;
    Button prev_Button, next_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_clothes);

        flipper = findViewById(R.id.view_flipper);
        prev_Button = findViewById(R.id.prev_button);
        next_Button = findViewById(R.id.next_button);

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
    }
}
