package com.latihan.praktikum8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity implements
        View.OnClickListener {
// Deklarasi variabel kunci yang akan digunakan untuk bertukar informasi
    public static final String KEY_NAME = "key_name";
    public static final String KEY_NIM = "key_nim";
    public static final String KEY_PHONE = "key_phone";
    public static final String KEY_EMAIL = "key_email";

    private String phoneNumber;
    private String Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvNIM = findViewById(R.id.tv_nim);
        TextView tvEmail = findViewById(R.id.tv_email);
        TextView tvPhone = findViewById(R.id.tv_phone);
// Button
        Button btnPhoneCall = findViewById(R.id.btn_phone_call);
        Button btnEmail = findViewById(R.id.btn_send_email);


// Mengambil data dari Intent
        String name = getIntent().getStringExtra(KEY_NAME);
        String nim = getIntent().getStringExtra(KEY_NIM);
        String phone = getIntent().getStringExtra(KEY_PHONE);
        String email = getIntent().getStringExtra(KEY_EMAIL);

// Memasukkan data ke view
        tvName.setText(String.format("Nama: %s", name));
        tvNIM.setText(String.format("NIM: %s", nim));
        tvEmail.setText(String.format("Email: %s",email));
        tvPhone.setText(String.format("No. HP: %s", phone));

        phoneNumber = phone;
        Email = email;

        btnPhoneCall.setOnClickListener(this);
        btnEmail.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_send_email){
            Intent sendEmailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",Email,null));
            sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT,"Intent");
            startActivity(sendEmailIntent);

        }
        if (view.getId() == R.id.btn_phone_call) {
            Intent callPhoneIntent = new Intent();
            callPhoneIntent.setAction(Intent.ACTION_DIAL);
            callPhoneIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callPhoneIntent);
        }
    }
}