package fr.utbm.lo52tp.rocketlauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        //System.loadLibrary("libJNIRocket");
        System.loadLibrary("JNIRocket");
    }

    private static native void moveUp();
    private static native void moveDown();
    private static native void moveRight();
    private static native void moveLeft();
    private static native void Stop();
    private static native void Fire();
    private static native void InitUSB();
    private static native void FreeUSB();
    private static native int testFunction();

    private static final int ACTION_UP = 1;
    private static final int ACTION_DOWN = 0;
    public Button buttonL;
    public Button buttonR;
    public Button buttonU;
    public Button buttonD;
    public Button buttonF;
    public TextView txtzone;

    private boolean fireTest = true;

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

//        Log.d("message","CALL TO native method: ");
//        int i = testFunction();
//        Log.d("message",""+i);

        Log.d("debug","InitUSB");
        InitUSB();
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first
        Log.d("debug", "FreeUSB");
        FreeUSB();
        Log.d("debug", "FreeUSB done!");

    }


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
                        moveLeft();
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
                        //txtzone.setText("RIGHT !!!!!!!!!!");
                        moveRight();
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
                switch (event.getAction()) {
                    case ACTION_DOWN:
                        moveUp();
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
                switch (event.getAction()) {
                    case ACTION_DOWN:
                        moveDown();
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



//        buttonF = (Button)findViewById(R.id.buttonF);
//        buttonF.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View vw, MotionEvent event) {
//                switch (event.getAction()) {
//                    case ACTION_DOWN:
//                        Fire();
//                        break;
//                    case ACTION_UP:
//                        Stop();
//                        break;
//                    default:
//                        break;
//                }
//                return true;
//            }
//        });

        buttonF = (Button)findViewById(R.id.buttonF);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(fireTest) {
                    fireTest = false;

                    Fire();
                    buttonF.setClickable(false);

                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                             Thread.sleep(3000);
                            } catch (InterruptedException e) {
                            e.printStackTrace();
                            }

                            Stop();
                            buttonF.setClickable(true);
                            fireTest = true;

                        }
                    });

                    t.start();
                }
            }
        });

        txtzone = (TextView)findViewById(R.id.textView);
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
