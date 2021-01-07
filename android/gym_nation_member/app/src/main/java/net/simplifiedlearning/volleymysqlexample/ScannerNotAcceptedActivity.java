package net.simplifiedlearning.volleymysqlexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScannerNotAcceptedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_not_accepted);

        TextView textv_btn_tryagain = (TextView)findViewById(R.id.textv_btn_tryagain);



        textv_btn_tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ScannerNotAcceptedActivity.this,GymsChooseActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }




    /**
     * Back button listener.
     * Will close the application if the back button pressed twice.
     */
    @Override
    public void onBackPressed()
    {

        Intent intent = new Intent(ScannerNotAcceptedActivity.this, AdsPostActivity.class);
        startActivity(intent);
        finish();

    }


}
