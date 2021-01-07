package net.simplifiedlearning.volleymysqlexample;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);// hide notification bar


        SetAlarmClass setAlarmClass = new SetAlarmClass();
        setAlarmClass.setalarm(getApplicationContext());





        int min = 2*600;
        new CountDownTimer(min, 1000
        ) {
            public void onTick(long millisUntilFinished) {


            }
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, AdsPostActivity.class);
                startActivity(intent);
                finish();

            }
        }.start();


    }




}
