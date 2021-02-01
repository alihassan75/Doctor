package com.example.doctor;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ObstetricsAndGynecology extends Activity {

    ListView myL_istView;
    String [] name = {"حسين", "عمر", "مصطفي", "محمد", "علي", "عادل", "عبدالرحمن","احمد"," حسن","محمود","ابراهيم","خالد "};
    String[]subtitle = {"نساء وتوليد", "نساء وتوليد", "نساء وتوليد", "نساء وتوليد", "نساء وتوليد", "نساء وتوليد", "نساء وتوليد","نساء وتوليد","نساء وتوليد","نساء وتوليد","نساء وتوليد","نساء وتوليد"};
    String []address = {"المنيا", "القاهرة","المنيا", "المنيا", "القاهرة  ", "المنيا", "القاهرة","المنيا"," القاهرة","المنيا","القاهرة","المنيا "};
    String []phone = {"0105489416", "01222898698", "01295955251", "01154891651", "0189485198156  ", "01555898841", "01059416511","01555496200"," 0198522626626","010448409631","01092222000","01115862001 "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list2);
        myL_istView=findViewById(R.id.myListView);
        MyListAdapter adapter = new MyListAdapter(this,name,subtitle,address,phone);
        myL_istView.setAdapter(adapter);
    }
}