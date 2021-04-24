package com.example.breathforme.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breathforme.R;

import java.util.ArrayList;

public class LikedAdapter extends RecyclerView.Adapter<LikedAdapter.ViewHolder> {

    private ArrayList<LikedItem> likedItems;
    private ItemClickListener itemClickListener;
    public int rowPosition;
    private Context context;

    public LikedAdapter(ArrayList<LikedItem> likedItems, ItemClickListener itemClickListener, Context context){
        this.likedItems = likedItems;
        this.itemClickListener = itemClickListener;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.liked_item_layout, parent, false);
        return new ViewHolder(view, itemClickListener);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LikedItem likedItem = likedItems.get(position);
        holder.title.setText(likedItem.getTitle());
      //  holder.date.setText(likedItem.getDate());

//        if (rowPosition == position){
//            holder.typesCardView.setBackgroundColor(Color.RED);
//        } else {
//            holder.typesCardView.setBackgroundColor(Color.TRANSPARENT);
//        }
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return likedItems.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView date;
        public CardView likedCardView;
        public ItemClickListener itemClickListener;

        public ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            title = itemView.findViewById(R.id.liked_title);
            date = itemView.findViewById(R.id.like_date_saved);
            likedCardView = itemView.findViewById(R.id.liked_card);
            itemView.setOnClickListener(this);
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(getAdapterPosition());
            notifyDataSetChanged();
        }
    }

    //   // convenience method for getting data at click position
    public LikedItem getItem(int position) {
        return likedItems.get(position);

    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(int position);
    }
}