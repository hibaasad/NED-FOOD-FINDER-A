package com.example.nedfoodfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    ImageView logo;
    Animation animation;



//    FirebaseAuth mAuth;


    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.logo);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        logo.startAnimation(animation);
//        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("Customer");
//            databaseReference.addValueEventListener(new ValueEventListener() {
//                String phone = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//
//                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                      String number = snapshot.child("number").getValue().toString();
//
//
//                              if (number==phone) {
//                                  Thread timer =new Thread(){
//                                      @Override
//                                      public void run() {
//                                          try {
//                                              sleep(3000);
//
//                                              Intent i = new Intent(MainActivity.this, CustomerpanelActivity.class);
//                                              i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                              startActivity(i);
//                                              finish();
//                                              super.run();
//
//
//                                          } catch (InterruptedException e) {
//                                              e.printStackTrace();
//                                          }
//
//
//
//                                      }
//                                  };
//                                  timer.start();
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//                                }
//
//
//                            }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//                }
//
//
//
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//
//
//        });
//
//    }
//        if (FirebaseAuth.getInstance().getCurrentUser() != null){
//            databaseReference = FirebaseDatabase.getInstance().getReference().child("Admin");
//            databaseReference.addValueEventListener(new ValueEventListener() {
//        String phone = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                        String number = snapshot.child("number").getValue().toString();
//
//
//                        if (number==phone) {
//                            Thread timer =new Thread(){
//                                @Override
//                                public void run() {
//                                    try {
//                                        sleep(3000);
//
//                                        Intent i = new Intent(MainActivity.this, AdminpanelActivity.class);
//                                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                        startActivity(i);
//                                        finish();
//                                        super.run();
//
//
//                                    } catch (InterruptedException e) {
//                                        e.printStackTrace();
//                                    }
//
//
//
//                                }
//                            };
//                            timer.start();
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//                        }
//
//
//
//
//
//
//
//
//
//
//                    }
//
//
//
//
//
//
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//
//
//
//
//
//
//
//
//
//
//
//
//
//





        Thread timer=new Thread() {
            @Override
            public void run() {
                try{
                    sleep(5000);

                    Intent reg = new Intent(MainActivity.this, loginActivity.class);
                    startActivity(reg);
                    finish();
                    super.run();
                } catch (Exception e) {
                    e.printStackTrace();
                                }







                            }
                        };
                        timer.start();




}

}
