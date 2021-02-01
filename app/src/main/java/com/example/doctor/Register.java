package com.example.doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    String fullname,emailaddres,phonenoumber,password,conformepassword;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    Button register;
    TextView areadyhavaaccount;
    private FirebaseUser user;
    EditText etEmailAderss,etPassword,etConformpassword,etPhone,etFullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register=findViewById(R.id.btn_register);
        etFullname=findViewById(R.id.full_name);
        etEmailAderss=findViewById(R.id.email_adress);
        etPhone=findViewById(R.id.phone_number);
        etPassword=findViewById(R.id.password);
        etConformpassword=findViewById(R.id.confirm_password);
        areadyhavaaccount = findViewById(R.id.tv_areadyhavaaccount);
        areadyhavaaccount.setPaintFlags(areadyhavaaccount.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        areadyhavaaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent areadyhavaacount = new Intent(Register.this, MainActivity.class);
                startActivity(areadyhavaacount);
            }

        });
        AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.full_name,"^[\\p{L} .'-]+$",R.string.full_name);
        awesomeValidation.addValidation(this,R.id.phone_number,"^\\+(?:[0-9] ?){6,14}[0-9]$",R.string.phone_number);
        awesomeValidation.addValidation(this,R.id.email_adress, "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",R.string.email_adresse);
        awesomeValidation.addValidation(this,R.id.password,"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",R.string.password);
        mAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");
        awesomeValidation.addValidation(this,R.id.confirm_password,R.id.password,R.string.conform_password);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    fullname = etFullname.getText().toString().trim();
                    emailaddres = etEmailAderss.getText().toString().trim();
                    phonenoumber = etPhone.getText().toString().trim();
                    password = etPassword.getText().toString().trim();
                    conformepassword = etConformpassword.getText().toString().trim();

                    if (awesomeValidation.validate()) {
                        mAuth.createUserWithEmailAndPassword(emailaddres, password)
                                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            user = task.getResult().getUser();
                                            UserProfileChangeRequest ProfileChangeRequest = new UserProfileChangeRequest.Builder()
                                                    .setDisplayName(etFullname.getText().toString())
                                                    .build();
                                            user.updateProfile(ProfileChangeRequest);
                                            DatabaseReference newUser = databaseReference.child(user.getUid());
                                            newUser.child("Full Name").setValue(fullname);
                                            newUser.child("Email Address").setValue(emailaddres);
                                            newUser.child("Phone Number").setValue(phonenoumber);
                                            newUser.child("Password").setValue(password);

                                            Toast.makeText(Register.this, "Registration Successfully", Toast.LENGTH_LONG).show();
                                            Intent goToLogin = new Intent(Register.this, List_of_Medical_Specialties.class);
                                            startActivity(goToLogin);
                                            finish();

                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Toast.makeText(Register.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                                        }

                                        // ...
                                    }
                                });

                }
            }
        });



    }
}