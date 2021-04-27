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


public class BinauralBeatsFragment extends Fragment implements RecyclerAdapter.ItemClickListener {

    private View view;
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapterr;
    private ArrayList<RecyclerItem> recyclerItems;
    private int rowPosition;
    private Button saveButton;

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
        saveButton = view.findViewById(R.id.binaural_beats_save);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRectclerView();
        saveBinauralType();
    }

    private void setUpRectclerView(){
        recyclerView = view.findViewById(R.id.binaural_recycler_view);
        //ToDo Tomorrow. When you click save pass the ID of the current item to the next page and hide particular layouts when done.
        recyclerItems = new ArrayList<>();
        recyclerItems.add(new RecyclerItem("Focus 14Hz Beta", getString(R.string.focus)));
        recyclerItems.add(new RecyclerItem("Relaxation 0.5Hz Delta", getString(R.string.body_relaxation)));
        recyclerItems.add(new RecyclerItem("Third Eye 13Hz Beta", getString(R.string.third_eye)));
        recyclerItems.add(new RecyclerItem("Inner Awareness 3.9Hz Delta", getString(R.string.inner_awareness)));
        recyclerItems.add(new RecyclerItem("Visualization 12.3Hz Alpha", getString(R.string.visualization)));
        recyclerItems.add(new RecyclerItem("Emotional Acceptance 7Hz", getString(R.string.emotional_acceptance)));
        recyclerItems.add(new RecyclerItem("Introspection 4.9Hz", getString(R.string.introspection)));
        recyclerItems.add(new RecyclerItem("Universal Healing 1.5Hz", getString(R.string.universal_healing)));
        recyclerItems.add(new RecyclerItem("Creativity 7.5Hz", getString(R.string.creativity)));
        recyclerItems.add(new RecyclerItem("Intuition 5.5Hz Theta", getString(R.string.intuition)));
        recyclerItems.add(new RecyclerItem("Solfeggio 7.83Hz Theta", getString(R.string.solfeggio)));
        recyclerItems.add(new RecyclerItem("Bliss 0.9Hz Delta", getString(R.string.bliss)));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapterr = new RecyclerAdapter(recyclerItems, this, getContext());
        recyclerView.setAdapter(recyclerAdapterr);
        recyclerView.setHasFixedSize(true);

    }

    private void saveBinauralType() {
        //ToDo Re-create all of the values for binaural beats
        Intent intent = new Intent();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rowPosition == 0) {
                    intent.putExtra("binaural", "Focus");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 1) {
                    intent.putExtra("binaural", "2");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 2) {
                    intent.putExtra("binaural", "3");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 3) {
                    intent.putExtra("binaural", "4");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 4) {
                    intent.putExtra("binaural", "5");
                    getActivity().setResult(Activity.RESULT_OK, intent);
                } else if (rowPosition == 5) {
                    intent.putExtra("binaural", "6");
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
        recyclerAdapterr.rowPosition = position;
    }
}