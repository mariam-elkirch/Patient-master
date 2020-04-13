package com.example.fadfadly;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleLoveOutLayer extends Fragment {
    static final List<Double> list = new ArrayList<Double>();
View view;
    public SingleLoveOutLayer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_single_love_out_layer, container, false);
        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.radios);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected


                if(checkedId==R.id.yes)
                // Log.d(TAG, "A");
                { FragmentTransaction fr=getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container,new SingleLove1());
                    fr.commit();}
                else if(checkedId==R.id.no)
                //  Log.d(TAG, "B");
                { FragmentTransaction fr=getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container,new SingleTwoCases());
                    fr.commit();
              list.add(0,-1.0);
                    list.add(1,-1.0);
                  list.add(2,-1.0);
                   list.add(3,-1.0);




                }
            }
        });

        return view;
    }

}
