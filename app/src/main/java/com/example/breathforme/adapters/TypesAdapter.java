package com.example.breathforme.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breathforme.R;

import java.util.ArrayList;

public class TypesAdapter extends RecyclerView.Adapter<TypesAdapter.ViewHolder> {

    private ArrayList<TypesItem> typesItems;
    private ItemClickListener mClickListener;
    private int rowPosition;

    public TypesAdapter(ArrayList<TypesItem> typesItems){
      this.typesItems = typesItems;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.types_recycler_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TypesItem currentItem = typesItems.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());
        holder.typesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowPosition = position;
                notifyDataSetChanged();
            }
        });
        if (rowPosition == position){
            holder.typesCardView.setBackgroundColor(Color.RED);
        } else {
            holder.typesCardView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return typesItems.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView description;
        public CardView typesCardView;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.types_title);
            description = itemView.findViewById(R.id.types_description);
            typesCardView = itemView.findViewById(R.id.types_card);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

//   // convenience method for getting data at click position
    public TypesItem getItem(int position) {
        return typesItems.get(position);

    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}