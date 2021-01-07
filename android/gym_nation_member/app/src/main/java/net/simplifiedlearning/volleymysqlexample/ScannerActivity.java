package net.simplifiedlearning.volleymysqlexample;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

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
import java.util.Collection;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends Activity implements ZXingScannerView.ResultHandler {

    private static final int PERMISSION_REQUEST_CODE = 200;

    DataBaseConnction dataBaseConnction ;

    String Server_URL ;






    public static final String EXCLUDED_FORMAT = "ExcludedFormat";
    private static final String TAG = ScannerActivity.class.getSimpleName();
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        setStatusBarTranslucent(true);
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);


        if (checkPermission()) {
            //main logic or main code

            // . write your main code to execute, It will execute if the permission is already given.

        } else {
            requestPermission();
        }
    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            return false;
        }
        return true;
    }


    private void requestPermission() {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA},
                PERMISSION_REQUEST_CODE);
    }



    protected void setStatusBarTranslucent(boolean makeTranslucent) {
        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        String result = rawResult.getText();



        SendReceivedData(gym_database_url(),result);

        BarcodeFormat format = rawResult.getBarcodeFormat();

      //  Log.v(TAG, "Scanned code: " + rawResult.getText());
      //  Log.v(TAG, "Scanend code type: " + rawResult.getBarcodeFormat().toString());

        //Return error
        if (result == null) {
            setResult(RESULT_CANCELED, returnErrorCode(result, format));
            finish();
        }

        if (result.isEmpty()) {
            setResult(RESULT_CANCELED, returnErrorCode(result, format));
            finish();
        }

        //Return correct code
        setResult(RESULT_OK, returnCorrectCode(result, format));
        finish();
    }

    private Intent returnErrorCode(String result, BarcodeFormat format) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(ScannerConstants.ERROR_INFO, getResources().getString(R.string.scanner_error_message));
        return returnIntent;
    }

    private Intent returnCorrectCode(String result, BarcodeFormat format) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(ScannerConstants.SCAN_RESULT, result);

        if (format.equals(BarcodeFormat.QR_CODE)) {
            returnIntent.putExtra(ScannerConstants.SCAN_RESULT_TYPE, ScannerConstants.QR_SCAN);
        } else {
            returnIntent.putExtra(ScannerConstants.SCAN_RESULT_TYPE, ScannerConstants.BAR_SCAN);
        }

        return returnIntent;
    }

    public void excludeFormats(BarcodeFormat item) {
        Collection<BarcodeFormat> defaultFormats = mScannerView.getFormats();
        List<BarcodeFormat> formats = new ArrayList<>();
        for (BarcodeFormat format : defaultFormats) {
            if (!format.equals(item)) {
                formats.add(format);
            }
        }
        mScannerView.setFormats(formats);
    }

    public interface ScannerConstants {
        public static final String SCAN_MODES = "SCAN_MODES";
        public static final String SCAN_RESULT = "SCAN_RESULT";
        public static final String SCAN_RESULT_TYPE = "SCAN_RESULT_TYPE";
        public static final String ERROR_INFO = "ERROR_INFO";
        public static final int BAR_SCAN = 0;
        public static final int QR_SCAN = 1;
    }


    public String gym_database_url(){
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

        Cursor c = dataBaseConnction.query_user_data("gym_info_local_database",null,null,null,null,null,null);
        c.moveToPosition(0);
        String gym_url = c.getString(3);
        return gym_url ;
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();

                    // main logic
                } else {
                    Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                                != PackageManager.PERMISSION_GRANTED) {
                            showMessageOKCancel("You need to allow access permissions",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermission();
                                            }
                                        }
                                    });
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(ScannerActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }





    public void SendReceivedData(final String gym_name,final String rfid) {

        Server_URL = getResources().getString(R.string.Server_URL);


        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

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



                String Server_link = Server_URL+"gym_nation_search_member_api.php";
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("rfid", rfid));
                nameValuePairs.add(new BasicNameValuePair("gymname", gym_name));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(Server_link);
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    BufferedReader rd = new BufferedReader(new InputStreamReader
                            (httpResponse.getEntity().getContent()));

                      String line = "";
                      line = rd.readLine();



                 JSONArray jsonarray = new JSONArray(line);
                 JSONObject obj = jsonarray.getJSONObject(0);
                 String rfid = obj.getString("RFID");

                 String member_name = obj.getString("full_name");
                 String profile_img = obj.getString("image");

                 dataBaseConnction.update_member_data(member_name,profile_img);
                 dataBaseConnction.update_member_rfid_data(rfid);

                    Intent intent = new Intent(ScannerActivity.this, UserAndPlanDataActivity.class);
                    startActivity(intent);
                    finish();

                } catch (ClientProtocolException e) {
                } catch (IOException e) {

                } catch (JSONException e) {
                    Intent intent = new Intent(ScannerActivity.this,ScannerNotAcceptedActivity.class);
                    startActivity(intent);
                    finish();
                }
                return "Data Inserted Successfully";
            }
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);


            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(rfid);
    }

}
