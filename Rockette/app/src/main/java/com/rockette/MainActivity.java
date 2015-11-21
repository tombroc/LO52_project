package com.rockette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity{

    private static final int ACTION_UP = 1;
    private static final int ACTION_DOWN = 0;
    public Button buttonL;
    public Button buttonR;
    public Button buttonU;
    public Button buttonD;
    public Button buttonF;
    public TextView txtzone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonL = (Button)findViewById(R.id.buttonL);
        buttonL.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View vw, MotionEvent event) {
                switch (event.getAction()) {
                    case ACTION_DOWN:
                        move_Left();

                        break;
                    case ACTION_UP:
                        Stop();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        buttonR = (Button)findViewById(R.id.buttonR);
        buttonR.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View vw, MotionEvent event) {
                switch (event.getAction()) {
                    case ACTION_DOWN:
                        move_Right();
                        break;
                    case ACTION_UP:
                        Stop();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        buttonU = (Button)findViewById(R.id.buttonU);
        buttonU.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View vw, MotionEvent event) {
                switch(event.getAction()){
                    case ACTION_DOWN:
                        move_Up();
                        break;
                    case ACTION_UP:
                        Stop();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        buttonD = (Button)findViewById(R.id.buttonD);
        buttonD.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View vw, MotionEvent event) {
                switch(event.getAction()){
                    case ACTION_DOWN:
                        move_Down();
                        break;
                    case ACTION_UP:
                        Stop();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        buttonF = (Button)findViewById(R.id.buttonF1);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtzone.setText("Fire 1");
                Fire(1);
            }
        });
        buttonF = (Button)findViewById(R.id.buttonF2);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtzone.setText("Fire 2");
                Fire(2);
            }
        });

        buttonF = (Button)findViewById(R.id.buttonF3);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtzone.setText("Fire 3");
                Fire(3);
            }
        });

        txtzone = (TextView)findViewById(R.id.textView);
    }

/*
    private static native void move_Up();
    private static native void move_Down();
    private static native void move_Right();
    private static native void move_Left();
    private static native void Stop();
    private static native void Fire(int num);

    static {
        System.loadLibrary("move_Up");
        System.loadLibrary("move_Down");
        System.loadLibrary("move_Right");
        System.loadLibrary("move_Left");
        System.loadLibrary("Fire");
    }
    */
    public void move_Up(){
        txtzone.setText("Start moving UP...");
    }

    public void move_Down(){
        txtzone.setText("Start moving DOWN...");
    }
    public void move_Right(){
        txtzone.setText("Start moving RIGHT...");
    }
    public void move_Left(){
        txtzone.setText("Start moving LEFT...");
    }
    public void Stop(){
        txtzone.append("\nStop moving");
    }
    public void Fire(int num){
        txtzone.setText(String.format("Fire missile %s", num));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
