package com.example.fadfadly.Database;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class MyDataBase {

    public static final String USERS_REF = "users";

    private static CollectionReference getCollection(String collectionName){
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        return firebaseFirestore.collection(collectionName);

    }

    public static CollectionReference getUsersReference(){
        return getCollection(USERS_REF);
    }

}
