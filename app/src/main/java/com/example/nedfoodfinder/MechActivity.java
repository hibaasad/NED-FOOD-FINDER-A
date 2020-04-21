package com.example.nedfoodfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;

public class MechActivity extends AppCompatActivity {
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech);

        final ArrayList<String> food=new ArrayList<String>();
        final ArrayList<String>price=new ArrayList<>();
         databaseReference= FirebaseDatabase.getInstance().getReference().child("Canteens").child("MechCorner");
         databaseReference.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                     String key=dataSnapshot1.getKey();
                     String value=dataSnapshot1.getValue().toString();
                     food.add(key);
                     price.add(value);

                 }




             }







             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }

         });



         ListView view1=(ListView)findViewById(R.id.Lists2);
        ListView  view2=(ListView)findViewById(R.id.Lists3);
         ArrayAdapter<String>foodAdaper=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,food);
         view1.setAdapter(foodAdaper);
        ArrayAdapter<String>priceAdaper=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,price);
        view2.setAdapter(priceAdaper);
        databaseReference=FirebaseDatabase.getInstance().getReference("Order");
        view1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selaectedItem=(String) parent.getItemAtPosition(position);
                StyleableToast.makeText(MechActivity.this,selaectedItem + " Add to Cart" ,R.style.exampleToast).show();
                Order order= new Order(selaectedItem);
                order.setItems(selaectedItem);
                String unique=databaseReference.push().getKey();
                databaseReference.child(unique).setValue(order);






            }
        });










    }






}








