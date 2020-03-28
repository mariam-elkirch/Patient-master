package com.example.fadfadly.Database.daos;


import com.example.fadfadly.Database.MyDataBase;
import com.example.fadfadly.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;

/**
 * Created by Mohamed Nabil Mohamed on 10/5/2019.
 * m.nabil.fci2015@gmail.com
 */
public class UsersDao {

    public static void addUser(User user, OnCompleteListener onSuccessListener,
                               OnFailureListener onFailureListener){
      MyDataBase.getUsersReference()
              .document(user.getId())
              .set(user)
              .addOnCompleteListener(onSuccessListener)
              .addOnFailureListener(onFailureListener);
    }
    public static void getUser(String userId,
                               OnCompleteListener onSuccessListener,
                               OnFailureListener onFailureListener){
        MyDataBase.getUsersReference()
                .whereEqualTo("id",userId)
                .get()
                .addOnCompleteListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);    }
}
