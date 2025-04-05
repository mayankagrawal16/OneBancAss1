package com.mayank.onebancassignment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder> {

    private List<Cuisine> cuisineList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Cuisine cuisine);
    }

    public CuisineAdapter(List<Cuisine> cuisineList, OnItemClickListener listener) {
        this.cuisineList = cuisineList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CuisineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuisine_card, parent, false);
        return new CuisineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CuisineViewHolder holder, int position) {
        Cuisine cuisine = cuisineList.get(position);
        holder.cuisineName.setText(cuisine.getName());
        holder.cuisineImage.setImageResource(cuisine.getImageResId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(cuisine);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cuisineList.size();
    }

    public static class CuisineViewHolder extends RecyclerView.ViewHolder {
        ImageView cuisineImage;
        TextView cuisineName;

        public CuisineViewHolder(@NonNull View itemView) {
            super(itemView);
            cuisineImage = itemView.findViewById(R.id.cuisine_image);
            cuisineName = itemView.findViewById(R.id.cuisine_name);
        }
    }
}
