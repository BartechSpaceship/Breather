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


public class Types extends Fragment implements RecyclerAdapter.ItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private final String WIM = "WIM";
    private final String SHAMANIC = "SHAMANIC";
    private final String CO2 = "CO2";
    private final String CONSCIOUSANCHOR = "CONSCIOUSANCHOR";
    private final String FOURSEVENEIGHT = "FOURSEVENEIGHT";
    private final String FOURBOX = "FOURBOX";
    private final String MEDITATION = "MEDITATION";


    private Button saveButton;
    private View view;
    private boolean isWimHof, isShamanicBreathing, isConsciousBreathingAnchor, isCO2, is478, isBoxBreathing;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private int rowPosition;
    ArrayList<RecyclerItem> recyclerItems;
    String result;

    public Types() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_types, container, false);
        saveButton = view.findViewById(R.id.saveTypes);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setOnCardClickListeners();
        saveBreathType();

    }

    private void setOnCardClickListeners() {
        recyclerView = view.findViewById(R.id.typesRecyclerView);
        //ToDo Tomorrow. When you click save pass the ID of the current item to the next page and hide particular layouts when done.
        recyclerItems = new ArrayList<>();
        recyclerItems.add(new RecyclerItem("Wim Hof", "Desc"));
        recyclerItems.add(new RecyclerItem("Shamanic Breathing", "Desc"));
        recyclerItems.add(new RecyclerItem("Carbon Dioxide Training", "Desc"));
        recyclerItems.add(new RecyclerItem("Conscious Breathing Anchor", "Desc"));
        recyclerItems.add(new RecyclerItem("4-7-8", "Desc"));
        recyclerItems.add(new RecyclerItem("Box breathing", "4-4-4-4"));
        recyclerItems.add(new RecyclerItem("Meditation", "Desc"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter = new RecyclerAdapter(recyclerItems, this, getContext());
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setHasFixedSize(true);



    }

    private void saveBreathType() {
        Intent intent = new Intent();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rowPosition == 0) {
                    intent.putExtra("types", WIM);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 1) {
                    intent.putExtra("types", SHAMANIC);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 2){
                    intent.putExtra("types", CO2);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 3){
                    intent.putExtra("types", CONSCIOUSANCHOR);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 4){
                    intent.putExtra("types", FOURSEVENEIGHT);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 5) {
                    intent.putExtra("types", FOURBOX);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 6){
                    intent.putExtra("types", MEDITATION);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                }
                getActivity().finish();
            }

        });

    }

    @Override
    public void onItemClick(int position) {
       //This selects the row
        rowPosition = position;
        //this highlights it in the adapter
        recyclerAdapter.rowPosition = position;

    }
}