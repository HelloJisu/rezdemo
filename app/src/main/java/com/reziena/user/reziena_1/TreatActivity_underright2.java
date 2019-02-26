package com.reziena.user.reziena_1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.RenderScript;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.reziena.user.reziena_1.utils.RSBlurProcessor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.core.Point;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class TreatActivity_underright2 extends AppCompatActivity {


    String wrinkle_string;
    String underrightstring,underleftstring;
    RenderScript rs;
    Bitmap blurBitMap;
    private static Bitmap bitamp;
    public static Activity underrightactivity;
    ImageView forehead, underleft, underright, eyeleft, eyeright, cheekl, cheekr, mouth, back, backgroundimg;
    TextView component_txt,u_tright_txt1,u_tright_txt2,u_tleft_txt1,u_tleft_txt2,c_tright_txt1,c_tright_txt2,c_tleft_txt1,c_tleft_txt2;
    int undercount=0, data=0, level=0, timer_sec, count_ur=0;
    ImageView u_tright_line1,u_tright_line2,u_tright_line3,u_tright_line4,u_tright_line5,u_tright_line6,
            u_tright_line7,u_tright_line8,u_tright_line9,u_tright_line10,u_tright_line11,u_tright_line12,u_tright_line13;
    TimerTask second;
    String part;
    ImageView content1, content2;
    AnimationDrawable utrani1,utrani2,utrani3,utrani4,utrani5,utrani6,utrani7,utrani8,utrani9,utrani10,utrani11,utrani12,utrani13;
    public static String IP_Address = "52.32.36.182";
    String treat;

    public void animation() {
        second = new TimerTask() {
            @Override
            public void run() {
                Log.e("undercount",String.valueOf(count_ur));
                count_ur++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                            if (count_ur == 1) {
                                String str = "THIS COLUMN HAS 6 LINES.\nPLACE THE DEVICE TO THE COLORED LINE AS\nSHOWN. AND PRESS THE CENTER BUTTON TO\nSTART TREATING ONE LINE";
                                SpannableStringBuilder ssb = new SpannableStringBuilder(str);
                                ssb.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 72, 126, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                component_txt.setText(ssb);
                                u_tright_line8.setBackgroundResource(R.drawable.underrightanim1);
                                utrani8 = (AnimationDrawable) u_tright_line8.getBackground();
                                utrani8.start();
                            }
                            if (count_ur == 2) {
                                utrani8.stop();
                                u_tright_line8.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line9.setBackgroundResource(R.drawable.underrightanim1);
                                utrani9 = (AnimationDrawable) u_tright_line9.getBackground();
                                utrani9.start();
                                u_tright_txt1.setText("5 left");
                            }
                            if (count_ur == 3) {
                                utrani9.stop();
                                u_tright_line9.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line10.setBackgroundResource(R.drawable.underrightanim1);
                                utrani10 = (AnimationDrawable) u_tright_line10.getBackground();
                                utrani10.start();
                                u_tright_txt1.setText("4 left");
                            }
                            if (count_ur == 4) {
                                utrani10.stop();
                                u_tright_line10.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line11.setBackgroundResource(R.drawable.underrightmiddle1);
                                utrani11 = (AnimationDrawable) u_tright_line11.getBackground();
                                utrani11.start();
                                u_tright_txt1.setText("3 left");
                            }
                            if (count_ur == 5) {
                                utrani11.stop();
                                u_tright_line11.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line12.setBackgroundResource(R.drawable.underrightanim1);
                                utrani12 = (AnimationDrawable) u_tright_line12.getBackground();
                                utrani12.start();
                                u_tright_txt1.setText("2 left");
                            }
                            if (count_ur == 6) {
                                utrani12.stop();
                                u_tright_line12.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line13.setBackgroundResource(R.drawable.underrightanim1);
                                utrani13 = (AnimationDrawable) u_tright_line13.getBackground();
                                utrani13.start();
                                u_tright_txt1.setText("1 left");
                            }
                            if (count_ur == 7) {
                                String str = "THIS COLUMN HAS 7 LINES.\nPLACE THE DEVICE TO THE COLORED LINE AS\nSHOWN. AND PRESS THE CENTER BUTTON TO\nSTART TREATING ONE LINE";
                                SpannableStringBuilder ssb = new SpannableStringBuilder(str);
                                ssb.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 72, 126, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                component_txt.setText(ssb);
                                utrani13.stop();
                                u_tright_line13.setBackgroundResource(R.drawable.line8finish);
                                u_tright_line1.setBackgroundResource(R.drawable.underrightanim2);
                                utrani1 = (AnimationDrawable) u_tright_line1.getBackground();
                                u_tright_txt1.setText("DONE");
                                u_tright_txt1.setTextColor(Color.parseColor("#9E0958"));
                            }
                            if (count_ur == 8) {
                                utrani1.stop();
                                u_tright_line1.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line2.setBackgroundResource(R.drawable.underrightanim2);
                                utrani2 = (AnimationDrawable) u_tright_line2.getBackground();
                                utrani2.start();
                                u_tright_txt2.setText("6 left");
                            }
                            if (count_ur == 9) {
                                utrani2.stop();
                                u_tright_line2.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line3.setBackgroundResource(R.drawable.underrightanim2);
                                utrani3 = (AnimationDrawable) u_tright_line3.getBackground();
                                utrani3.start();
                                u_tright_txt2.setText("5 left");
                            }
                            if (count_ur == 10) {
                                utrani3.stop();
                                u_tright_line3.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line4.setBackgroundResource(R.drawable.underrightmiddle2);
                                utrani4 = (AnimationDrawable) u_tright_line4.getBackground();
                                utrani4.start();
                                u_tright_txt2.setText("4 left");
                            }
                            if (count_ur == 11) {
                                utrani4.stop();
                                u_tright_line4.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line5.setBackgroundResource(R.drawable.underrightanim2);
                                utrani5 = (AnimationDrawable) u_tright_line5.getBackground();
                                utrani5.start();
                                u_tright_txt2.setText("3 left");
                            }
                            if (count_ur == 12) {
                                utrani5.stop();
                                u_tright_line5.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line6.setBackgroundResource(R.drawable.underrightanim2);
                                utrani6 = (AnimationDrawable) u_tright_line6.getBackground();
                                utrani6.start();
                                u_tright_txt2.setText("2 left");
                            }
                            if (count_ur == 13) {
                                utrani6.stop();
                                u_tright_line6.setBackgroundResource(R.drawable.line1finish);
                                u_tright_line7.setBackgroundResource(R.drawable.underrightanim2);
                                utrani7 = (AnimationDrawable) u_tright_line7.getBackground();
                                utrani7.start();
                                u_tright_txt2.setText("1 left");
                            } if (count_ur >= 14) {
                                u_tright_line7.setBackgroundResource(R.drawable.line1finish);
                                component_txt.setText("GOOD JOB");
                                u_tright_txt2.setText("DONE");
                                u_tright_txt2.setTextColor(Color.parseColor("#9E0958"));
                                data=25;
                                underrightstring="true";
                        }
                        if(count_ur==15){
                            GetData task = new GetData();
                            task.execute("http://"+IP_Address+"/callingTreathome.php", "");


                            Log.e("underright", "save");

                            if (! TreatActivity_underright2.this.isFinishing()) {
                                Intent intent = new Intent(getApplicationContext(),DoneActivity.class);
                                intent.putExtra("stringlist","underright");
                                startActivity(intent);
                                new Handler().postDelayed(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        screenshot();
                                    }
                                }, 20);
                            }
                        }
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(second, 0, 1000);
    }

    class setData extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String getResult) { // 모르겠어// 유...
            super.onPostExecute(getResult);
            Log.e("gfdesetrdf",getResult);
        }

        @Override
        protected String doInBackground(String... params) {
            String serverURL = params[0];
            String where = params[1];

            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
            Date currentTime = new Date();
            String date = mSimpleDateFormat.format ( currentTime );

            SharedPreferences sp_userID = getSharedPreferences("userID", MODE_PRIVATE);
            String userID = sp_userID.getString("userID", "");
            String postParameters = "date="+date+"&id="+userID+"&where="+where;
            Log.e("sdffghrfhgyughj", "update/"+postParameters);

            try {
                URL url = new URL(serverURL);

                HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);;

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                Log.e("postParameters", postParameters);
                outputStream.flush();
                outputStream.close();
                InputStream inputStream;
                int responseStatusCode = httpURLConnection.getResponseCode();
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                    Log.e("gfhgfyghjgyj", "code - HTTP_OK - " + responseStatusCode);
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                    Log.e("hjfrdsrtrth", "code - HTTP_NOT_OK - " + responseStatusCode);
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }
                bufferedReader.close();

                return sb.toString().trim();

            } catch (Exception e) {
                Log.e("hjhkjhukhtyrdfh", e.getMessage());
            }
            return null;

        }
    }

    class GetData extends AsyncTask<String, Void, String> {
        List<String[]> treatArray = new ArrayList<>();

        @Override
        protected void onPostExecute(String getResult) { // 모르겠어// 유...
            super.onPostExecute(getResult);

            Log.e("쉬발",getResult);

            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
            Date currentTime = new Date();
            String date = mSimpleDateFormat.format ( currentTime );
            String dates[] = date.split("-");

            if (getResult.contains("No_results")) {
                setData task = new setData();
                task.execute("http://"+HomeActivity.IP_Address+"/saveTreat.php", "under_r");
            } else {
                showResult(getResult);
                setData task = new setData();
                task.execute("http://"+HomeActivity.IP_Address+"/updateTreat.php", treat+"/under_r");
            }
        }

        @Override
        protected String doInBackground(String... params) {
            String serverURL = params[0];

            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
            Date currentTime = new Date();
            String date = mSimpleDateFormat.format ( currentTime );

            Log.e("으악!!!!!!!!!!!!!!!",date);

            SharedPreferences sp_userID = getSharedPreferences("userID", MODE_PRIVATE);
            String userID = sp_userID.getString("userID", "");
            String postParameters = "id="+userID+"&date="+date;

            try {
                URL url = new URL(serverURL);

                HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();

                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                Log.e("moisture-postParameters", postParameters);
                outputStream.flush();
                outputStream.close();

                InputStream inputStream;
                int responseStatusCode = httpURLConnection.getResponseCode();
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                    Log.e("moisture-response", "code - HTTP_OK - " + responseStatusCode);
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                    Log.e("moisture-response", "code - HTTP_NOT_OK - " + responseStatusCode);
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }
                bufferedReader.close();

                return sb.toString().trim();

            } catch (Exception e) {
                Log.e("moisture-error-stream", e.getMessage());
            }
            return null;
        }

        private void showResult(String result){
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("getData");

                for(int i=0;i<jsonArray.length();i++){
                    JSONObject item = jsonArray.getJSONObject(i);
                    treat=item.getString("value");
                }

                Log.e("databse",treat);
            } catch (JSONException e) {
                Log.d("treat-JSON", "showResult : "+e.getMessage());
            }
        }
    }

    public void onStart() {
        super.onStart();
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        underrightactivity=TreatActivity_underright2.this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat_underright2);

        //값 받아오기

        content1 = findViewById(R.id.treatup_ur2);
        content2 = findViewById(R.id.treatdown_ur2);
        back=(ImageView)findViewById(R.id.backw_ur);
        u_tright_line1=(ImageView)findViewById(R.id.u_tright_line1);
        u_tright_line2=(ImageView)findViewById(R.id.u_tright_line2);
        u_tright_line3=(ImageView)findViewById(R.id.u_tright_line3);
        u_tright_line4=(ImageView)findViewById(R.id.u_tright_line4);
        u_tright_line5=(ImageView)findViewById(R.id.u_tright_line5);
        u_tright_line6=(ImageView)findViewById(R.id.u_tright_line6);
        u_tright_line7=(ImageView)findViewById(R.id.u_tright_line7);
        u_tright_line8=(ImageView)findViewById(R.id.u_tright_line8);
        u_tright_line9=(ImageView)findViewById(R.id.u_tright_line9);
        u_tright_line10=(ImageView)findViewById(R.id.u_tright_line10);
        u_tright_line11=(ImageView)findViewById(R.id.u_tright_line11);
        u_tright_line12=(ImageView)findViewById(R.id.u_tright_line12);
        u_tright_line13=(ImageView)findViewById(R.id.u_tright_line13);
        u_tright_txt1=(TextView)findViewById(R.id.u_tright_txt1);
        u_tright_txt2=(TextView)findViewById(R.id.u_tright_txt2);
        u_tleft_txt1=(TextView)findViewById(R.id.u_tleft_txt1);
        u_tleft_txt2=(TextView)findViewById(R.id.u_tleft_txt2);
        c_tright_txt1=(TextView)findViewById(R.id.c_tright_txt1);
        c_tright_txt2=(TextView)findViewById(R.id.c_tright_txt2);
        c_tleft_txt1=(TextView)findViewById(R.id.c_tleft_txt1);
        c_tleft_txt2=(TextView)findViewById(R.id.c_tleft_txt2);
        component_txt=findViewById(R.id.componenttxt_ur);
        backgroundimg = findViewById(R.id.background);
        animation();

    }

    public void onPause() {
        super.onPause();
        count_ur = 500;
    }
    public void screenshot(){
        rs = RenderScript.create(this);
        View view=getWindow().getDecorView();
        view.setDrawingCacheEnabled(false);
        view.setDrawingCacheEnabled(true);
        bitamp = view.getDrawingCache();
        RSBlurProcessor rsBlurProcessor = new RSBlurProcessor(rs);
        blurBitMap = rsBlurProcessor.blur(bitamp, 20f, 3);
        backgroundimg.setImageBitmap(blurBitMap);
    }
}
