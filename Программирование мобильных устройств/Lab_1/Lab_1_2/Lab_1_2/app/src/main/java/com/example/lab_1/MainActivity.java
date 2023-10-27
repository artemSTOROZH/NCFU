package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.os.Bundle;
import android.graphics.Path;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this.getBaseContext()));
        setTitle("Storozhenko_1");
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
            canvas.drawRect(180,200,530,550,p);
            p.setColor(Color.BLACK);
            p.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(230, 1100, 75, p);
            canvas.drawCircle(480, 1100, 75, p);
            p.setStyle(Paint.Style.FILL);
            canvas.drawCircle(230, 1100, 17, p);
            canvas.drawCircle(480, 1100, 17, p);

            canvas.drawCircle(355, 1100, 27, p);
            p.setStrokeWidth(5);
            canvas.drawLine(355,1100, 365, 1155, p);
            canvas.drawRoundRect(350, 1150, 380, 1160, 45, 45, p);
            canvas.drawLine(355,1100, 345, 1045, p);
            canvas.drawRoundRect(330, 1040, 360, 1050, 45, 45, p);
            p.setStrokeWidth(11);
            canvas.drawLine(230, 1100, 355, 1100, p);
            canvas.drawLine(230, 1100, 300, 1000, p);
            canvas.drawLine(355, 1100, 280, 970, p);
            canvas.drawLine(300, 1000, 430, 1000, p);
            canvas.drawLine(355, 1100, 430, 1000, p);
            canvas.drawLine(480, 1100, 425, 997, p);
            p.setStyle(Paint.Style.STROKE);
            Path arc_1 = new Path();
            arc_1.moveTo(425, 1000);
            arc_1.cubicTo(425, 1000, 430, 960, 455, 960);
            arc_1.cubicTo(480, 960, 480, 940, 450, 940);
            arc_1.lineTo(410, 940);
            p.setStrokeWidth(11);
            canvas.drawPath(arc_1, p);
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.FILL);
            Path seat = new Path();
            seat.moveTo(250, 960);
            seat.addArc(new RectF(300, 945, 320, 960), -90, 180);
            seat.lineTo(250, 990);
            seat.addArc(new RectF(235, 950, 260, 990), 75, 180);
            seat.lineTo(315, 945);
            canvas.drawPath(seat, p);
    }
    }
}