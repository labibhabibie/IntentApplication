package com.latihan.praktikum8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class RegistrationActivity extends AppCompatActivity
        implements View.OnClickListener {
    private EditText etName;
    private EditText etNIM;
    private EditText etPhone;
    private EditText etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        etName = findViewById(R.id.et_name);
        etNIM = findViewById(R.id.et_nim);
        etEmail = findViewById(R.id.et_email);
        etPhone = findViewById(R.id.et_phone_number);
        Button btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_next) {
// Ambil data dari EditText
            String name = etName.getText().toString().trim();
            String nim = etNIM.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String email = etEmail.getText().toString().trim();

// Pastikan seluruh EditText telah diisi
            boolean isEmptyField = false;
            if (name.isEmpty()) {
                etName.setError("Field harus diisi");
                isEmptyField = true;
            }if (nim.isEmpty()) {
                etNIM.setError("Field harus diisi");
                isEmptyField = true;
            }if (email.isEmpty()) {
                etEmail.setError("Field harus diisi");
                isEmptyField = true;
            }
            if (phone.isEmpty()) {
                etPhone.setError("Field harus diisi");
                isEmptyField = true;
            }
// Jika seluruh EditText telah diisi, pindah Activity
            if (!isEmptyField) {
                Intent detailIntent = new Intent(this,
                        DetailActivity.class);
                detailIntent.putExtra(DetailActivity.KEY_NAME, name);
                detailIntent.putExtra(DetailActivity.KEY_NIM, nim);
                detailIntent.putExtra(DetailActivity.KEY_PHONE,phone);
                detailIntent.putExtra(DetailActivity.KEY_EMAIL,email);
                startActivity(detailIntent);
            }
        }
    }
}