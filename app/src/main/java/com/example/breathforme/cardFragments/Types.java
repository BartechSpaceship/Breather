package com.example.breathforme.cardFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.breathforme.R;
import com.example.breathforme.adapters.TypesAdapter;
import com.example.breathforme.adapters.TypesItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Types#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Types extends Fragment implements  TypesAdapter.ItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private Button saveButton;
    private View view;
    private CardView wimHof, shamanicBreathing, consciousBreathingAnchor, carbonDioxideTraining, fourSevenEight, boxBreathing;
    private boolean isWimHof, isShamanicBreathing, isConsciousBreathingAnchor, isCO2, isFourSeven, isBoxBreathing;
    private TypesAdapter typesAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    List<String> types;

    public Types() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Types newInstance(String param1, String param2) {
        Types fragment = new Types();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_types, container, false);
//        wimHof = view.findViewById(R.id.wimHofBreathing);
//        shamanicBreathing = view.findViewById(R.id.shamanicBreathing);
//        consciousBreathingAnchor = view.findViewById(R.id.consciousBreathingAnchor);
//        carbonDioxideTraining = view.findViewById(R.id.carbonDioxideTraining);
//        fourSevenEight = view.findViewById(R.id.fourSevenEight);
//        boxBreathing = view.findViewById(R.id.boxBreathing);




        saveButton = view.findViewById(R.id.saveTypes);

        setOnCardClickListeners();


        return view;
    }

    private void setOnCardClickListeners(){
        ArrayList<TypesItem> typesItems = new ArrayList<>();
        typesItems.add(new TypesItem("Wim Hof", "Desc"));
        typesItems.add(new TypesItem("Shamanic Breathing", "Desc"));
        typesItems.add(new TypesItem("Carbon Dioxide Training", "Desc"));
        typesItems.add(new TypesItem("Conscious Breathing Anchor", "Desc"));
        typesItems.add(new TypesItem("4-7-8", "Desc"));
        typesItems.add(new TypesItem("4-7-8", "Desc"));
        typesItems.add(new TypesItem("4-7-8", "Desc"));
        typesItems.add(new TypesItem("4-7-8", "Desc"));

        recyclerView = view.findViewById(R.id.typesRecyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        typesAdapter = new TypesAdapter(typesItems);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(typesAdapter);

        typesAdapter.setClickListener(this);

        //ToDo Tomorrow. When you click save pass the ID of the current item to the next page and hide particular layouts when done. 

    }

    @Override
    public void onItemClick(View view, int position) {

    }

}