package net.simplifiedlearning.volleymysqlexample;

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

public class MemberAtGymActivity extends AppCompatActivity {

    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
    String URL_MEMBER ;
    String URL_SEARCH_MEMBER ;


    //a list to store all the products
    List<Member> productList;

    //the recyclerview
    RecyclerView recyclerView;
    ImageView status ;
    ImageView notification ;
    ImageView settings ;
    ImageView home ;
    ImageView workout ;
    ImageView member_and_plan ;

   // TextView txtv_member_atgym_count ;
    GifTextView gifTextView_conn_status ;


    String Server_URL ;
    DataBaseConnction dataBaseConnction ;



    LinearLayout linearLayout_activity_control,linearLayout_user_profile,linearLayout_user_profile_parent ;
    RelativeLayout main_notification_layout ;


    LinearLayout lay_gym_name  ;

    SwipeRefreshLayout pullToRefresh ;

    boolean visb = true ;
    boolean response = false ;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_at_gym);






        Server_URL = getResources().getString(R.string.Server_URL);
        URL_MEMBER = getResources().getString(R.string.Member_conn_php);
        URL_SEARCH_MEMBER = getResources().getString(R.string.Member_search_php);

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
        //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);// hide notification bar

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        status = (ImageView)findViewById(R.id.btn_img_status);
        notification =(ImageView)findViewById(R.id.btn_img_notification);
        settings = (ImageView)findViewById(R.id.btn_img_settings);
        home = (ImageView)findViewById(R.id.btn_img_home);
        workout = (ImageView)findViewById(R.id.btn_img_workout_history);
        member_and_plan = (ImageView)findViewById(R.id.btn_img_member_and_plan);
      //  txtv_member_atgym_count = (TextView)findViewById(R.id.txtv_member_atgym_count);

        gifTextView_conn_status = (GifTextView) findViewById(R.id.gifTextView_conn_status);

        linearLayout_activity_control = (LinearLayout)findViewById(R.id.linearLayout_activity_control);
        linearLayout_user_profile_parent = (LinearLayout)findViewById(R.id.linearLayout_user_profile_parent);
        linearLayout_user_profile = (LinearLayout)findViewById(R.id.linearLayout_user_profile);
        main_notification_layout = (RelativeLayout)findViewById(R.id.main_notification_layout);


        lay_gym_name = (LinearLayout)findViewById(R.id.lay_gym_name);


        pullToRefresh = findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorSchemeColors(Color.parseColor("#3fb5a6"));
        pullToRefresh.setProgressBackgroundColorSchemeColor(Color.parseColor("#044a42"));




        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview

        show_user_data_from_local_database();



        SendReceivedData_member_atgym(Server_URL,URL_MEMBER,gym_database_url());




        //txtv_member_name.setText(SendReceivedData(user_rfid_local_database(user_rfid_local_database()));
       // txtv_member_plane.setText(c.getString(2));
       // txtv_member_startdate.setText(c.getString(3));


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MemberAtGymActivity.this,NotificationActivity.class);
                startActivity(intent);
                finish();

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MemberAtGymActivity.this,SettingsActivity.class);
                startActivity(intent);
                finish();

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MemberAtGymActivity.this, AdsPostActivity.class);
                startActivity(intent);
                finish();

            }
        });


        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(MemberAtGymActivity.this, WorkoutHistoryActivity.class);
                    startActivity(intent);
                    finish();

            }
        });

        member_and_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MemberAtGymActivity.this, UserAndPlanDataActivity.class);
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
                        ((ViewGroup)linearLayout_activity_control.getParent()).removeView(linearLayout_activity_control);
                    }
                    main_notification_layout.addView(linearLayout_activity_control);
                    visb = true ;
                }


            }
        });




     //   member_profile_img.startAnimation(AnimationUtils.loadAnimation(MemberAtGymActivity.this, android.R.anim.slide_in_left));




              no_internet();

        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                productList.clear();
                SendReceivedData_member_atgym(Server_URL,URL_MEMBER,gym_database_url());
                pullToRefresh.setRefreshing(false);
            }
        });

    }






    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void show_user_data_from_local_database(){
        Cursor c = dataBaseConnction.query_user_data("gym_info_local_database",null,null,null,null,null,null);
        c.moveToPosition(0);
    }

    public String gym_database_url(){
        Cursor c = dataBaseConnction.query_user_data("gym_info_local_database",null,null,null,null,null,null);
        c.moveToPosition(0);
        String gym_url = c.getString(3);
        return gym_url ;
    }

    public String user_rfid_local_database(){
        Cursor c = dataBaseConnction.query_user_data("member_rfid_local_database",null,null,null,null,null,null);
        c.moveToPosition(0);
        String rfid = c.getString(1);
        return rfid ;
    }



    public void SendReceivedData_member_atgym(final String Server_url,final String php_member_atgym_url,final String gym_name) {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            String line ;
            @Override
            protected String doInBackground(String... params) {
                String Server_URL = Server_url+php_member_atgym_url;
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



                } catch (ClientProtocolException el) {

                } catch (IOException e) {
                }
                return line;
            }
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                if(result != null) {

                    try {
                        JSONArray array = new JSONArray(result);


                        if (array.length() == 0) {
                            recyclerView.setVisibility(View.GONE);
                            gifTextView_conn_status.setVisibility(View.VISIBLE);
                            gifTextView_conn_status.setBackgroundResource(R.drawable.loding_nooneatgym_gif);
                        } else {
                            //if there any data
                            recyclerView.setVisibility(View.VISIBLE);
                            gifTextView_conn_status.setVisibility(View.GONE);



                            for (int i = 0; i < array.length(); i++) {
                                    JSONObject product = array.getJSONObject(array.length() - 1 - i);




                                    productList.add(new Member(
                                            product.getInt("_id"),
                                            product.getString("member_name"),
                                            product.getString("workout_one_name"),
                                            product.getString("workout_two_name"),
                                            product.getString("member_photo"),
                                            product.getString("enter_member_time_date")
                                    ));


                            }
                            MemberAtGymAdapter adapter = new MemberAtGymAdapter(MemberAtGymActivity.this, productList);
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



    @Override
    public void onBackPressed()
    {

        Intent intent = new Intent(MemberAtGymActivity.this, AdsPostActivity.class);
        startActivity(intent);
        finish();

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
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onFinish() {
                if(!response){
                    gifTextView_conn_status.setBackgroundResource(R.drawable.loding_fail_gif);
                }
            }
        }.start();
    }

}
