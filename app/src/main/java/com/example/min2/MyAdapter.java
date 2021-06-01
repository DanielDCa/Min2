package com.example.min2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<User> users;
    private Context context;
    private List<Badges> badges;

    public void setData (List<Badges> badges ){
        this.badges = badges;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false));
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Badges badge = badges.get(position);
        String nombre = badge.getName();
        String url = badge.getUrl();
        Log.i("G4",""+badge.getUrl());
        Log.i("G4",""+badge.getName());

        holder.nombre.setText(nombre);
        //holder.lenguage.setText(url);

    }

    @Override
    public int getItemCount() {
        return badges.size();
    }



    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView imagen;
        TextView nombre;
        public View layout;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            layout = itemView;

            imagen = itemView.findViewById(R.id.icon);
            nombre = itemView.findViewById(R.id.firstLine);

        }
    }

}
