package com.example.doctor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] name;
    private final String[] subtitle;
    private final String[] address;
    private final String[] phone;

    public MyListAdapter(Activity context, String[] name,String[] subtitle,String[]address,String[] phone ) {
        super(context, R.layout.mylist, name);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.name=name;
        this.subtitle=subtitle;
        this.address=address;
        this.phone=phone;


    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.Depertment);
        TextView addressText = (TextView) rowView.findViewById(R.id.Address);
        TextView phoneText = (TextView) rowView.findViewById(R.id.Phone);

        titleText.setText(name[position]);
        subtitleText.setText(subtitle[position]);
        addressText.setText(address[position]);
        phoneText.setText(phone[position]);

        return rowView;

    };
}