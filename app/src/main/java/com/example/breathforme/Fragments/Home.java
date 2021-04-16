package com.example.breathforme.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.breathforme.PickerActivity;
import com.example.breathforme.R;
import com.example.breathforme.cardFragments.Sets;
import com.example.breathforme.cardFragments.Types;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.lang.reflect.Type;

public class Home extends Fragment {

    private final String TYPES = "TYPES";
    private final String BREATHS = "BREATHS";
    private final int LAUNCH_SECOND_ACTIVITY = 1;

    private View view;
    private BottomSheetBehavior mainFragmentBottomSheetBehavior;
    private RelativeLayout mainFragmentBottomSheet;
    private CardView selectTypeCard, totalBreathsCard, totalSetsCard, startBellCard, endBellCard,
            meditationCard, binauralBeatsCard, soundscapeCard, instructionCard, delaySetCard;
    private boolean isWimHof, isShamanicBreathing, isCarbonDioxideTraining, isConsciousBreathingAnchor, is478;
    String result;


    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        setUpMainBottomSheet();


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClickCardListeners();
        getActivity().findViewById(R.id.bottom_navigation);
        setUpBottomSheetLayouts();


    }

    private void setUpBottomSheetLayouts() {
        if (result != null) {

        }

//        Intent getIntent = getActivity().getIntent();
//        String getTypesIntent = getIntent.getStringExtra("types");
//
//
//        }

    }

    private void setUpMainBottomSheet() {

        selectTypeCard = view.findViewById(R.id.type);
        totalSetsCard = view.findViewById(R.id.sets);
        totalBreathsCard = view.findViewById(R.id.totalBreathsCard);
        startBellCard = view.findViewById(R.id.starting_bell);
        endBellCard = view.findViewById(R.id.last_bell);
        meditationCard = view.findViewById(R.id.meditation);
        binauralBeatsCard = view.findViewById(R.id.binaural_beats_card);
        soundscapeCard = view.findViewById(R.id.ambient_sounds_card);
        instructionCard = view.findViewById(R.id.instruction_card);
        delaySetCard = view.findViewById(R.id.delay_timer);

        mainFragmentBottomSheet = view.findViewById(R.id.main_bottomsheet);
        mainFragmentBottomSheetBehavior = BottomSheetBehavior.from(mainFragmentBottomSheet);
        mainFragmentBottomSheetBehavior.setBottomSheetCallback(getBottomSheetCallback());
        mainFragmentBottomSheet.setVisibility(View.VISIBLE);
        mainFragmentBottomSheetBehavior.setPeekHeight(800);

    }

    private void onClickCardListeners() {
        Intent intent = new Intent(getActivity(), PickerActivity.class);
        selectTypeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("key", TYPES);
                startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY);
            }
        });
        totalSetsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("key", BREATHS);
                getActivity().startActivity(intent);
            }
        });
    }

    private BottomSheetBehavior.BottomSheetCallback getBottomSheetCallback() {
        return new BottomSheetBehavior.BottomSheetCallback() {
            @Override//ToDo when the bottom sheet is expanded hide all of the bottom layouts
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:

                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:

                        break;

                    case BottomSheetBehavior.STATE_HIDDEN:

                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == LAUNCH_SECOND_ACTIVITY) {

            if (resultCode == Activity.RESULT_OK) {
                result = data.getStringExtra("types");
                if (result.equals("WIM")){
                    totalSetsCard.setVisibility(View.GONE);
                } else if (result.equals("SHAMANIC")){
                    totalBreathsCard.setVisibility(View.GONE);
                }

            }
            //Change layout based on activity
        }
        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getContext(), "Cancelled Activity ", Toast.LENGTH_SHORT).show();
        }
    }
}
