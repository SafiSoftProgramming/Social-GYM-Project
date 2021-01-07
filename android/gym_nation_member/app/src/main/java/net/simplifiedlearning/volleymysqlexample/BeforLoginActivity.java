package net.simplifiedlearning.volleymysqlexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class BeforLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_befor_login);
        LinearLayout textv_btn_continue = (LinearLayout) findViewById(R.id.textv_btn_continue);



        textv_btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BeforLoginActivity.this, GymsChooseActivity.class);
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

        Intent intent = new Intent(BeforLoginActivity.this, AdsPostActivity.class);
        startActivity(intent);
        finish();

    }



}
