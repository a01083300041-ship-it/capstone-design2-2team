package com.example.dataget.Firedoc.Service;

import com.example.dataget.Firedoc.Structure.Rain;
import com.google.cloud.firestore.DocumentSnapshot;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface RainService {

    List<Rain> getRains(String searchQuery) throws ExecutionException, InterruptedException;
    List<Rain> getRains() throws ExecutionException, InterruptedException;

}
