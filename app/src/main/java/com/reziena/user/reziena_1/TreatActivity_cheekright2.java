package com.reziena.user.reziena_1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.RenderScript;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

public class TreatActivity_cheekright2 extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference wrinkle_txt;
    RenderScript rs;
    Bitmap blurBitMap;
    private static Bitmap bitamp;
    private DatabaseReference underrightdata,underleftdata,cheekleftdata,cheekrightdata;
    String wrinkle_string;
    String cheekrightstring,cheekleftstring;
    ImageView forehead, underleft, underright, eyeleft, eyeright, cheekl, cheekr, mouth, back, backgroundimg;
    LinearLayout component;
    TextView component_txt,u_tright_txt1,u_tright_txt2,u_tleft_txt1,u_tleft_txt2,c_tright_txt1,c_tright_txt2,c_tleft_txt1,c_tleft_txt2;
    int cheekcount=0, data=0, level=0, timer_sec, count=0;
    ImageView c_tright_line1,c_tright_line2,c_tright_line3,c_tright_line4,c_tright_line5,c_tright_line6,c_tright_line7,c_tright_line8
            ,c_tright_line9,c_tright_line10,c_tright_line11,c_tright_line12,c_tright_line13,c_tright_line14,c_tright_line15,c_tright_line16,c_tright_line17
            ,c_tright_line18,c_tright_line19,c_tright_line20,c_tright_line21,c_tright_line22;
    TimerTask second;
    String part;
    AnimationDrawable ctrani1,ctrani2,ctrani3,ctrani4,ctrani5,ctrani6,ctrani7,ctrani8,ctrani9,ctrani10,ctrani11,ctrani12,ctrani13,ctrani14,ctrani15
            ,ctrani16,ctrani17,ctrani18,ctrani19,ctrani20,ctrani21,ctrani22;
    static String finish;
    public static Activity cheekrightactivity;
    ImageView content1, content2;
    public static String IP_Address = "52.32.36.182";
    String treat;

    public static void intentpage(String string) {
        finish=string;
    }

    public void animation() {
        second = new TimerTask() {
            @Override
            public void run() {
                Log.e("카운터",String.valueOf(count));
                count++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                            if (count == 1) {
                                String str = "THIS COLUMN HAS 8 LINES.\nPLACE THE DEVICE TO THE COLORED LINE AS\nSHOWN. AND PRESS THE CENTER BUTTON TO\nSTART TREATING ONE LINE";
                                SpannableStringBuilder ssb = new SpannableStringBuilder(str);
                                ssb.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 72, 126, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                component_txt.setText(ssb);
                                c_tright_line15.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani15 = (AnimationDrawable) c_tright_line15.getBackground();
                                ctrani15.start();
                            }
                            if (count == 2) {
                                ctrani15.stop();
                                c_tright_line15.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line16.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani16 = (AnimationDrawable) c_tright_line16.getBackground();
                                ctrani16.start();
                                c_tright_txt1.setText("7 left");
                            }
                            if (count == 3) {
                                ctrani16.stop();
                                c_tright_line16.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line17.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani17 = (AnimationDrawable) c_tright_line17.getBackground();
                                ctrani17.start();
                                c_tright_txt1.setText("6 left");
                            }
                            if (count == 4) {
                                ctrani17.stop();
                                c_tright_line17.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line18.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani18 = (AnimationDrawable) c_tright_line18.getBackground();
                                ctrani18.start();
                                c_tright_txt1.setText("5 left");
                            }
                            if (count == 5) {
                                ctrani18.stop();
                                c_tright_line18.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line19.setBackgroundResource(R.drawable.cheekrightmiddle1);
                                ctrani19 = (AnimationDrawable) c_tright_line19.getBackground();
                                ctrani19.start();
                                c_tright_txt1.setText("4 left");
                            }
                            if (count == 6) {
                                ctrani19.stop();
                                c_tright_line19.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line20.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani20 = (AnimationDrawable) c_tright_line20.getBackground();
                                ctrani20.start();
                                c_tright_txt1.setText("3 left");
                            }
                            if (count == 7) {
                                ctrani20.stop();
                                c_tright_line20.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line21.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani21 = (AnimationDrawable) c_tright_line21.getBackground();
                                ctrani21.start();
                                c_tright_txt1.setText("2 left");
                            }
                            if (count == 8) {
                                ctrani21.stop();
                                c_tright_line21.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line22.setBackgroundResource(R.drawable.cheekrightanim1);
                                ctrani22 = (AnimationDrawable) c_tright_line22.getBackground();
                                ctrani22.start();
                                c_tright_txt1.setText("1 left");
                            }
                            if (count == 9) {
                                String str = "THIS COLUMN HAS 14 LINES.\nPLACE THE DEVICE TO THE COLORED LINE AS\nSHOWN. AND PRESS THE CENTER BUTTON TO\nSTART TREATING ONE LINE";
                                SpannableStringBuilder ssb = new SpannableStringBuilder(str);
                                ssb.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 73, 127, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                component_txt.setText(ssb);
                                ctrani22.stop();
                                c_tright_line22.setBackgroundResource(R.drawable.line123finish);
                                c_tright_line1.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani1 = (AnimationDrawable) c_tright_line1.getBackground();
                                ctrani1.start();
                                c_tright_txt1.setText("DONE");
                                c_tright_txt1.setTextColor(Color.parseColor("#9E0958"));
                            }
                            if (count == 10) {
                                ctrani1.stop();
                                c_tright_line1.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line2.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani2 = (AnimationDrawable) c_tright_line2.getBackground();
                                ctrani2.start();
                                c_tright_txt2.setText("13 left");
                            }
                            if (count == 11) {
                                ctrani2.stop();
                                c_tright_line2.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line3.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani3 = (AnimationDrawable) c_tright_line3.getBackground();
                                ctrani3.start();
                                c_tright_txt2.setText("12 left");
                            }
                            if (count == 12) {
                                ctrani3.stop();
                                c_tright_line3.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line4.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani4 = (AnimationDrawable) c_tright_line4.getBackground();
                                ctrani4.start();
                                c_tright_txt2.setText("11 left");
                            }
                            if (count == 13) {
                                ctrani4.stop();
                                c_tright_line4.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line5.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani5 = (AnimationDrawable) c_tright_line5.getBackground();
                                ctrani5.start();
                                c_tright_txt2.setText("10 left");
                            }
                            if (count == 14) {
                                ctrani5.stop();
                                c_tright_line5.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line6.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani6 = (AnimationDrawable) c_tright_line6.getBackground();
                                ctrani6.start();
                                c_tright_txt2.setText("9 left");
                            }
                            if (count == 15) {
                                ctrani6.stop();
                                c_tright_line6.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line7.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani7 = (AnimationDrawable) c_tright_line7.getBackground();
                                ctrani7.start();
                                c_tright_txt2.setText("8 left");
                            }
                            if (count == 16) {
                                ctrani7.stop();
                                c_tright_line7.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line8.setBackgroundResource(R.drawable.cheekrightmiddle2);
                                ctrani8 = (AnimationDrawable) c_tright_line8.getBackground();
                                ctrani8.start();
                                c_tright_txt2.setText("7 left");
                            }
                            if (count == 17) {
                                ctrani8.stop();
                                c_tright_line8.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line9.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani9 = (AnimationDrawable) c_tright_line9.getBackground();
                                ctrani9.start();
                                c_tright_txt2.setText("6 left");
                            }
                            if (count == 18) {
                                ctrani9.stop();
                                c_tright_line9.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line10.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani10 = (AnimationDrawable) c_tright_line10.getBackground();
                                ctrani10.start();
                                c_tright_txt2.setText("5 left");
                            }
                            if (count == 19) {
                                ctrani10.stop();
                                c_tright_line10.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line11.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani11 = (AnimationDrawable) c_tright_line11.getBackground();
                                ctrani11.start();
                                c_tright_txt2.setText("4 left");
                            }
                            if (count == 20) {
                                ctrani11.stop();
                                c_tright_line11.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line12.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani12 = (AnimationDrawable) c_tright_line12.getBackground();
                                ctrani12.start();
                                c_tright_txt2.setText("3 left");
                            }
                            if (count == 21) {
                                ctrani12.stop();
                                c_tright_line12.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line13.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani13 = (AnimationDrawable) c_tright_line13.getBackground();
                                ctrani13.start();
                                c_tright_txt2.setText("2 left");
                            }
                            if (count == 22) {
                                ctrani13.stop();
                                c_tright_line13.setBackgroundResource(R.drawable.line1finish);
                                c_tright_line14.setBackgroundResource(R.drawable.cheekrightanim2);
                                ctrani14 = (AnimationDrawable) c_tright_line14.getBackground();
                                ctrani14.start();
                                c_tright_txt2.setText("1 left");
                            } if (count > 22) {
                                c_tright_line14.setBackgroundResource(R.drawable.line1finish);
                                component_txt.setText("GOOD JOB");
                                c_tright_txt2.setText("DONE");
                                c_tright_txt2.setTextColor(Color.parseColor("#9E0958"));
                                data=25;
                                cheekrightstring="true";
                            }
                            if(count==23){

                                GetData task = new GetData();
                                task.execute("http://"+IP_Address+"/callingTreathome.php", "");

                                if (! TreatActivity_cheekright2.this.isFinishing()) {
                                    Intent intent = new Intent(getApplicationContext(),DoneActivity.class);
                                    intent.putExtra("stringlist","cheekright");
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
                task.execute("http://"+HomeActivity.IP_Address+"/saveTreat.php", "cheek_r");
            } else {
                showResult(getResult);
                setData task = new setData();
                task.execute("http://"+HomeActivity.IP_Address+"/updateTreat.php", treat+"/cheek_r");
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat_cheekright2);

        cheekrightdata = databaseReference.child("result").child("cheekrightstring");
        cheekleftdata = databaseReference.child("result").child("cheekleftstring");
        cheekrightactivity = TreatActivity_cheekright2.this;

        Resources res = getResources();
        final Drawable  cheekrightimg= res.getDrawable(R.drawable.cheekrightimg);
        final Drawable  cheekleftimg= res.getDrawable(R.drawable.cheekleftimg);
        final Drawable  cheekunderrightimg= res.getDrawable(R.drawable.cheekunderimg);
        final Drawable  cheekunderleftimg= res.getDrawable(R.drawable.cheekunderleft);
        //값 받아오기
        content1 = findViewById(R.id.treatup_cr2);
        content2 = findViewById(R.id.treatdown_cr2);
        back=(ImageView)findViewById(R.id.backw_cr);
        c_tright_line1=(ImageView)findViewById(R.id.c_tright_line1);
        c_tright_line2=(ImageView)findViewById(R.id.c_tright_line2);
        c_tright_line3=(ImageView)findViewById(R.id.c_tright_line3);
        c_tright_line4=(ImageView)findViewById(R.id.c_tright_line4);
        c_tright_line5=(ImageView)findViewById(R.id.c_tright_line5);
        c_tright_line6=(ImageView)findViewById(R.id.c_tright_line6);
        c_tright_line7=(ImageView)findViewById(R.id.c_tright_line7);
        c_tright_line8=(ImageView)findViewById(R.id.c_tright_line8);
        c_tright_line9=(ImageView)findViewById(R.id.c_tright_line9);
        c_tright_line10=(ImageView)findViewById(R.id.c_tright_line10);
        c_tright_line11=(ImageView)findViewById(R.id.c_tright_line11);
        c_tright_line12=(ImageView)findViewById(R.id.c_tright_line12);
        c_tright_line13=(ImageView)findViewById(R.id.c_tright_line13);
        c_tright_line14=(ImageView)findViewById(R.id.c_tright_line14);
        c_tright_line15=(ImageView)findViewById(R.id.c_tright_line15);
        c_tright_line16=(ImageView)findViewById(R.id.c_tright_line16);
        c_tright_line17=(ImageView)findViewById(R.id.c_tright_line17);
        c_tright_line18=(ImageView)findViewById(R.id.c_tright_line18);
        c_tright_line19=(ImageView)findViewById(R.id.c_tright_line19);
        c_tright_line20=(ImageView)findViewById(R.id.c_tright_line20);
        c_tright_line21=(ImageView)findViewById(R.id.c_tright_line21);
        c_tright_line22=(ImageView)findViewById(R.id.c_tright_line22);
        u_tleft_txt1=(TextView)findViewById(R.id.u_tleft_txt1);
        u_tleft_txt2=(TextView)findViewById(R.id.u_tleft_txt2);
        c_tright_txt1=(TextView)findViewById(R.id.c_tright_txt1);
        c_tright_txt2=(TextView)findViewById(R.id.c_tright_txt2);
        c_tleft_txt1=(TextView)findViewById(R.id.c_tleft_txt1);
        c_tleft_txt2=(TextView)findViewById(R.id.c_tleft_txt2);
        component_txt=findViewById(R.id.componenttxt_cr);
        backgroundimg=findViewById(R.id.background);

        wrinkle_txt = databaseReference.child("result").child("winkle");

        animation();

    }

    public void onPause() {
        super.onPause();
        count = 500;
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
