package com.example.doctor;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Endocrinology extends AppCompatActivity {
    ListView myL_istView;
    String [] name = {"مصطفي", "عمرو", "خالد", "محمد", "علي", "عادل", "عبدالرحمن","احمد"," حسن","محمود","ابراهيم","مصطفي "};
    String[]subtitle = {"الغدد الصماء", "الغدد الصماء", "الغدد الصماء", "الغدد الصماء", "الغدد الصماء", "الغدد الصماء", "الغدد الصماء","الغدد الصماء","الغدد الصماء","الغدد الصماء","الغدد الصماء","الغدد الصماء"};
    String []address = {"المنيا", "القاهرة","المنيا", "المنيا", "القاهرة  ", "المنيا", "القاهرة","المنيا"," القاهرة","المنيا","القاهرة","المنيا "};
    String []phone = {"0105489416", "01222898698", "01295955251", "01154891651", "0189485198156  ", "01555898841", "01059416511","01555496200"," 0198522626626","010448409631","01092222000","01115862001 "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endocrinology);
        myL_istView=findViewById(R.id.myListView);
        MyListAdapter adapter = new MyListAdapter(this,name,subtitle,address,phone);
        myL_istView.setAdapter(adapter);
    }
}