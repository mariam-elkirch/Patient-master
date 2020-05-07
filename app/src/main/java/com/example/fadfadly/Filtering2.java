package com.example.fadfadly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.fadfadly.Database.daos.UsersDao;

import static com.example.fadfadly.SignupActivity.user;

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

        UsersDao.updateField(user, "self", self);
        UsersDao.updateField(user,"family", family);
        UsersDao.updateField(user,"friends", friends);
        UsersDao.updateField(user,"emotion", emotion);
        UsersDao.updateField(user,"work", work);
        UsersDao.updateField(user,"loss", loss);
        UsersDao.updateField(user,"general", general);



    }
}
