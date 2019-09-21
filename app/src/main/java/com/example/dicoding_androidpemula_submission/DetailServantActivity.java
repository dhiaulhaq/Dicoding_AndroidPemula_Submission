package com.example.dicoding_androidpemula_submission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailServantActivity extends RecyclerView.Adapter<ListServantAdapter.ListViewHolder> {
    private ArrayList<Servant> listServant;

    public DetailServantActivity(ArrayList<Servant> list){
        this.listServant = list;
    }

    @NonNull
    @Override
    public ListServantAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_servant, viewGroup, false);
        return new ListServantAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListServantAdapter.ListViewHolder holder, int position) {
        Servant servant = listServant.get(position);

        Glide.with(holder.itemView.getContext())
                .load(servant.getPhoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imgPhoto);

        holder.tvName.setText(servant.getName());
        holder.tvDescription.setText(servant.getDescription());

    }

    @Override
    public int getItemCount() {
        return listServant.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}
