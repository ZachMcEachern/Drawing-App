package ecs.fullerton.edu.drawapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by zachm on 9/26/2017.
 */

public class DrawingView extends View {

    private int bgColor;

    public void setFgColor(int fgColor) {
        int drawingColor = ContextCompat.getColor(this.getContext(), fgColor);
        foreground.setColor(drawingColor);
    }

    public void setbgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    private Paint foreground;
    private ArrayList<Float> xs;
    private ArrayList<Float> ys;

    public void addPoint(float x, float y){
        this.xs.add(x);
        this.ys.add(y);
    }

    public DrawingView(Context context) {
        this(context, null);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        xs = new ArrayList<Float>();
        ys = new ArrayList<Float>();

        bgColor = R.color.colorPrimaryDark;

        foreground = new Paint();
    }

    private float dpToPixels(int dp) {
        return dp * getResources().getDisplayMetrics().density * 1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int drawingColor = ContextCompat.getColor(getContext(), bgColor);
        canvas.drawColor(drawingColor);

        for (int i = 0; i < xs.size(); i++) {
            canvas.drawCircle(xs.get(i), ys.get(i), dpToPixels(10), foreground);
        }
    }
}
