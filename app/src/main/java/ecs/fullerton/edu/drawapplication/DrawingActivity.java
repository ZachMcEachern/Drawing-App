package ecs.fullerton.edu.drawapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class DrawingActivity extends AppCompatActivity implements View.OnTouchListener {

    private static final String TAG = "DrawingActivity";

    private DrawingView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        myView = (DrawingView)findViewById(R.id.drawing_view);
        myView.setOnTouchListener(this);
        myView.setFgColor(R.color.green);
        myView.setbgColor(R.color.blue);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_drawing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.blue:
                myView.setFgColor(R.color.blue);
                return true;
            case R.id.green:
                myView.setFgColor(R.color.green);
                return true;
            case R.id.red:
                myView.setFgColor(R.color.red);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //Log.d(TAG, motionEvent.toString());

        float x = motionEvent.getX();
        float y = motionEvent.getY();

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_MOVE:
                myView.addPoint(x, y);
                myView.invalidate();
                break;
        }

        return true;
    }
}
