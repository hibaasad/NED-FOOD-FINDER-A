package com.example.nedfoodfinder;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;




public class UserFragment extends Fragment {


    DatabaseReference databaseReference;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_user, container, false);
        final ArrayList<String>menuItem=new ArrayList<String>();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("Users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data :dataSnapshot.getChildren()){
                    String no=data.child("number").getValue().toString();
                    menuItem.add(no);
                }
                ArrayList<String>ab=menuItem;
                ListView listView=(ListView)view.findViewById(R.id.mainmenu);
                ArrayAdapter<String>listViewAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ab);
                listView.setAdapter(listViewAdapter);

            }







            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {



            }
        });

//
//        ListView listView=(ListView)view.findViewById(R.id.mainmenu);
//        ArrayAdapter<String>listViewAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ab);
//        listView.setAdapter(listViewAdapter);



        return view;
    }


    }

