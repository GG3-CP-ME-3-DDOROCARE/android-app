package com.ddorocare.brand_audit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private View _bg__register_page;
    private ImageView logo_;
    private View _bg__nama_pengguna_atau_email_ek1;
    private View rectangle_6;
    private TextView ddrocare_gmail_com;
    private View _bg__kata_sandi_ek1;
    private View rectangle_7;
    private TextView ________________________;
    private View _bg__sign_in_ek1;
    private View rectangle_8;
    private TextView register;
    private TextView registrasi;
    private View rectangle_12;
    private View rectangle_13;
    private View rectangle_14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _bg__register_page = (View) findViewById(R.id._bg__register_page);
        logo_ = (ImageView) findViewById(R.id.logo_);
        _bg__nama_pengguna_atau_email_ek1 = (View) findViewById(R.id._bg__nama_pengguna_atau_email_ek1);
        rectangle_6 = (View) findViewById(R.id.rectangle_6);
        ddrocare_gmail_com = (TextView) findViewById(R.id.ddrocare_gmail_com);
        _bg__kata_sandi_ek1 = (View) findViewById(R.id._bg__kata_sandi_ek1);
        rectangle_7 = (View) findViewById(R.id.rectangle_7);
        ________________________ = (TextView) findViewById(R.id.________________________);
        _bg__sign_in_ek1 = (View) findViewById(R.id._bg__sign_in_ek1);
        rectangle_8 = (View) findViewById(R.id.rectangle_8);
        register = (TextView) findViewById(R.id.register);
        registrasi = (TextView) findViewById(R.id.registrasi);
        rectangle_12 = (View) findViewById(R.id.rectangle_12);
        rectangle_13 = (View) findViewById(R.id.rectangle_13);
        rectangle_14 = (View) findViewById(R.id.rectangle_14);

    }
}