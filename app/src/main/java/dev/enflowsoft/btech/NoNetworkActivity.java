package dev.enflowsoft.btech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoNetworkActivity extends AppCompatActivity {

    private Button btnRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_network);
        btnRetry = (Button) findViewById(R.id.btnRetry);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartApp();
            }
        });
    }

    private void restartApp() {
        startActivity(new Intent(NoNetworkActivity.this, LoginActivity.class));
        finish();
    }
}