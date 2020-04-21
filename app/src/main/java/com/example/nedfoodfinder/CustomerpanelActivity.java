package com.example.nedfoodfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class CustomerpanelActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mNavDrawer;
    NavigationView navigationView;
    ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);


        int images[]={R.drawable.auto1,R.drawable.auto2,R.drawable.auto3,R.drawable.auto4,R.drawable.auto5,R.drawable.auto6,R.drawable.auto7,R.drawable.auto8};
        viewFlipper=findViewById(R.id.flipper);



//        for (int i=0; i<images.length; i++){
//            flipperImages(images[i]);
//        }

        for (int image:images){
            flipperImages(image);
        }



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mNavDrawer = findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(CustomerpanelActivity.this, mNavDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mNavDrawer.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        if (mNavDrawer.isDrawerOpen(GravityCompat.START)) {
            mNavDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()){
            case R.id.Canteen:

//              String  container = (findViewById(R.id.fragment_container).toString().trim());


                //add fragment
//               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CanteenFragment()).commit();
                Intent canteen=new Intent(CustomerpanelActivity.this,CanteensActivity.class);
                startActivity(canteen);




                break;


            case R.id.Cart:
                Intent Cart=new Intent(CustomerpanelActivity.this,CartActivity.class);
                startActivity(Cart);
                break;



            case R.id.users:
                Intent userintent=new Intent(CustomerpanelActivity.this,TotalUserActivity.class);
                startActivity(userintent);
                break;





            case R.id.sign_out:
                logOut();
                return true;


            default:
                return false;



        }



       mNavDrawer.closeDrawer(GravityCompat.START);

        return true;
    }


    private void logOut(){
        FirebaseAuth.getInstance().signOut();
        sendToLogin();
    }


    private void sendToLogin(){
        Intent i=new Intent(CustomerpanelActivity.this,loginActivity.class);
        startActivity(i);
        finish();
    }



    public void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);


        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}


