package com.example.nedfoodfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CanteensActivity extends AppCompatActivity {
    TextView Mech ,Sfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteens);

        Mech=findViewById(R.id.one);
        Sfc=findViewById(R.id.two);
        Mech.setText("MECHCORNER");
        Sfc.setText("SFC");



        Mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CanteensActivity.this,MechActivity.class);
                startActivity(i);
                finish();
            }
        });




        Sfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CanteensActivity.this,SFCActivity.class);
                startActivity(i);
                finish();
            }
        });


    }







}
