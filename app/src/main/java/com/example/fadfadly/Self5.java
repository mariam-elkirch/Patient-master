package com.example.fadfadly;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Self5 extends Fragment {
View view;

    public Self5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_self5, container, false);
        RadioGroup radioGroup = (RadioGroup)view.findViewById(R.id.radios);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new Family1());
                fr.commit();
                if(checkedId==R.id.first)
                {
                    Self1.list.add(2);
                }
                else if(checkedId==R.id.second){
                    Self1.list.add(3);
                }
                else if(checkedId==R.id.third){
                    Self1.list.add(1);
                }
                        //print List
                for (int i=0;i < Self1.list.size();i++)
                {
                    Log.i("Value of element "+i, String.valueOf(Self1.list.get(i)));

                }
                //Convert List to array
                Integer[] arrSelf = Self1.list.toArray(new Integer[0]);
                //print Array
                for (Integer x : arrSelf)
                    Log.i("Array", x+"");







            }
        });


        return view;

    }

}