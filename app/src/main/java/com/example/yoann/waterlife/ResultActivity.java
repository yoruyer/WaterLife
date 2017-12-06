package com.example.yoann.waterlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void GoBack(View view) {
        startActivity(new Intent(ResultActivity.this, MainActivity.class));
    }

    public void runAgain(View view) {
        startActivity(new Intent(ResultActivity.this, LoadScreen.class));
    }
}
