package com.example.nedfoodfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class WelcomeActivity extends AppCompatActivity {
    RadioButton Admin ,Customer;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Admin=findViewById(R.id.adpanel);
        Customer=findViewById(R.id.cuspanel);
        go=findViewById(R.id.button3);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        if(Admin.isChecked() && Customer.isChecked()){
            StyleableToast.makeText(WelcomeActivity.this,"checked one",R.style.exampleToast).show();
        }
        else if (Admin.isChecked() &&  !(Customer.isChecked())){
            Intent i =new Intent(WelcomeActivity.this,AdminpanelActivity.class);
            startActivity(i);
            finish();


}
        else if (!(Admin.isChecked()) &&  Customer.isChecked()){
                Intent go =new Intent(WelcomeActivity.this,CustomerpanelActivity.class);
        startActivity(go);
        finish();}


            }
        });
//        if(Admin.isChecked() && Customer.isChecked()){
//            Toast.makeText(WelcomeActivity.this,"checked one",Toast.LENGTH_LONG).show();
//        }
//        else if (Admin.isChecked() &&  !(Customer.isChecked())){
//            Intent i =new Intent(WelcomeActivity.this,CustomerpanelActivity.class);
//            startActivity(i);
//    finish();
//
//
//}
//        else if (!(Admin.isChecked()) &&  Customer.isChecked()){
//                Intent go =new Intent(WelcomeActivity.this,AdminpanelActivity.class);
//        startActivity(go);
//        finish();}



        }


}
