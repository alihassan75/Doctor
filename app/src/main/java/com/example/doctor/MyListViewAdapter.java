package com.example.doctor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyListViewAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] fullName;

    public MyListViewAdapter(Activity context, String[] fullName) {
        super(context, R.layout.list_view_design,fullName);
        this.context = context;
        this.fullName = fullName;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_view_design, null,true);
        TextView titleText = (TextView) rowView.findViewById(R.id.lsitofitem);
        titleText.setText(fullName[position]);
        return rowView;

    };
}
