package net.simplifiedlearning.volleymysqlexample;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifTextView;

public class NotificationActivity extends AppCompatActivity {

    String URL_NOTIFICATION ;

    ImageView status ;
    ImageView notification ;
    ImageView settings ;
    ImageView home ;
    ImageView workout ;
    ImageView member_and_plan ;
    GifTextView gifTextView_conn_status ;

    List<Notification> NotificationList;
    RecyclerView recyclerView;

    String Server_URL ;
    DataBaseConnction dataBaseConnction ;

    LinearLayout linearLayout_activity_control ;
    RelativeLayout main_notification_layout ;

    SwipeRefreshLayout pullToRefresh ;

    boolean visb = true ;
    boolean response = false ;


    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


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




        Server_URL = getResources().getString(R.string.Server_URL);
        URL_NOTIFICATION = getResources().getString(R.string.Notification_php);

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pullToRefresh = findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorSchemeColors(Color.parseColor("#3fb5a6"));
        pullToRefresh.setProgressBackgroundColorSchemeColor(Color.parseColor("#044a42"));




        //initializing the productlist
        NotificationList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        SendReceivedData_notification(Server_URL,URL_NOTIFICATION,gym_database_url());

        status = (ImageView)findViewById(R.id.btn_img_status);
        notification =(ImageView)findViewById(R.id.btn_img_notification);
        settings = (ImageView)findViewById(R.id.btn_img_settings);
        home = (ImageView)findViewById(R.id.btn_img_home);
        workout = (ImageView)findViewById(R.id.btn_img_workout_history);
        member_and_plan = (ImageView)findViewById(R.id.btn_img_member_and_plan);
        gifTextView_conn_status = (GifTextView) findViewById(R.id.gifTextView_conn_status);

        linearLayout_activity_control = (LinearLayout)findViewById(R.id.linearLayout_activity_control);
        main_notification_layout = (RelativeLayout)findViewById(R.id.main_notification_layout);







        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NotificationActivity.this, MemberAtGymActivity.class);
                startActivity(intent);
                finish();

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NotificationActivity.this,SettingsActivity.class);
                startActivity(intent);
                finish();

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NotificationActivity.this, AdsPostActivity.class);
                startActivity(intent);
                finish();

            }
        });


        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NotificationActivity.this, WorkoutHistoryActivity.class);
                startActivity(intent);
                finish();

            }
        });

        member_and_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NotificationActivity.this, UserAndPlanDataActivity.class);
                startActivity(intent);
                finish();

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


        no_internet();


        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                NotificationList.clear();
                SendReceivedData_notification(Server_URL,URL_NOTIFICATION,gym_database_url());
                pullToRefresh.setRefreshing(false);
            }
        });



    }



    public void SendReceivedData_notification(final String Server_url,final String php_Search_member_url,final String gym_name) {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            String line ;
            @Override
            protected String doInBackground(String... params) {
                String Server_URL = Server_url+php_Search_member_url;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("gymname", gym_name));
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(Server_URL);
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    BufferedReader rd = new BufferedReader(new InputStreamReader
                            (httpResponse.getEntity().getContent()));
                    line = "";
                    line = rd.readLine();

                    if(!line.equals("")) {
                        response = true;
                    }

                } catch (ClientProtocolException e) {
                } catch (IOException e) {
                }
                return line;
            }
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                if (result != null) {

                    try {
                        JSONArray array = new JSONArray(result);

                        if (array.length() == 0) {
                            recyclerView.setVisibility(View.GONE);
                            gifTextView_conn_status.setVisibility(View.VISIBLE);
                            gifTextView_conn_status.setBackgroundResource(R.drawable.background_no_data);
                        } else {

                            recyclerView.setVisibility(View.VISIBLE);
                            gifTextView_conn_status.setVisibility(View.GONE);

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject MassageData = array.getJSONObject(array.length() - 1 - i);
                                NotificationList.add(new Notification(
                                        MassageData.getInt("_id"),
                                        MassageData.getString("massage_head"),
                                        MassageData.getString("massage_body"),
                                        MassageData.getString("massage_time_date"),
                                        MassageData.getString("massage_icon")
                                ));
                            }
                            NotificationAdapter adapter = new NotificationAdapter(NotificationActivity.this, NotificationList);
                            recyclerView.setAdapter(adapter);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(gym_name);
    }



    public String gym_database_url(){
        Cursor c = dataBaseConnction.query_user_data("gym_info_local_database",null,null,null,null,null,null);
        c.moveToPosition(0);
        String gym_url = c.getString(3);
        return gym_url ;
    }










    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    public void onResume(){
        super.onResume();


    }


    public void no_internet(){
        int min = 2*6000;
        new CountDownTimer(min, 1000
        ) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                if(!response){
                    gifTextView_conn_status.setBackgroundResource(R.drawable.loding_fail_gif);
                }
            }
        }.start();
    }


    @Override
    public void onBackPressed()
    {

        Intent intent = new Intent(NotificationActivity.this, AdsPostActivity.class);
        startActivity(intent);
        finish();

    }



}
