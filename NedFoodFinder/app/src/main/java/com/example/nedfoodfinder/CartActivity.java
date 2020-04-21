package com.example.nedfoodfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    Button orderplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        final ArrayList<String>Items=new ArrayList<String>();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Order");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    String items=dataSnapshot1.child("items").getValue().toString();
                    Items.add(items);


                }

                 orderplace=findViewById(R.id.confirmorder);

                ListView viewCart=(ListView)findViewById(R.id.cartlists);
                ArrayAdapter<String>CartAddapter=new ArrayAdapter<String>(CartActivity.this,android.R.layout.simple_list_item_1,Items);
                viewCart.setAdapter(CartAddapter);
                orderplace.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StyleableToast.makeText(CartActivity.this,"The order is placed",R.style.pinktoast).show();
                        DatabaseReference dbNode=FirebaseDatabase.getInstance().getReference().getRoot().child("Order");
                        dbNode.setValue(null);
                        Intent myloc=new Intent(CartActivity.this,MapsActivity.class);
                        startActivity(myloc);
                    }
                });













            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//
//        ArrayAdapter<String>CartAddapter=new ArrayAdapter<String>(CartActivity.this,android.R.layout.simple_list_item_1,Items);
//        ListView viewCart=(ListView)findViewById(R.id.cartlist);


    }
}
