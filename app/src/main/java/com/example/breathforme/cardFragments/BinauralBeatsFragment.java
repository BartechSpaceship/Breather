package com.example.breathforme.cardFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.breathforme.R;
import com.example.breathforme.adapters.TypesAdapter;

import java.util.ArrayList;


public class BinauralBeatsFragment extends Fragment implements TypesAdapter.ItemClickListener {

    private View view;
    private RecyclerView recyclerView;
    private TypesAdapter typesAdapterr;

    public BinauralBeatsFragment() {
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
        view = inflater.inflate(R.layout.fragment_binaural_beats, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRectclerView();
    }

    private void setUpRectclerView(){
//        recyclerView = view.findViewById(R.id.binaural_recycler_view);
//        //ToDo Tomorrow. When you click save pass the ID of the current item to the next page and hide particular layouts when done.
//        binauralItems = new ArrayList<>();
//        binauralItems.add(new BinauralItem("Focus", "Desc"));
//        binauralItems.add(new BinauralItem("Relaxation", "Desc"));
//        binauralItems.add(new BinauralItem("Third Eye", "Desc"));
//        binauralItems.add(new BinauralItem("Some other shit", "Desc"));
//        binauralItems.add(new BinauralItem("Lime disease", "Desc"));
//        binauralItems.add(new BinauralItem("Anorexia", "Desc"));
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
//        typesAdapterr = new TypesAdapter(binauralItems, this, getContext());
//        recyclerView.setAdapter(binauralAdapter);
//        recyclerView.setHasFixedSize(true);

    }

    @Override
    public void onItemClick(int position) {

    }
}