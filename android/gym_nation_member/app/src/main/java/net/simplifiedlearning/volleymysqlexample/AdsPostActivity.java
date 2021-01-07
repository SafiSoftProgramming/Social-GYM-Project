package net.simplifiedlearning.volleymysqlexample;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifTextView;

public class AdsPostActivity extends AppCompatActivity {

    ImageView status ;
    ImageView notification ;
    ImageView settings ;
    ImageView home ;
    ImageView workout ;
    ImageView member_and_plan ;
    GifTextView gifTextView_conn_status ;


    List<AdsPost> Adlist;
    RecyclerView recyclerView;
    DataBaseConnction dataBaseConnction ;

    LinearLayout linearLayout_activity_control ;
    RelativeLayout main_notification_layout ;

    SwipeRefreshLayout pullToRefresh ;

    boolean visb = true ;

    String Server_URL ;

    String URL_ADPOST ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        Server_URL = getResources().getString(R.string.Server_URL);
        URL_ADPOST = getResources().getString(R.string.Home_adpost_php);


        dataBaseConnction = new DataBaseConnction(getApplicationContext());
        try {
            dataBaseConnction.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            dataBaseConnction.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        status = (ImageView)findViewById(R.id.btn_img_status);
        notification =(ImageView)findViewById(R.id.btn_img_notification);
        settings = (ImageView)findViewById(R.id.btn_img_settings);
        home = (ImageView)findViewById(R.id.btn_img_home);
        workout = (ImageView)findViewById(R.id.btn_img_workout_history);
        member_and_plan = (ImageView)findViewById(R.id.btn_img_member_and_plan);
        gifTextView_conn_status = (GifTextView) findViewById(R.id.gifTextView_conn_status);

        linearLayout_activity_control = (LinearLayout)findViewById(R.id.linearLayout_activity_control);
        main_notification_layout = (RelativeLayout)findViewById(R.id.main_notification_layout);


        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        pullToRefresh = findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorSchemeColors(Color.parseColor("#3fb5a6"));
        pullToRefresh.setProgressBackgroundColorSchemeColor(Color.parseColor("#044a42"));



        //check for data and internet
        //recyclerView.setVisibility(View.GONE);
     //   img_on_err_nonet_nodata.setImageResource(R.drawable.loding_gif);

        //initializing the productlist
        Adlist = new ArrayList<>();

        loadadpost();


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if ( Is_there_user_data()){
                Intent intent = new Intent(AdsPostActivity.this,NotificationActivity.class);
                startActivity(intent);
                finish();
                }else {
                    Intent intent = new Intent(AdsPostActivity.this, BeforLoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Is_there_user_data()) {

                    Intent intent = new Intent(AdsPostActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    finish();
                    }
                    else {

                        Intent intent = new Intent(AdsPostActivity.this, BeforLoginActivity.class);
                        startActivity(intent);
                        finish();
                    }

            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Is_there_user_data()) {

                    Intent intent = new Intent(AdsPostActivity.this, MemberAtGymActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {

                    Intent intent = new Intent(AdsPostActivity.this, BeforLoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });



        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Is_there_user_data()) {

                    Intent intent = new Intent(AdsPostActivity.this, WorkoutHistoryActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {

                    Intent intent = new Intent(AdsPostActivity.this, BeforLoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        member_and_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Is_there_user_data()) {

                    Intent intent = new Intent(AdsPostActivity.this, UserAndPlanDataActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {

                    Intent intent = new Intent(AdsPostActivity.this, BeforLoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 && visb == true) {
                    main_notification_layout.removeView(linearLayout_activity_control);
                    visb = false ;
                } else if (dy < 0 && visb == false) {
                    if(linearLayout_activity_control.getParent() != null) {
                        ((ViewGroup)linearLayout_activity_control.getParent()).removeView(linearLayout_activity_control); // <- fix
                    }
                    main_notification_layout.addView(linearLayout_activity_control);
                    visb = true ;
                }
            }
        });


//       if (isNetworkAvailable()){
//           recyclerView.setBackgroundResource(R.drawable.background);
//
//       }
//       else {recyclerView.setBackgroundResource(R.drawable.background_no_internet);}
//



        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Adlist.clear();
                loadadpost();
                pullToRefresh.setRefreshing(false);
            }
        });

    }







    private void loadadpost() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,Server_URL+ URL_ADPOST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                     //   recyclerView.setVisibility(View.VISIBLE);
                     //   gifTextView_conn_status.setVisibility(View.GONE);

                        try {
                            JSONArray array = new JSONArray(response);

                            if(array.length() == 0) {

                                recyclerView.setVisibility(View.GONE);
                                gifTextView_conn_status.setVisibility(View.VISIBLE);
                                gifTextView_conn_status.setBackgroundResource(R.drawable.loding_nodata_gif);
                            }
                            else {
                                //if there any data
                                recyclerView.setVisibility(View.VISIBLE);
                                gifTextView_conn_status.setVisibility(View.GONE);

                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject AdPostData = array.getJSONObject(array.length()-1-i);
                                    Adlist.add(new AdsPost(
                                            AdPostData.getInt("_id"),
                                            AdPostData.getString("ad_desc"),
                                            AdPostData.getString("ad_gif"),
                                            AdPostData.getString("ad_name"),
                                            AdPostData.getString("ad_icon"),
                                            AdPostData.getString("ad_time_date"),
                                            AdPostData.getString("promo_code"),
                                            AdPostData.getString("promo_code_expiry_date"),
                                            AdPostData.getString("contact_details")
                                    ));
                                }
                                AdsPostAdapter adsPostAdapter = new AdsPostAdapter(AdsPostActivity.this,Adlist);
                                recyclerView.setAdapter(adsPostAdapter);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        if (error instanceof TimeoutError) {
                            //For example your timeout is 3 seconds but the operation takes longer
                            gifTextView_conn_status.setBackgroundResource(R.drawable.loding_fail_gif);
                        }

                        else if (error instanceof ServerError) {
                            //error in server
                        }

                        else if (error instanceof NetworkError) {
                            gifTextView_conn_status.setBackgroundResource(R.drawable.loding_fail_gif);
                        }

                        else if (error instanceof ParseError) {
                            //for cant convert data
                        }

                        else {
                            //other error
                        }




                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }




    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public boolean Is_there_user_data(){
        boolean data = false ;
        Cursor c = dataBaseConnction.query_user_data("member_rfid_local_database",null,null,null,null,null,null);
        c.moveToPosition(0);
        String rfid = c.getString(1);

        if (rfid.equals("0")){
            data = false ;
        }
        else {data = true;}
        return data ;
    }

    @Override
    public void onResume(){
        super.onResume();

    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }




}
