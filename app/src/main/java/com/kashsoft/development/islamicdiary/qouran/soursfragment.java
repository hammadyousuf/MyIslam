package com.kashsoft.development.islamicdiary.qouran;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kashsoft.development.islamicdiary.R;
import com.kashsoft.development.islamicdiary.constants;

public class soursfragment extends Fragment {
    RecyclerView recyclerView;
    soura_reycleradapeter adapter;
    RecyclerView.LayoutManager layoutManager;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.activity_sours,container,false);
        recyclerView=view.findViewById(R.id.recyclerview);


        adapter=new soura_reycleradapeter(constants.ArSuras);

        adapter.setOnitemclicklistenter(new soura_reycleradapeter.Onitemclicklistenter() {
            @Override
            public void onitemclick(int pos, String names) {
                Intent intent=new Intent(getActivity(),souradetailactivity.class);
                intent.putExtra("pos",pos);
                intent.putExtra("name",names);
                startActivity(intent);

            }


        });
        layoutManager=new GridLayoutManager(getContext() ,3,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;

    }
}
