package com.example.storozhenko_red_rect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.graphics.Path;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this.getBaseContext()));
    }
    class DrawView extends View {
        Paint p;
        Rect rect;

        public DrawView(Context context) {
            super(context);
            p = new Paint();
            rect = new Rect();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80,102, 104, 255);
            p.setColor(Color.RED);
            canvas.drawRect(200, 105, 400, 200, p);
            canvas.drawCircle(100, 200, 50, p);
            p.setStrokeWidth(10);
            float[] points = new float[]{300, 300, 400, 300};
            canvas.drawLines(points, p);
            Path path = new Path();
            path.moveTo(50,50);
            path.lineTo(0, 100);
            path.lineTo(100, 100);
            path.lineTo(50, 50);
            canvas.drawPath(path, p);
            Path arc_1 = new Path();
            arc_1.addArc(new RectF(0,250,100,350), 0, 180);
            canvas.drawPath(arc_1, p);
            Path arc_2 = new Path();
            arc_2.addArc(new RectF(150,250,250,350), 90, 180);
            canvas.drawPath(arc_2, p);
        }
    }
}