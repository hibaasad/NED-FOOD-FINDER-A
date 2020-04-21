//package com.example.nedfoodfinder;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import com.google.firebase.auth.FirebaseAuth;
//
//
//public class RegActivity extends AppCompatActivity {
//    private EditText editTextMobile;
//    Button btn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_reg);
////        Ref= FirebaseDatabase.getInstance().getReference("Users");
//        editTextMobile = findViewById(R.id.editTextMobile);
//        btn = findViewById(R.id.buttoncon);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String mobile = editTextMobile.getText().toString().trim();
//                if(mobile.isEmpty() || mobile.length() < 10){
//                    editTextMobile.setError("Enter a valid mobile");
//                    editTextMobile.requestFocus();
//                    return;
//
//                Intent intent=new Intent(RegActivity.this,VerifyPhoneActivity.class);
//                intent.putExtra("mobile",mobile);
//                startActivity(intent);
//                String mobile = editTextMobile.getText().toString().trim();
//                if (mobile.isEmpty() || mobile.length() < 10) {
//                    editTextMobile.setError("Enter a valid mobile");
//                    editTextMobile.requestFocus();
//                    return;
//                }
////                Ref= FirebaseDatabase.getInstance().getReference("Users");
////
////                String id=Ref.push().getKey();
////                Users users=new Users(mobile);
////
////
////                 Ref.child(id).setValue(users);
//
//
//
//
//
//
//
//                Intent intent = new Intent(RegActivity.this, VerifyPhoneActivity.class);
//                intent.putExtra("mobile", mobile);
//                startActivity(intent);
//
////
////
////
//
//            }
//        });
//    }
//
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (FirebaseAuth.getInstance().getCurrentUser()!=null){
//            Intent intent=new Intent(RegActivity.this,WelcomeActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//
//
//        }
//    }
//}
//
//
//
//
