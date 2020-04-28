package com.example.fadfadly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Filtering2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtering2);


        for (int i=0;i < Self5.list.size();i++)
        {
            Log.i("weka of filtr element "+i, String.valueOf(Self5.list.get(i)));

        }

        String self=Self5.list.get(0);

        String family=Self5.list.get(1);
        String friends=Self5.list.get(2);
        String emotion=Self5.list.get(3);
        String work=Self5.list.get(4);
        String loss=Self5.list.get(5);
        String general=Self5.list.get(6);
        String decision=Self5.list.get(7);



    }
}
