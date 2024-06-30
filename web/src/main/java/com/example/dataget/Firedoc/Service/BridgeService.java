package com.example.dataget.Firedoc.Service;

import com.example.dataget.Firedoc.Structure.Bridge;
import java.util.List;
import java.util.concurrent.ExecutionException;
public interface BridgeService {

    List<Bridge> getBridges() throws ExecutionException, InterruptedException;

    List<Bridge> getBridges(String searchQuery) throws ExecutionException, InterruptedException;
}
