package com.example.breathforme.cardFragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.breathforme.R;
import com.shawnlin.numberpicker.NumberPicker;

import static android.content.ContentValues.TAG;

public class Sets extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //ToDo recreate this layout, just using it now to see if possible to pass 2 values into the same activity
    private View view;
    private NumberPicker numberPicker;
    private Button saveButton;
    private String setNumber;


    public Sets() {
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
        view = inflater.inflate(R.layout.fragment_sets, container, false);
        numberPicker = view.findViewById(R.id.number_picker);
        saveButton = view.findViewById(R.id.sets_save);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findNumberPickerNumber();

    }

    private void findNumberPickerNumber(){
        Intent intent = new Intent();
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                setNumber = Integer.toString(oldVal + 1);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("sets", setNumber);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();
            }
        });

    }


}