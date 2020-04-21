package com.example.nedfoodfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class check extends AppCompatActivity {
    TextView show;
    Button btn;
    EditText a;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        show=findViewById(R.id.textView4);
        a=findViewById(R.id.editText3);
        btn=findViewById(R.id.button2);
//        String phone=a.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
//            String phone=a.getText().toString();
            @Override
            public void onClick(View v) {
                User user=null;
           databaseReference=FirebaseDatabase.getInstance().getReference().child("Customer");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    String phone=a.getText().toString();
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                        databaseReference=FirebaseDatabase.getInstance().getReference("Users");
//                        List<String> AdminUID=new ArrayList<>();
////                     AdminUID.add(dataSnapshot.getValue.toString());
//                  String a=dataSnapshot.getChildren().toString();
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            String number =snapshot.child("number").getValue().toString();
//                            String number=user.getNumber();
                            if (number.equals(phone)){


                                show.setText("yes");

                            }


                        }







                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {


                    }
                });

            }
        });



    }
}
