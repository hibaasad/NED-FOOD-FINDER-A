package com.example.nedfoodfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SFCActivity extends AppCompatActivity {
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfc);

        final ArrayList<String> food=new ArrayList<String>();

        final ArrayList<String> price=new ArrayList<String>();

//
//       final ListView list1=(ListView)findViewById(R.id.lists1);
//        final ListView list2=(ListView)findViewById(R.id.lists2);
//        final ArrayList<HashMap<String,String>>mylist=new ArrayList<HashMap<String, String>>();
//         final HashMap<String,String>map=new HashMap<String, String>();
//          final ArrayList<String> from=new ArrayList<String>();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Canteens").child("SFC");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    String key=dataSnapshot1.getKey();
                    String value=dataSnapshot1.getValue().toString();
//                    from.add(key);
                    food.add(key);
                    price.add(value);
//
//
//                    map.put(key,value);
//                    mylist.add(map);




                }
//                mylist.add(map);
//                Object[] objArr=from.toArray();
//                String[] start= Arrays.copyOf(objArr,objArr.length,String[].class);
//                int []to= new int[]{R.id.shakes,R.id.price};
//
//
//                SimpleAdapter simpleAdapter=new SimpleAdapter(getBaseContext(),mylist,R.layout.row,start,to);
//                list.setAdapter(simpleAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        Object[] objArr=from.toArray();
//         String[] start= Arrays.copyOf(objArr,objArr.length,String[].class);
//        int []to= new int[]{R.id.shakes,R.id.price};
//
//
//        SimpleAdapter simpleAdapter=new SimpleAdapter(getBaseContext(),mylist,android.R.layout.simple_list_item_2,start,to);
//
//
//
//    list.setAdapter(simpleAdapter);




        ListView view1=(ListView)findViewById(R.id.Lists1);
        ListView view2=(ListView)findViewById(R.id.Lists2);
        ArrayAdapter<String> foodAdaper=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,food);
        view1.setAdapter(foodAdaper);
        ArrayAdapter<String> priceAdaper=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,price);
        view2.setAdapter(priceAdaper);


               databaseReference=FirebaseDatabase.getInstance().getReference("Order");

             view1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                 @Override
                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     String selaectedItem=(String) parent.getItemAtPosition(position);

                     StyleableToast.makeText(SFCActivity.this,selaectedItem + " Add to Cart" ,R.style.exampleToast).show();
                     Order order= new Order(selaectedItem);
                     order.setItems(selaectedItem);
                     String unique=databaseReference.push().getKey();
                     databaseReference.child(unique).setValue(order);


                 }
             });

        }



    }

