package com.example.user.spinnerapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BrandAdapter extends ArrayAdapter<SpinnerModel>{

    public BrandAdapter(Context context,ArrayList<SpinnerModel> brandlist) {
        super(context, R.layout.spinner_row, brandlist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position,View convertView,ViewGroup parent){
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.spinner_row,parent,false);
        }
        ImageView imageLogo =convertView.findViewById(R.id.image);
        TextView textName =convertView.findViewById(R.id.name);
        TextView textSite =convertView.findViewById(R.id.site);

        SpinnerModel spinnerModel =getItem(position);
        if(spinnerModel!=null){
            imageLogo.setImageResource(spinnerModel.getImage());
            textName.setText(spinnerModel.getName());
            textSite.setText(spinnerModel.getSite());
        }

        return convertView;
    }
}
