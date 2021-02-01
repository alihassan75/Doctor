package com.example.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {

    Button btn_resetpassword;
    EditText ed_email;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        btn_resetpassword= findViewById(R.id.btn_resetpassword);
        ed_email = findViewById(R.id.ed_email);
        btn_resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recaverymemail= ed_email.getText().toString();
                Toast.makeText(ForgetPassword.this," من فضلك تحقق من بريدك الإلكتروني : "+ recaverymemail,Toast.LENGTH_LONG).show();
            }
        });

    }
}