package com.example.dataget.Firedoc.Dao;

import com.example.dataget.Firedoc.Structure.Bridge;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@Repository
public class BridgeDao {

    public static final String COLLECTION_NAME = "bridge";

    LocalDate currentDate = LocalDate.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    String formattedDate = currentDate.format(formatter);

    public List<Bridge> getBridges() throws ExecutionException, InterruptedException {
        List<Bridge> list = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).document(formattedDate).collection("data").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            list.add(document.toObject(Bridge.class));
        }
        return list;
    }

    public List<Bridge> getBridges(String searchQuery) throws ExecutionException, InterruptedException {
        List<Bridge> list = new ArrayList<>();
        String sd= searchQuery;
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).document(sd).collection("data").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            list.add(document.toObject(Bridge.class));
        }
        return list;
    }
}
