package com.example.fadfadly;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleOrNotOutLayer extends Fragment {

View view;
    public SingleOrNotOutLayer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_single_or_not_out_layer, container, false);



        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.radios);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected


           if(checkedId==R.id.single)
                   // Log.d(TAG, "A");
               { FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new SingleLoveOutLayer());
                fr.commit();}
                else if(checkedId==R.id.married)
                  //  Log.d(TAG, "B");
                { FragmentTransaction fr=getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container,new Married1());
                    fr.commit();}
            }
        });

        return view;
    }

}
