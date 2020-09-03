package com.example.customview;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {
    private CustomViewe viewe;
    private float customX, customY;
    private float bigRadius = 340;
    private float centerX, centerY;
    private int trueFalse;
    private ConstraintLayout layout;
    private static final String SAPPEIS = "TAAAAG";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewe = findViewById(R.id.view1);
        layout = findViewById(R.id.constraint);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onResume() {
        super.onResume();

        if (trueFalse != 0) {
            viewe.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        centerX = CustomViewe.getRectF().centerX();
                        centerY = CustomViewe.getRectF().centerY();
                        customX = motionEvent.getX();
                        customY = motionEvent.getY();
                        if (Math.sqrt(Math.pow(Math.abs(customX) - centerX, 2) + (Math.pow(Math.abs(customY) - centerY, 2))) <= bigRadius) {
                            if (customX <= 540 && customY <= 800) {
                                if (trueFalse == 1) {
                                    Toast.makeText(MainActivity.this, "1ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (trueFalse == 2) {
                                    Snackbar.make(layout, "1ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomViewe.Invalidate(1, viewe);

                            }

                            if (customX >= 540 && customY <= 800) {
                                if (trueFalse == 1) {
                                    Toast.makeText(MainActivity.this, "2ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (trueFalse == 2) {
                                    Snackbar.make(layout, "2ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomViewe.Invalidate(2, viewe);
                            }

                            if (customX <= 540 && customY > 800) {
                                if (trueFalse == 1) {
                                    Toast.makeText(MainActivity.this, "3ий сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (trueFalse == 2) {
                                    Snackbar.make(layout, "3ий сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomViewe.Invalidate(3, viewe);
                            }

                            if (customX >= 540 && customY > 800) {
                                if (trueFalse == 1) {
                                    Toast.makeText(MainActivity.this, "4ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (trueFalse == 2) {
                                    Snackbar.make(layout, "4ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomViewe.Invalidate(4, viewe);
                            }

                            if (Math.sqrt(Math.pow(Math.abs(customX) - centerX, 2) + (Math.pow(Math.abs(customY) - centerY, 2))) <= CustomViewe.getSmallRadius()) {
                                if (trueFalse == 1) {
                                    Toast.makeText(MainActivity.this, "Маленький сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (trueFalse == 2) {
                                    Snackbar.make(layout, "Маленький сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomViewe.Invalidate(5, viewe);
                            }

                            return true;
                        }
                    }
                    return true;
                }
            });
        } else {
            Intent intent = new Intent(MainActivity.this, TrueFalse.class);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAPPEIS, trueFalse);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        trueFalse = savedInstanceState.getInt(SAPPEIS, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        trueFalse = data.getIntExtra("Tag", 0);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
