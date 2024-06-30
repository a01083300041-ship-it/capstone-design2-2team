package com.example.dataget.Firedoc.Service;

import com.example.dataget.Firedoc.Dao.RainDao;
import com.example.dataget.Firedoc.Structure.Rain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class RainServiceimpl implements RainService{

    private final RainDao rainDao;


    @Override
    public List<Rain> getRains(String searchQuery) throws ExecutionException, InterruptedException {
        return rainDao.getRains(searchQuery);
    }

    @Override
    public List<Rain> getRains() throws ExecutionException, InterruptedException {
        return rainDao.getRains();
    }

}
