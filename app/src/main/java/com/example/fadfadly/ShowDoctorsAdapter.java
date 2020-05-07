package com.example.fadfadly;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShowDoctorsAdapter extends RecyclerView.Adapter<ShowDoctorsAdapter.ViewHolder> {

    List<Doctors> items;
    public ShowDoctorsAdapter(List<Doctors> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_show_doctors , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doctors doctors = items.get(position);
        holder.name.setText(doctors.getName());
    }

    @Override
    public int getItemCount() {
        if(items == null) return 0;
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder (View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);

        }
    }
}
