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

public class MainActivity extends AppCompatActivity implements OnTouchListener{

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
        buttonL.setOnTouchListener(this);
        buttonR = (Button)findViewById(R.id.buttonR);
        buttonR.setOnTouchListener(this);
        buttonU = (Button)findViewById(R.id.buttonU);
        buttonU.setOnTouchListener(this);
        buttonD = (Button)findViewById(R.id.buttonD);
        buttonD.setOnTouchListener(this);
        buttonF = (Button)findViewById(R.id.buttonF);
        buttonF.setOnTouchListener(this);
        txtzone = (TextView)findViewById(R.id.textView);
    }


    private static native void move_Up();
    private static native void move_Down();
    private static native void move_Right();
    private static native void move_Left();
    private static native void Stop();
    private static native void Fire(int num);


    @Override
    public boolean onTouch(View vw, MotionEvent event){

        switch(vw.getId()){
           case R.id.buttonL:
                switch(event.getAction()){
                    case ACTION_DOWN:
                        move_Left();

                        break;
                    case ACTION_UP:
                        Stop();
                        break;
                    default:
                        break;
                }
                break;
            case R.id.buttonR:
                switch(event.getAction()){
                    case ACTION_DOWN:
                        move_Right();
                        break;
                    case ACTION_UP:
                        txtzone.append("\nStop moving right");
                        Stop();
                        break;
                    default:
                        break;
                }
                break;
            case R.id.buttonU:
                switch(event.getAction()){
                    case ACTION_DOWN:
                        move_Up();
                        break;
                    case ACTION_UP:
                        txtzone.append("\nStop moving up");
                        Stop();
                        break;
                    default:
                        break;
                }
                break;
            case R.id.buttonD:
                switch(event.getAction()){
                    case ACTION_DOWN:
                        move_Down();
                        break;
                    case ACTION_UP:
                        txtzone.append("\nStop moving down");
                        Stop();
                        break;
                    default:
                        break;
                }
                break;

            case R.id.buttonF1:
                txtzone.setText("Fire 1");
                Fire(1);
                break;

            case R.id.buttonF2:
                txtzone.setText("Fire 2");
                Fire(2);
                break;

            case R.id.buttonF3:
                txtzone.setText("Fire 3");
                Fire(3);
                break;
            default:
                break;
        }
        return true;
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
