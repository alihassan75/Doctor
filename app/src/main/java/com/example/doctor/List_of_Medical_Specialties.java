package com.example.doctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class List_of_Medical_Specialties extends AppCompatActivity {
    //    ListView list_View;
    String listItem[] = {"اسنان", "نفسي", "نساء وتوليد", "العظام", "الانف والاذن ", "القلب", "جلدية", "جراحة التجميل", " الجراحة العامة", "الغدد الصماء", "تخاطب", "مسالك بولية"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of__medical__specialties);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
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

//    @Override
//    public void onBackPressed() {
//        FirebaseAuth auth;
//        auth = FirebaseAuth.getInstance();
//        auth.signOut();
//        finish();
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(intent);
//        super.onBackPressed();
////        finish();
//    }

//    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder alertdialog=new AlertDialog.Builder(this);
//        alertdialog.setTitle("تحذير");
//        alertdialog.setMessage("هل تريد اغلاق التطبيق");
//        alertdialog.setPositiveButton("نعم", new DialogInterface.OnClickListener(){
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
////                FirebaseDatabase.getInstance().goOffline();
//                FirebaseAuth auth;
//                auth = FirebaseAuth.getInstance();
//                auth.signOut();
//                System.exit(0);
//                finish();
////                Intent intent=new Intent(List_of_Medical_Specialties.this,MainActivity.class);
////                startActivity(intent);
////                List_of_Medical_Specialties.this.finish();
//            }
//        });
//
//        alertdialog.setNegativeButton("لا", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//
//        AlertDialog alert=alertdialog.create();
//        alertdialog.show();
//
//    }
    public abstract static class BaseActivity extends Activity {

        private static BaseActivity lastPausedActivity = null;

        @Override
        protected void onPause() {

            super.onPause();
            lastPausedActivity = this;
        }

        @Override
        protected void onResume() {

            super.onResume();
            if(this == lastPausedActivity) {
                lastPausedActivity = null;
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                startActivity( intent );
            }
        }
    }
}
