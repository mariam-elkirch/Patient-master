package com.example.fadfadly;


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
public class Friends6 extends Fragment {

View view;
    public Friends6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_friends6, container, false);
        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.radios);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new Friends7());
                fr.commit();
            }
        });

        return view;
    }

}