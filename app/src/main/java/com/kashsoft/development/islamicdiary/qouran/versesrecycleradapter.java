package com.kashsoft.development.islamicdiary.qouran;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kashsoft.development.islamicdiary.R;

import java.util.ArrayList;

public class versesrecycleradapter extends RecyclerView.Adapter<versesrecycleradapter.viewholder> {
    ArrayList<String> verses;

    public versesrecycleradapter(ArrayList<String> verses) {
        this.verses = verses;
    }

    @NonNull
    @Override

    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_verses,viewGroup,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {
         String vers=verses.get(i);
         viewholder.name.setText(vers);
    }

    @Override
    public int getItemCount() {
        if(verses==null)return 0;
        return verses.size() ;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView name;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.sourcontent);

        }
    }
}
