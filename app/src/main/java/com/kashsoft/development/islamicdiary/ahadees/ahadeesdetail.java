package com.kashsoft.development.islamicdiary.ahadees;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.kashsoft.development.islamicdiary.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ahadeesdetail extends AppCompatActivity {
    static  int pos;
    String name;
    ArrayList<String> lines;
    RecyclerView recyclerView;
    TextView hadeesname;
     linesrecycleradapter linesrecycleradapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahadeesdetail);
        recyclerView=(RecyclerView)findViewById(R.id.ahadeesdetailrecycler2);
        hadeesname=(TextView)findViewById(R.id.hadeesname);

        pos=getIntent().getIntExtra("pos",-1);


        name=getIntent().getStringExtra("name");
        lines= readsourafromfile(("h")+(pos+1)+".txt");
        hadeesname.setText(name);
        linesrecycleradapter =new linesrecycleradapter(lines);
        layoutManager=new LinearLayoutManager(ahadeesdetail.this);
        recyclerView.setAdapter(linesrecycleradapter);
        recyclerView.setLayoutManager(layoutManager);






    }
    public ArrayList<String> readsourafromfile(String filename){
        BufferedReader reader = null;
        ArrayList<String>allvars=new ArrayList<>();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filename), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {

                allvars.add(mLine);

            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return allvars;
    }
}
