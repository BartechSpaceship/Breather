package com.example.breathforme.cardFragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.breathforme.R;
import com.example.breathforme.adapters.RecyclerAdapter;
import com.example.breathforme.adapters.RecyclerItem;

import java.util.ArrayList;

public class AmbientSoundsFragment extends Fragment implements RecyclerAdapter.ItemClickListener {


    private View view;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<RecyclerItem> recyclerItems;
    private RecyclerView recyclerView;
    private int rowPosition;
    private Button saveButton;

    public AmbientSoundsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ambient_sounds, container, false);
        saveButton = view.findViewById(R.id.ambient_sounds_save_button);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRectclerView();
        saveAmbientSounds();

    }

    private void setUpRectclerView(){
        recyclerView = view.findViewById(R.id.ambient_sounds_recyclerview);
        //ToDo Tomorrow. When you click save pass the ID of the current item to the next page and hide particular layouts when done.
        recyclerItems = new ArrayList<>();
        recyclerItems.add(new RecyclerItem("Ambient Item 1", "Desc"));
        recyclerItems.add(new RecyclerItem("Ambient Item 2", "Desc"));
        recyclerItems.add(new RecyclerItem("Ambient Item 3", "Desc"));
        recyclerItems.add(new RecyclerItem("Ambient Item 4", "Desc"));
        recyclerItems.add(new RecyclerItem("Ambient Item 5", "Desc"));
        recyclerItems.add(new RecyclerItem("Ambient Item 6", "Desc"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter = new RecyclerAdapter(recyclerItems, this, getContext());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true);

    }

    private void saveAmbientSounds() {
        //ToDo Re-create all of the values for binaural beats
        Intent intent = new Intent();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rowPosition == 0) {
                    intent.putExtra("ambient", "1");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 1) {
                    intent.putExtra("ambient", "2");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 2) {
                    intent.putExtra("ambient", "3");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 3) {
                    intent.putExtra("ambient", "4");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 4) {
                    intent.putExtra("ambient", "5");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 5) {
                    intent.putExtra("ambient", "6");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                }
                getActivity().finish();
            }

        });
    }

    @Override
    public void onItemClick(int position) {
        rowPosition = position;
        //this highlights it in the adapter
        recyclerAdapter.rowPosition = position;
    }
}