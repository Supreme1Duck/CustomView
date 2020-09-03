package com.example.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.google.android.material.snackbar.Snackbar;

public class CustomView extends View {
    private static int[] colors = new int[]{Color.GRAY, Color.GREEN, Color.RED, Color.YELLOW, Color.BLACK, Color.BLUE, Color.WHITE, Color.CYAN};
    private Paint p1, p2, p3, p4, psmall;
    private RectF rectF;
    private float customX, customY;
    private float radius = 340;
    private int centerX, centerY;

    public CustomView(Context context) {
        super(context);
        p1 = new Paint();
        p2 = new Paint();
        p3 = new Paint();
        p4 = new Paint();
        psmall = new Paint();
    }

    @SuppressLint("ClickableViewAccessibility")
    public CustomView(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        p1 = new Paint();
        p2 = new Paint();
        p3 = new Paint();
        p4 = new Paint();
        psmall = new Paint();

        p1.setColor(Color.RED);
        p2.setColor(Color.GREEN);
        p3.setColor(Color.BLUE);
        p4.setColor(Color.WHITE);
        psmall.setColor(Color.YELLOW);
        rectF = new RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius);

        this.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        centerX = (int) CustomView.this.getRectF().centerX();
                        centerY = (int) CustomView.this.getRectF().centerY();
                        customX = motionEvent.getX();
                        customY = motionEvent.getY();
                        if (Math.sqrt(Math.pow(Math.abs(customX) - centerX, 2) + (Math.pow(Math.abs(customY) - centerY, 2))) <= radius) {
                            if (customX <= 540 && customY <= 800) {
                                if (MainActivity.gettrueFalse() == 1) {
                                    Toast.makeText(getContext(), "1ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (MainActivity.gettrueFalse() == 2) {
                                    Snackbar.make(view, "1ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomView.this.Invalidate(1, CustomView.this);

                            }

                            if (customX >= 540 && customY <= 800) {
                                if (MainActivity.gettrueFalse() == 1) {
                                    Toast.makeText(getContext(), "2ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (MainActivity.gettrueFalse() == 2) {
                                    Snackbar.make(view, "2ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomView.this.Invalidate(2, CustomView.this);
                            }

                            if (customX <= 540 && customY > 800) {
                                if (MainActivity.gettrueFalse() == 1) {
                                    Toast.makeText(getContext(), "3ий сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (MainActivity.gettrueFalse() == 2) {
                                    Snackbar.make(view, "3ий сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomView.this.Invalidate(3, CustomView.this);
                            }

                            if (customX >= 540 && customY > 800) {
                                if (MainActivity.gettrueFalse() == 1) {
                                    Toast.makeText(getContext(), "4ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (MainActivity.gettrueFalse() == 2) {
                                    Snackbar.make(view, "4ый сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomView.this.Invalidate(4, CustomView.this);
                            }

                            if (Math.sqrt(Math.pow(Math.abs(customX) - centerX, 2) + (Math.pow(Math.abs(customY) - centerY, 2))) <= getSmallRadius()) {
                                if (MainActivity.gettrueFalse() == 1) {
                                    Toast.makeText(getContext(), "Маленький сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(),
                                            Toast.LENGTH_SHORT).show();
                                }
                                if (MainActivity.gettrueFalse() == 2) {
                                    Snackbar.make(view, "Маленький сектор\n " + "X = " + motionEvent.getX() + "Y = " + motionEvent.getY(), Snackbar.LENGTH_SHORT).show();
                                }
                                view.performClick();
                                CustomView.this.Invalidate(5, CustomView.this);
                            }
                            return true;
                        }
                    }
                return true;
            }
        });
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static int getSmallRadius() {
        return 100;
    }

    private static int Randomize() {
        return (int) (Math.random() * colors.length);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(parentWidth, parentHeight);
        centerX = parentWidth / 2;
        centerY = parentHeight / 2;
        rectF = new RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
    }

    protected void onDraw(Canvas canvas) {

        canvas.drawArc(rectF, 180, 90, true, p1);
        canvas.drawArc(rectF, 0, 90, true, p4);
        canvas.drawArc(rectF, 90, 90, true, p3);
        canvas.drawArc(rectF, 270, 90, true, p2);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), 100, psmall);
    }

    public RectF getRectF() {
        return rectF;
    }

    private void SetColor(int Place) {

        switch (Place) {
            case 1:
                p1.setColor(colors[Randomize()]);

                break;

            case 2:
                p2.setColor(colors[Randomize()]);

                break;

            case 3:
                p3.setColor(colors[Randomize()]);

                break;

            case 4:
                p4.setColor(colors[Randomize()]);

                break;

            case 5:
                p1.setColor(colors[Randomize()]);
                p2.setColor(colors[Randomize()]);
                p3.setColor(colors[Randomize()]);
                p4.setColor(colors[Randomize()]);
                psmall.setColor(colors[Randomize()]);

                break;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
    }

    public void Invalidate(int Place, @org.jetbrains.annotations.NotNull CustomView view) {
        SetColor(Place);
        view.invalidate();
    }

}
