package com.api.twitterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnSign;
    private Button btnlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        btnSign =findViewById(R.id.btnSign);
        btnlog = findViewById(R.id.btnlog);

        btnSign.setOnClickListener(this);
        btnlog.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnSign:
                Intent intent = new Intent(HomeActivity.this,SignupActivity.class);
                startActivity(intent);
                finish();

                break;


            case R.id.btnlog:

                Intent intents =new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intents);
                finish();
        }



    }
}
