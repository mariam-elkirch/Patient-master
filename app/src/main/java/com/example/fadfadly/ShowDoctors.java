package com.example.fadfadly;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fadfadly.Database.MyDataBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static com.example.fadfadly.SignupActivity.user;

public class ShowDoctors extends AppCompatActivity {

    RecyclerView recyclerView;
    ShowDoctorsAdapter adapter;
    List<Doctors> doctorsList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doctors);

        recyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
        getDoctors();
    }

    private void getDoctors(){
        final CollectionReference doctorsRef = MyDataBase.getDoctorsReference();
        doctorsRef.whereEqualTo("gender" , user.getGender()).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Doctors doctor = document.toObject(Doctors.class);
                                doctorsList.add(doctor);
                                Log.i("result", document.getId() + ":" + document.get("name"));
                            }
                            adapter.notifyDataSetChanged();
                        }
                        else{
                            Log.i("error","no result for filtering");
                        }
                    }
                });

    }

    private void initRecyclerView (){
        if (adapter == null){
            adapter = new ShowDoctorsAdapter(doctorsList);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
