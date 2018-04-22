package com.example.user.spinnerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    private ArrayList<SpinnerModel> brandList;
    private BrandAdapter brandAdapter;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner();
        customSpinner();
    }

    private void customSpinner() {
        spinner2=findViewById(R.id.spinner2);
        int imj=0;
        brandList=new ArrayList<>();

        for(int i=0;i<8;i++){
            switch (i){
                case 0:
                    imj=R.mipmap.facebook;
                    break;
                case 1:
                    imj=R.mipmap.instagram;
                    break;
                case 2:
                    imj=R.mipmap.linkedin;
                    break;
                case 3:
                    imj=R.mipmap.skype;
                    break;
                case 4:
                    imj=R.mipmap.snapchat;
                    break;
                case 5:
                    imj=R.mipmap.twitter;
                    break;
                case 6:
                    imj=R.mipmap.whatsapp;
                    break;
                case 7:
                    imj=R.mipmap.youtube;
                    break;
            }
            brandList.add(new SpinnerModel(getResources().getStringArray(R.array.social_media)[i],imj,getResources().getStringArray(R.array.social_media_link)[i]));
        }
        brandAdapter=new BrandAdapter(this,brandList);
        spinner2.setAdapter(brandAdapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerModel spinnerModel = (SpinnerModel) parent.getItemAtPosition(position);
                Toast.makeText(getBaseContext(),spinnerModel.getName()+" is Selected.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void spinner() {
        spinner=findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.social_media,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" is Selected.",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
