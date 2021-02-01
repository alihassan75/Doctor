package com.example.doctor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
// اسنان
public class DoctorListOfNames extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ListView myListView;
    String[] categories={" الكل ","المنيا","القاهرة"};
    String [] name = {"علي", "محمود", "مصطفي", "محمد", "خالد  ", "عادل", "عبدالرحمن","احمد"," حسن","محمود","حسين","ابراهيم "};
    String[]subtitle = {"اسنان", "اسنان", " اسنان", "اسنان", "اسنان ", "اسنان", "اسنان","اسنان","اسنان","اسنان","اسنان","اسنان"};
    String []address = {"المنيا", "القاهرة","المنيا", "المنيا", "القاهرة  ", "المنيا", "القاهرة","المنيا"," القاهرة","المنيا","القاهرة","المنيا "};
    String []phone = {"0105489416", "01222898698", "01295955251", "01154891651", "0189485198156  ", "01555898841", "01059416511","01555496200"," 0198522626626","010448409631","01092222000","01115862001 "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list_of_names);
        Log.i("test","next activity started");
        myListView=findViewById(R.id.myListView);
        MyListAdapter adapter = new MyListAdapter(this,name,subtitle,address,phone);
        myListView.setAdapter(adapter);
//        mySpinner = findViewById(R.id.mySpinner);
//        myListView = findViewById(R.id.myListView);
//
//        mySpinner.setAdapter(
//                new ArrayAdapter<>(this, R.layout.list_view_namedesign, categories));
//
//        myListView.setAdapter(
//                new ArrayAdapter<>(this, R.layout.list_view_namedesign, getCosmicBodies()));
//        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemID) {
//                if (position >= 0 && position < categories.length) {
//                    getSelectedCategoryData(position);
//                } else {
//                    Toast.makeText(DoctorListOfNames.this, "Selected Category Does not Exist!", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,categories[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /*
    Initialize ListView and Spinner, set their adapters and listen to spinner itemSelection events
    *//*
    Populate an arraylist that will act as our data source.
     */
//    private ArrayList<CosmicBody> getCosmicBodies() {
//        Log.i("test","array list");
//        ArrayList<CosmicBody> data = new ArrayList<>();
//        data.clear();
//
//        data.add(new CosmicBody(" ميدو","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" علي","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" احمد","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" خالد","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" مصطفي","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" ابراهيم","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" عبدالحليم","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" تامر","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" حسن","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" محمد","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" حسين","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" محمود","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" عبدالله","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" علاء","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" اسلام","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" اشرف","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" عمرو","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" زياد","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" زيدان","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" صلاح","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" حامد","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" عاطف","اسنان","القاهرة", "01041894161",2));
//        data.add(new CosmicBody(" فتحي","اسنان","المنيا", "01041894161",1));
//        data.add(new CosmicBody(" وليد","اسنان","القاهرة", "01041894161",2));
//        Log.i("test","data added");
//        return data;
//    }
    /*
    Get the selected category's cosmic bodies and bind to ListView
     */
//    private void getSelectedCategoryData(int categoryID) {
//        Log.i("test","getSelectedCategoryData");
//        //arraylist to hold selected cosmic bodies
//        ArrayList<CosmicBody> cosmicBodies = new ArrayList<>();
//        if(categoryID == 0)
//        {
//            //TODO:a change made here ro be traced
//            adapter = new ArrayAdapter<>(this,R.layout.list_view_namedesign,getCosmicBodies());
//        }else{
//            //filter by id
//            for (CosmicBody cosmicBody : getCosmicBodies()) {
//                if (cosmicBody.getCategoryId() == categoryID) {
//                    cosmicBodies.add(cosmicBody);
//                }
//            }
//            //instatiate adapter a
//            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cosmicBodies);
//        }
//        //set the adapter to GridView
//        myListView.setAdapter(adapter);
//    }

    }

//class CosmicBody {
//    private String name;
//    private String Department;
//    private String Address;
//    private String Phone;
//    private int categoryID;
//
//    public String getName() {
//        return name;
//    }
//    public String getDepartment(){
//        return Department;
//    }
//    public String getAddress(){
//        return Address;
//    }
//    public String getPhone(){
//        return Phone;
//    }
//
//    public int getCategoryId() {
//        return categoryID;
//    }
//
//    public CosmicBody(String name, String department, String address, String phone, int categoryID) {
//        this.name = name;
//        Department = department;
//        Address = address;
//        Phone = phone;
//        this.categoryID = categoryID;
//    }
//
//    @Override
//    public String toString() {
//        return "CosmicBody{" +
//                "name='" + name + '\'' +
//                ", Department='" + Department + '\'' +
//                ", Address='" + Address + '\'' +
//                ", Phone='" + Phone + '\'' +
//                ", categoryID=" + categoryID +
//                '}';
//    }
//}