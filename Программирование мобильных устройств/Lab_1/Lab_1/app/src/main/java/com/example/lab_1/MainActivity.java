package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.os.Bundle;
import android.graphics.Path;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
        setTitle("ТестовоеНазвание");
    }
    class DrawView extends View{
        Paint p;
        Rect rect;
        public DrawView(Context context){
            super(context);
            p = new Paint();
            rect = new Rect();
        }
        @Override
        protected void onDraw(Canvas canvas){
            canvas.drawARGB(255,255,255,255);
            p.setStrokeWidth(10);
            p.setColor(Color.GREEN);
            canvas.drawRect(350,200,700,550,p);
            p.setColor(Color.BLACK);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(350, 1100, 75, p);
            p.setStrokeWidth(11);
            canvas.drawCircle(600, 1100, 75, p);
            p.setStyle(Paint.Style.FILL);
            canvas.drawCircle(350, 1100, 17, p);
            canvas.drawCircle(600, 1100, 17, p);
            p.setStrokeWidth(11);
            canvas.drawLine(350, 1100, 475, 1100, p);
            canvas.drawCircle(475, 1100, 27, p);
            p.setStrokeWidth(5);
            canvas.drawLine(475,1100, 485, 1155, p);
            canvas.drawRoundRect(470, 1150, 500, 1160, 45, 45, p);
            canvas.drawLine(475,1100, 465, 1045, p);
            canvas.drawRoundRect(450, 1040, 480, 1050, 45, 45, p);
            p.setStrokeWidth(11);
            canvas.drawLine(350, 1100, 420, 1000, p);
            canvas.drawLine(475, 1100, 400, 970, p);
            canvas.drawLine(420, 1000, 550, 1000, p);
            canvas.drawLine(475, 1100, 550, 1000, p);
            canvas.drawLine(600, 1100, 545, 997, p);
            p.setStyle(Paint.Style.STROKE);
            Path arc_1 = new Path();
            arc_1.moveTo(545, 1000);
            canvas.drawLine(530, 940, 575, 940, p);
            arc_1.cubicTo(545, 1000, 550, 960, 575, 960);
            arc_1.cubicTo(600, 960, 600, 940, 570, 940);
            arc_1.lineTo(530, 940);
            p.setStrokeWidth(11);
            canvas.drawPath(arc_1, p);
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.FILL);
            Path seat = new Path();
            seat.moveTo(370, 960);
            seat.addArc(new RectF(420, 945, 440, 960), -90, 180);
            seat.lineTo(370, 990);
            seat.addArc(new RectF(355, 950, 380, 990), 75, 180);
            seat.lineTo(435, 945);
            canvas.drawPath(seat, p);
    }
    }
}