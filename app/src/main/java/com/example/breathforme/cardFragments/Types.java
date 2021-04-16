package com.example.breathforme.cardFragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.breathforme.Fragments.Home;
import com.example.breathforme.R;
import com.example.breathforme.adapters.TypesAdapter;
import com.example.breathforme.adapters.TypesItem;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class Types extends Fragment implements TypesAdapter.ItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private final String WIM = "WIM";
    private final String SHAMANIC = "SHAMANIC";


    private Button saveButton;
    private View view;
    private boolean isWimHof, isShamanicBreathing, isConsciousBreathingAnchor, isCO2, is478, isBoxBreathing;
    private TypesAdapter typesAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private int cardPosition;
    ArrayList<TypesItem> typesItems;
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
        typesItems = new ArrayList<>();
        typesItems.add(new TypesItem("Wim Hof", "Desc"));
        typesItems.add(new TypesItem("Shamanic Breathing", "Desc"));
        typesItems.add(new TypesItem("Carbon Dioxide Training", "Desc"));
        typesItems.add(new TypesItem("Conscious Breathing Anchor", "Desc"));
        typesItems.add(new TypesItem("4-7-8", "Desc"));
        typesItems.add(new TypesItem("4-4-4-4", "Desc"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        typesAdapter = new TypesAdapter(typesItems, this, getContext());
        recyclerView.setAdapter(typesAdapter);
        recyclerView.setHasFixedSize(true);



    }

    private void saveBreathType() {
        Intent intent = new Intent();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardPosition == 0) {
                    intent.putExtra("types", WIM);
                    getActivity().setResult(Activity.RESULT_OK, intent);

                    //    Toast.makeText(getContext(), "Clicked WIM", Toast.LENGTH_SHORT).show();

                } else if (cardPosition == 1) {
                    intent.putExtra("types", SHAMANIC);
                    getActivity().setResult(Activity.RESULT_OK, intent);

                }
                getActivity().finish();
            }

        });

    }

    @Override
    public void onItemClick(int position) {
        cardPosition = position;

        //        holder.typesCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rowPosition = position;
//              //  notifyDataSetChanged();
//            }
//        });
//        if (rowPosition == position){
//            holder.typesCardView.setBackgroundColor(Color.RED);
//        } else {
//            holder.typesCardView.setBackgroundColor(Color.TRANSPARENT);
//        }
    }
}