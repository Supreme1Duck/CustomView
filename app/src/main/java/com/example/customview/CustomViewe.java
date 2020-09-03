package com.example.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import android.util.AttributeSet;

import android.view.View;

import androidx.annotation.Nullable;

public class CustomViewe extends View{
    private static Paint p1,p2,p3,p4, psmall;
    private static RectF rectF;
    private static float radius = 340;
    int CenterX, CenterY;
    int parentHeight, parentWidth;
    private static int[] colors = new int[]{Color.GRAY, Color.GREEN, Color.RED, Color.YELLOW, Color.BLACK, Color.BLUE, Color.WHITE
    , Color.CYAN};


    public CustomViewe(Context context) {
        super(context);
        p1 = new Paint();
        p2 = new Paint();
        p3 = new Paint();
        p4 = new Paint();
        psmall = new Paint();


    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(parentWidth,parentHeight);
        CenterX = parentWidth/2;
        CenterY = parentHeight/2;
        rectF = new RectF(CenterX-radius, CenterY-radius, CenterX+radius, CenterY+radius);
    }

    public CustomViewe(Context context, @Nullable AttributeSet attrs) {
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



        rectF = new RectF(CenterX-radius, CenterY-radius, CenterX+radius, CenterY+radius);

    }

    public CustomViewe(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onDraw(Canvas canvas) {

        canvas.drawArc(rectF, 180, 90, true, p1);
        canvas.drawArc(rectF, 0, 90, true, p4);
        canvas.drawArc(rectF, 90, 90, true, p3);
        canvas.drawArc(rectF, 270, 90, true, p2);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), 100, psmall);
    }

    public static RectF getRectF() {
        return rectF;
    }

    private static void SetColor(int Place){

        switch (Place){
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
                psmall.setColor((int) (Math.random() * colors.length));

                break;

            case 6:

                break;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        CenterX = w/2;
        CenterY = h/2;
    }

    public static void Invalidate(int Place, @org.jetbrains.annotations.NotNull CustomViewe viewe){
        SetColor(Place);
        viewe.invalidate();
    }

    public static int getSmallRadius(){
        return 100;
    }

    private static int Randomize(){
        return (int)(Math.random() * colors.length);
    }

}
