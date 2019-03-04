package com.reziena.user.reziena_1;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

public class SigninActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private EditText etPasswordConfirm;
    LinearLayout login_signin, signin_signin;
    ImageView logincheck;
    public  Pattern email = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordConfirm = (EditText) findViewById(R.id.etPasswordConfirm);
        login_signin = findViewById(R.id.login_signin);
        signin_signin = findViewById(R.id.signin_sigin);
        logincheck = findViewById(R.id.sang);
        Drawable alphalogin = login_signin.getBackground();
        Drawable alphasignin = signin_signin.getBackground();

        alphalogin.setAlpha(50);
        alphasignin.setAlpha(50);

        login_signin.setEnabled(false);
        signin_signin.setEnabled(false);


        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("Range")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = etEmail.getText().toString();

                if( email.contains("@")&& email.contains(".")) {
                    etEmail.setTextColor(Color.parseColor("#450969"));
                    // 비밀번호 일치 검사
                    etPasswordConfirm.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @SuppressLint("Range")
                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            String password = etPassword.getText().toString();
                            String confirm = etPasswordConfirm.getText().toString();
                            if(s.length()==0){
                                logincheck.setVisibility(View.INVISIBLE);
                            }
                            else {
                                if(s.length()>=6&&s.length()<=12) {
                                    if (password.equals(confirm)) {
                                        logincheck.setVisibility(View.VISIBLE);
                                        etPasswordConfirm.setTextColor(Color.parseColor("#450969"));
                                        logincheck.setImageResource(R.drawable.logincheck);
                                        alphasignin.setAlpha(255);//알파값 20
                                        signin_signin.setEnabled(true);
                                    } else {
                                        logincheck.setVisibility(View.VISIBLE);
                                        etPasswordConfirm.setTextColor(Color.parseColor("#9E0958"));
                                        logincheck.setImageResource(R.drawable.loginx);
                                        alphasignin.setAlpha(50);//알파값 20
                                        signin_signin.setEnabled(false);
                                    }
                                }
                                else{
                                    alphasignin.setAlpha(50);//알파값 20
                                    signin_signin.setEnabled(false);
                                    logincheck.setVisibility(View.VISIBLE);
                                    logincheck.setImageResource(R.drawable.loginx);
                                }
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });

                    etPassword.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            String password = etPassword.getText().toString();
                            String confirm = etPasswordConfirm.getText().toString();
                            Log.e("password",password);
                            Log.e("password",confirm);
                            if(s.length()==0){
                                logincheck.setVisibility(View.INVISIBLE);
                            }
                            else {
                                if(s.length()>=6 ) {
                                    if (password.equals(confirm)) {
                                        logincheck.setVisibility(View.VISIBLE);
                                        etPasswordConfirm.setTextColor(Color.parseColor("#450969"));
                                        logincheck.setImageResource(R.drawable.logincheck);
                                        alphasignin.setAlpha(255);//알파값 20
                                        signin_signin.setEnabled(true);

                                    } else {
                                        logincheck.setVisibility(View.VISIBLE);
                                        etPasswordConfirm.setTextColor(Color.parseColor("#9E0958"));
                                        logincheck.setImageResource(R.drawable.loginx);
                                        alphasignin.setAlpha(50);//알파값 20
                                        signin_signin.setEnabled(false);
                                    }
                                }
                                else{
                                    alphasignin.setAlpha(50);//알파값 20
                                    signin_signin.setEnabled(false);
                                    logincheck.setVisibility(View.VISIBLE);
                                    logincheck.setImageResource(R.drawable.loginx);
                                }
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            String confirm = etPasswordConfirm.getText().toString();
                            if(confirm==null){
                                logincheck.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                } else {
                    etEmail.setTextColor(Color.parseColor("#9E0958"));
                    alphasignin.setAlpha(50);//알파값 20
                    signin_signin.setEnabled(false);
                    logincheck.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signin_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 이메일 입력 확인
                if( etEmail.getText().toString().length() == 0 ) {
                    Toast.makeText(SigninActivity.this, "Email을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etEmail.requestFocus();
                    return;
                }

                // 비밀번호 입력 확인
                if( etPassword.getText().toString().length() == 0 ) {
                    Toast.makeText(SigninActivity.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    etPassword.requestFocus();
                    return;
                }

                // 비밀번호 확인 입력 확인
                if( etPasswordConfirm.getText().toString().length() == 0 ) {
                    Toast.makeText(SigninActivity.this, "비밀번호 확인을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etPasswordConfirm.requestFocus();
                    return;
                }

                // 비밀번호 일치 확인
                if( !etPassword.getText().toString().equals(etPasswordConfirm.getText().toString()) ) {
                    Toast.makeText(SigninActivity.this, "비밀번호가 일치하지 않습니다!", Toast.LENGTH_SHORT).show();
                    etPassword.setText("");
                    etPasswordConfirm.setText("");
                    etPassword.requestFocus();
                    return;
                }

                getUser task = new getUser();
                task.execute("http://"+HomeActivity.IP_Address+"/getUser.php", etEmail.getText().toString());
            }
        });

    }

    class getUser extends AsyncTask<String, Void, String> {
        String id, name, profile, kind;

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Log.e("login-onPostExecute", "response - " + result);

            if (result==null) {
                Log.e("onPostExecute", "회원없음");
                Intent intent1 = new Intent(getApplicationContext(),Signin2Activity.class);
                intent1.putExtra("id",id);
                intent1.putExtra("name",name);
                intent1.putExtra("password",etPassword.getText().toString());
                intent1.putExtra("profile",profile);
                startActivity(intent1);
                finish();
            } else {
                if (result.contains("yes")) {
                    // 이미 회원이 있을 때
                    Intent intent = new Intent(getApplicationContext(), LoginpopActivity.class);
                    startActivity(intent);
                    etPassword.setText("");
                    etPasswordConfirm.setText("");
                    etEmail.setText("");
                } else {
                    {
                        Log.e("onPostExecute", "회원없음");
                        Intent intent1 = new Intent(getApplicationContext(),Signin2Activity.class);
                        intent1.putExtra("id",id);
                        intent1.putExtra("name",name);
                        intent1.putExtra("password",etPassword.getText().toString());
                        intent1.putExtra("profile",profile);
                        startActivity(intent1);
                        finish();
                    }
                }
            }
        }

        @Override
        protected String doInBackground(String... params) {
            String serverURL = params[0];

            id = params[1];

            String postParameters = "id="+id;

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

                // response
                InputStream inputStream;
                int responseStatusCode = httpURLConnection.getResponseCode();
                String responseStatusMessage = httpURLConnection.getResponseMessage();
                Log.e("response", "POST response Code - " + responseStatusCode);
                Log.e("response", "POST response Message - "+ responseStatusMessage);

                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    // 정상적인 응답 데이터
                    Log.e("inputstream: ", "정상적");
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    // error
                    Log.e("inputstream: ", "비정상적: " + httpURLConnection.getErrorStream());
                    inputStream = httpURLConnection.getErrorStream();
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
                Log.e("ERROR_loginActivity", "InsertDataError ", e);
            }
            return null;
        }
    }
}
