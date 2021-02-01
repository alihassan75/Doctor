package com.example.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class List_of_Medical_Specialties extends AppCompatActivity {
    //    ListView list_View;
    String listItem[] = {"اسنان", "نفسي", "نساء وتوليد", "العظام", "الانف والاذن ", "القلب", "جلدية", "جراحة التجميل", " الجراحة العامة", "الغدد الصماء", "تخاطب", "مسالك بولية"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of__medical__specialties);

        listView = findViewById(R.id.listView);
        MyListViewAdapter adapter = new MyListViewAdapter(this, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(List_of_Medical_Specialties.this, listItem[position], Toast.LENGTH_SHORT).show();
                Log.i("test", "Intent started");

                if (position == 0) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, DoctorListOfNames.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, DoctorList2.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, ObstetricsAndGynecology.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, Orthopedics.class);
                    startActivity(intent);
                } else if (position == 4) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, EarNoseAndThroatENT.class);
                    startActivity(intent);
                } else if (position == 5) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, Urology.class);
                    startActivity(intent);
                } else if (position == 6) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, Dermatology.class);
                    startActivity(intent);
                } else if (position == 7) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, plasticSurgery.class);
                    startActivity(intent);
                } else if (position == 8) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, GeneralSurgery.class);
                    startActivity(intent);
                } else if (position == 9) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, Endocrinology.class);
                    startActivity(intent);
                } else if (position == 10) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, SpeechLanguage.class);
                    startActivity(intent);
                } else if (position == 11) {
                    Intent intent = new Intent(List_of_Medical_Specialties.this, CardiacSurgery.class);
                    startActivity(intent);
                }


                Log.i("test", "Activity Start finished");
            }
        });
    }

    @Override
    public void onBackPressed() {
        FirebaseAuth auth;
        auth = FirebaseAuth.getInstance();
        auth.signOut();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
//                finish();
//        super.onBackPressed();
        finish();
    }
}
