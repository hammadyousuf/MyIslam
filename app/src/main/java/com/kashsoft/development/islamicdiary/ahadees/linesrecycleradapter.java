package com.kashsoft.development.islamicdiary.ahadees;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kashsoft.development.islamicdiary.R;

import java.util.ArrayList;

public class linesrecycleradapter extends RecyclerView.Adapter<linesrecycleradapter.viewholder> {
    ArrayList<String> lines;

    public linesrecycleradapter(ArrayList<String> lines) {
        this.lines = lines;
    }

    @NonNull

    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlines,viewGroup,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {


            String line=lines.get(i);
            viewholder.name.setText(line);

        }

    @Override
    public int getItemCount() {
        if(lines==null)return 0;
        return lines.size() ;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView name;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.hadeescontent);

        }
    }
}
