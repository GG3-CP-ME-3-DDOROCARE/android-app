package com.ddorocare.brand_audit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private View _bg__login_page;
    private ImageView logo_;
    private View _bg__nama_pengguna_atau_email_ek1;
    private View rectangle_6;
    private TextView email;
    private View _bg__kata_sandi_ek1;
    private View rectangle_7;
    private TextView kata_sandi_ek2;
    private TextView lupa_kata_sandi_;
    private View _bg__sign_in_ek1;
    private View rectangle_8;
    private TextView sign_in_ek2;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _bg__login_page = (View) findViewById(R.id._bg__login_page);
        logo_ = (ImageView) findViewById(R.id.logo_);
        _bg__nama_pengguna_atau_email_ek1 = (View) findViewById(R.id._bg__nama_pengguna_atau_email_ek1);
        rectangle_6 = (View) findViewById(R.id.rectangle_6);
        email = (TextView) findViewById(R.id.email);
        _bg__kata_sandi_ek1 = (View) findViewById(R.id._bg__kata_sandi_ek1);
        rectangle_7 = (View) findViewById(R.id.rectangle_7);
        kata_sandi_ek2 = (TextView) findViewById(R.id.kata_sandi_ek2);
        lupa_kata_sandi_ = (TextView) findViewById(R.id.lupa_kata_sandi_);
        _bg__sign_in_ek1 = (View) findViewById(R.id._bg__sign_in_ek1);
        rectangle_8 = (View) findViewById(R.id.rectangle_8);
        sign_in_ek2 = (TextView) findViewById(R.id.sign_in_ek2);
        login = (TextView) findViewById(R.id.login);
    }
}