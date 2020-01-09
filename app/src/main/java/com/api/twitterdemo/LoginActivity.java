package com.api.twitterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import businessll.LoginBll;
import strictmode.StrictModeClass;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText emails,passwords;
    private Button btnLogin;
    public static String Token = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emails=findViewById(R.id.email);
        passwords =findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        emails.setText("");
        passwords.setText("");


    }

    @Override
    public void onClick(View v) {

    login();

    }

    private void login(){
        String email= emails.getText().toString();
        String password=passwords.getText().toString();

        LoginBll loginBll=new LoginBll();
        StrictModeClass.StrictMode();
        if (loginBll.checkUser(email, password)) {
            Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            emails.requestFocus();
        }





    }


}
