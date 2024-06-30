package com.example.dataget.Firedoc.Service;

import com.example.dataget.Firedoc.Dao.BridgeDao;
import com.example.dataget.Firedoc.Structure.Bridge;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class BridgeServiceimpl implements BridgeService{

    private final BridgeDao bridgeDao;

    @Override
    public List<Bridge> getBridges() throws ExecutionException, InterruptedException {
        return bridgeDao.getBridges();
    }

    @Override
    public List<Bridge> getBridges(String searchQuery) throws ExecutionException, InterruptedException {
        return bridgeDao.getBridges(searchQuery);
    }
}
