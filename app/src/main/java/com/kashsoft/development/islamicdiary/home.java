package com.kashsoft.development.islamicdiary;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.kashsoft.development.islamicdiary.ahadees.ahadeesfragment;
import com.kashsoft.development.islamicdiary.qouran.soursfragment;

public class home extends AppCompatActivity {

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int id=menuItem.getItemId();
            Fragment fragment=null;
            if(id==R.id.qouran){
                fragment=new soursfragment();

            }else if(id==R.id.ahades){
                fragment=new ahadeesfragment();



            }
                getSupportFragmentManager().beginTransaction().replace(R.id.containerfragment,fragment).commit();

            return false;
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navview = (BottomNavigationView) findViewById(R.id.navview);
      navview.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }
}
