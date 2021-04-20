package com.example.breathforme.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breathforme.R;

import java.util.ArrayList;


public class TypesAdapter extends RecyclerView.Adapter<TypesAdapter.ViewHolder> {

    private ArrayList<TypesItem> typesItems;
    private ItemClickListener itemClickListener;
    public int rowPosition;
    private Context context;

    public TypesAdapter(ArrayList<TypesItem> typesItems, ItemClickListener itemClickListener, Context context){
      this.typesItems = typesItems;
      this.itemClickListener = itemClickListener;
      this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.types_recycler_items, parent, false);
        return new ViewHolder(view, itemClickListener);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TypesItem currentItem = typesItems.get(position);
        holder.title.setText(currentItem.getTitle());
        holder.description.setText(currentItem.getDescription());

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
        public ItemClickListener itemClickListener;

        public ViewHolder(View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            title = itemView.findViewById(R.id.types_title);
            description = itemView.findViewById(R.id.types_description);
            typesCardView = itemView.findViewById(R.id.types_card);
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
    public TypesItem getItem(int position) {
        return typesItems.get(position);

    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(int position);
    }
}