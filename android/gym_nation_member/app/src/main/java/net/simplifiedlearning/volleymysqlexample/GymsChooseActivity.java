package net.simplifiedlearning.volleymysqlexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifTextView;


public class GymsChooseActivity extends AppCompatActivity {


    List<Gyms> Adlist;
    RecyclerView recyclerView;
    ImageView btn_back ;
    String Server_URL ;
    GifTextView gifTextView_conn_status ;

    LinearLayout linearLayout_activity_control ;
    RelativeLayout main_notification_layout ;

    boolean visb = true ;

    String URL_GYMLIST ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gymschoose);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gifTextView_conn_status = (GifTextView) findViewById(R.id.gifTextView_conn_status);

        linearLayout_activity_control = (LinearLayout)findViewById(R.id.linearLayout_activity_control);
        main_notification_layout = (RelativeLayout)findViewById(R.id.main_notification_layout);



        Server_URL = getResources().getString(R.string.Server_URL);
        URL_GYMLIST = getResources().getString(R.string.Gym_list_choose_php);
        //initializing the productlist
        Adlist = new ArrayList<>();

        loadgymlist();


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










    }



    private void loadgymlist() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,Server_URL+ URL_GYMLIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response != null) {
                            try {
                                JSONArray array = new JSONArray(response);

                                if (array.length() == 0) {

                                    recyclerView.setVisibility(View.GONE);
                                    gifTextView_conn_status.setVisibility(View.VISIBLE);
                                    gifTextView_conn_status.setBackgroundResource(R.drawable.background_no_data);
                                } else {
                                    //if there any data
                                    recyclerView.setVisibility(View.VISIBLE);
                                    gifTextView_conn_status.setVisibility(View.GONE);


                                    for (int i = 0; i < array.length(); i++) {

                                        JSONObject AdPostData = array.getJSONObject(array.length() - 1 - i);
                                        Adlist.add(new Gyms(
                                                AdPostData.getInt("_id"),
                                                AdPostData.getString("gym_name"),
                                                AdPostData.getString("gym_logo"),
                                                AdPostData.getString("gym_database_url")

                                        ));
                                    }
                                    GymsChooseAdapter GymsChooseAdapter = new GymsChooseAdapter(GymsChooseActivity.this, Adlist);
                                    recyclerView.setAdapter(GymsChooseAdapter);


                                }



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
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





    /**
     * Back button listener.
     * Will close the application if the back button pressed twice.
     */
                @Override
                public void onBackPressed()
                {

                    Intent intent = new Intent(GymsChooseActivity.this, AdsPostActivity.class);
                    startActivity(intent);
                    finish();

                }







}
