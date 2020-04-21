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
public class SingleLove3 extends Fragment {

View view;
    public SingleLove3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_single_love3, container, false);
        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.radios);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new SingleLove4());
                fr.commit();
                if(checkedId==R.id.first)
                {
                    SingleOrNotOutLayer.list.add(2,3.0);
                }
                else if(checkedId==R.id.second){
                    SingleOrNotOutLayer.list.add(2,1.0);
                }
                else if(checkedId==R.id.third){
                    SingleOrNotOutLayer.list.add(2,0.0);
                }
            }
        });

        return view;
    }

}