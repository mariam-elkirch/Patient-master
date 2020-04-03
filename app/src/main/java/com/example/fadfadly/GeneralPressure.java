package com.example.fadfadly;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GeneralPressure extends Fragment {

View view;
    public GeneralPressure() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_general_pressure, container, false);
        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.radios);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected


                if(checkedId==R.id.no)
                // Log.d(TAG, "A");
                { Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                else if(checkedId==R.id.yes)
                //  Log.d(TAG, "B");
                { FragmentTransaction fr=getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container,new Pressure1());
                    fr.commit();}
            }
        });

        return view;
    }

}
