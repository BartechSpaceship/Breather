package com.example.breathforme.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.breathforme.PickerActivity;
import com.example.breathforme.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class Home extends Fragment {

    private static final String TAG = "NU";
    private final String TYPES = "TYPES";
    private final String SETS = "SETS";
    private final String BREATHS = "BREATHS";
    private final String BINAURAL = "BINAURAL";
    private final String AMBIENT = "AMBIENT";
    private final int LAUNCH_SECOND_ACTIVITY = 1;
    private final int LAUNCH_SETS = 2;
    private final int LAUNCH_BREATH = 3;
    private final int LAUNCH_BINAURAL = 4;
    private final int LAUNCH_AMBIENT = 5;


    private View view;
    private BottomSheetBehavior mainFragmentBottomSheetBehavior;
    private RelativeLayout mainFragmentBottomSheet;
    private CardView selectTypeCard, totalBreathsCard, totalSetsCard, startBellCard, endBellCard, totalBreathingMinutesCard,
            meditationCard, binauralBeatsCard, soundscapeCard, instructionCard, delaySetCard, holdBellCard;
    private TextView typesTV, setsTV, binauralTV, ambientTV;
    private Button startButton;

    String resultType;
    String resultSets;
    String resultBinaurals;
    String resultAmbient;


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



    }

    private void setUpBottomsheetLayouts() {

        if (resultType.equals("WIM")) {
            typesTV.setText("Wim Hof");
            totalBreathsCard.setVisibility(View.VISIBLE);
            totalSetsCard.setVisibility(View.VISIBLE);
            delaySetCard.setVisibility(View.VISIBLE);
            meditationCard.setVisibility(View.VISIBLE);
            binauralBeatsCard.setVisibility(View.VISIBLE);
            instructionCard.setVisibility(View.VISIBLE);
          //  totalBreathingMinutesCard.setVisibility(View.GONE);

//            startBellCard.setVisibility(View.VISIBLE);
//            endBellCard.setVisibility(View.VISIBLE);
//            holdBellCard.setVisibility(View.VISIBLE);
        } else {
            if (resultType.equals("SHAMANIC")) {
                typesTV.setText("Shamanic");
            } else if (resultType.equals("CONSCIOUSANCHOR")) {
                typesTV.setText("Conscious Breathing Anchor");
            } else if (resultType.equals("CO2")){
                typesTV.setText("Carbon Dioxide Training");
            } else if (resultType.equals("FOURSEVENEIGHT")){
                typesTV.setText("Four seven eight");
            } else if (resultType.equals("FOURBOX")){
                typesTV.setText("Box Breathing ");
            }
        //    totalBreathingMinutesCard.setVisibility(View.VISIBLE);
            totalSetsCard.setVisibility(View.GONE);
            holdBellCard.setVisibility(View.GONE);
            delaySetCard.setVisibility(View.GONE);
            totalBreathsCard.setVisibility(View.VISIBLE);
            meditationCard.setVisibility(View.VISIBLE);
            binauralBeatsCard.setVisibility(View.VISIBLE);
            instructionCard.setVisibility(View.VISIBLE);

          //  startBellCard.setVisibility(View.VISIBLE);
//            endBellCard.setVisibility(View.VISIBLE);
//            holdBellCard.setVisibility(View.VISIBLE);
            //ToDo, get rid of total breaths. Instead count it in minutes. Howmany mintues do you want to do box breathing for ?
        }


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
        holdBellCard = view.findViewById(R.id.breath_hold_bell);
        startButton = view.findViewById(R.id.start_button);

        setsTV = view.findViewById(R.id.sets_TV);
        typesTV = view.findViewById(R.id.types_TV);
        binauralTV = view.findViewById(R.id.binaural_card_TV);
        ambientTV = view.findViewById(R.id.ambient_card_TV);

        mainFragmentBottomSheet = view.findViewById(R.id.main_bottomsheet);
        mainFragmentBottomSheetBehavior = BottomSheetBehavior.from(mainFragmentBottomSheet);
        mainFragmentBottomSheetBehavior.setBottomSheetCallback(getBottomSheetCallback());
        mainFragmentBottomSheetBehavior.setPeekHeight(250);
        mainFragmentBottomSheet.setVisibility(View.VISIBLE);

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
                intent.putExtra("key", SETS);
                startActivityForResult(intent, LAUNCH_SETS);
            }
        });
        totalBreathsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("key", BREATHS);
                startActivityForResult(intent, LAUNCH_SETS);
            }
        });
        binauralBeatsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("key", BINAURAL);
                startActivityForResult(intent, LAUNCH_BINAURAL);
            }
        });
        soundscapeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    intent.putExtra("key", AMBIENT);
                    startActivityForResult(intent, LAUNCH_AMBIENT);
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
        //ToDo Will have to save the data offline so that the views do not disappear after switching fragments
        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                resultType = data.getStringExtra("types");
                setUpBottomsheetLayouts();

            }
        }
        if (requestCode == LAUNCH_SETS){
            if (resultCode == Activity.RESULT_OK) {
                resultSets = data.getStringExtra("sets");
                setsTV.setText(resultSets);

            }
        }
        if (requestCode == LAUNCH_BINAURAL){
            if (resultCode == Activity.RESULT_OK){
                resultBinaurals = data.getStringExtra("binaural");
                binauralTV.setText("" + resultBinaurals);

            }
        }
        if (requestCode == LAUNCH_AMBIENT){
            if (resultCode == Activity.RESULT_OK){
                resultAmbient = data.getStringExtra("ambient");
                ambientTV.setText("" + resultAmbient);
            }
        }


        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getContext(), "Cancelled Activity ", Toast.LENGTH_SHORT).show();
        }
    }
}
