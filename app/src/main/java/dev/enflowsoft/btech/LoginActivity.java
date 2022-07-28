package dev.enflowsoft.btech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import dev.enflowsoft.btech.interfaces.ILoginService;
import dev.enflowsoft.btech.models.LoginRequest;
import dev.enflowsoft.btech.models.LoginResponse;
import dev.enflowsoft.btech.remote.APIUtils;
import dev.enflowsoft.btech.services.CheckNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    /* SESSIONS */
    SharedPreferences usersession;
    public static final String UserSession = "UserSession";

    /* CONTROLS */
    private Button btnLogin;
    private EditText txtUsername, txtPassword;
    private ProgressBar progressBar;

    /* VARIABLES */
    private Integer appType = 3;

    /* API */
    private ILoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnlogin);
        txtUsername = (EditText) findViewById(R.id.txtusername);
        txtPassword = (EditText) findViewById(R.id.txtpassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        loginService = APIUtils.postUserLogin();
        try {
            doLoadingWork();
            usersession = getSharedPreferences(UserSession, Context.MODE_PRIVATE);
            Boolean isLoggedIn = usersession.getBoolean("isloggedin", false);
            if(isLoggedIn){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                stopLoadingWork();
                finish();
            }
            stopLoadingWork();
        } catch (Exception ex) {
            stopLoadingWork();
            Log.e("Session Error", ex.getMessage());
        }

        new Thread(new Runnable() {

            public void run() {
                doLoadingWork();
                if (CheckInternetPermissionGranted()) {
                    if (CheckNetwork.isInternetAvailable(LoginActivity.this)) //returns true if internet available
                    {
                        stopLoadingWork();
                    } else {
                        startActivity(new Intent(LoginActivity.this, NoNetworkActivity.class));
                        finish();
                    }
                }
            }
        }).start();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLoadingWork();
                if (TextUtils.isEmpty(txtUsername.getText())) {
                    stopLoadingWork();
                    Toast.makeText(LoginActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(txtPassword.getText())) {
                    stopLoadingWork();
                    Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                } else {
                    LoginRequest request = new LoginRequest();
                    request.setUsername(txtUsername.getText().toString());
                    request.setPassword(txtPassword.getText().toString());
                    request.setLogintype(appType);
                    request.setDeviceDescription("Test mobile");
                    request.setMobileDeviceId("0123456789");
                    Call<LoginResponse> call = loginService.callUserLogin(request);
                    call.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            if (response.isSuccessful()) {
                                LoginResponse responsebody = response.body();
                                SetUserSession(responsebody, txtUsername.getText().toString());
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                                stopLoadingWork();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.v("LOGIN ERROR", t.toString());
                            stopLoadingWork();
                        }
                    });
                }
            }
        });
    }

    public boolean CheckInternetPermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.INTERNET)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("PERMISSION", "Permission is granted");
                return true;
            } else {

                Log.v("PERMISSION", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("PERMISSION", "Permission is granted");
            return true;
        }
    }

    private void SetUserSession(LoginResponse model, String username) {
        SharedPreferences.Editor editor = usersession.edit();
        editor.putInt("userid", model.getUserId());
        editor.putInt("companyid", model.getCompanyId());
        editor.putInt("companyunitid", model.getCompanyUnitId());
        editor.putString("companyunitname", model.getCompanyUnitName());
        editor.putInt("finyearid", model.getFinyearId());
        editor.putString("finyearname", model.getFinyearName());
        editor.putString("username", username);
        editor.putBoolean("isloggedin", true);
        editor.commit();
    }

    private void doLoadingWork() {
        progressBar.setVisibility(View.VISIBLE);
        //txtUsername.setEnabled(false);
        //txtPassword.setEnabled(false);
        //btnLogin.setEnabled(false);

        for (int progress = 0; progress < 50; progress += 10) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void stopLoadingWork() {
        try {
            // txtUsername.setEnabled(true);
            // txtPassword.setEnabled(true);
            // btnLogin.setEnabled(true);
            progressBar.setProgress(0);
            progressBar.setVisibility(View.INVISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}