package com.example.breathforme.adapters;

import androidx.cardview.widget.CardView;

public class TypesItem {
    private String title;
    private String description;


    public TypesItem(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
