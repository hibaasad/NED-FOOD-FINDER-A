package com.example.nedfoodfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Locale;


public class loginActivity extends AppCompatActivity {
    EditText text;
    Button con;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        text = findViewById(R.id.mob);

        con = findViewById(R.id.cont);



        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = text.getText().toString().trim();
                if (mobile.isEmpty() || mobile.length() < 10) {
                    text.setError("Enter a valid mobile");
                    text.requestFocus();
                    return;
                }
                databaseReference=FirebaseDatabase.getInstance().getReference("Users");
                User user=new User(mobile);
                user.setNumber(mobile);
                String id=databaseReference.push().getKey();
                databaseReference.child(id).setValue(user);
                Intent i=new Intent(loginActivity.this,VerifyPhoneActivity.class);
                i.putExtra("mobile",mobile);

                startActivity(i);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
              if (FirebaseAuth.getInstance().getCurrentUser()!=null){
                  Intent intent=new Intent(loginActivity.this,WelcomeActivity.class);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                  startActivity(intent);
              }
    }
}







