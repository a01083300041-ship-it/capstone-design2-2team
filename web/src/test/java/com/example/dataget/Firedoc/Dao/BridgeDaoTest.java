package com.example.dataget.Firedoc.Dao;

import com.example.dataget.Firedoc.Structure.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BridgeDaoTest {

    @Autowired
    BridgeDao bridgeDao;

    @Autowired
    RainDao rainDao;

    @Test
    @DisplayName("파이어 베이스에서 올바른 데이터를 가져오는지 확인한는 테스트")
    void getBridgeData() throws ExecutionException, InterruptedException {
        List<Bridge> real= bridgeDao.getBridges();

        //예상 값
        List<Bridge> expectedBridges = Arrays.asList(
                new Bridge("5.0", "15.0", "경계", "위험", "0.0", "2024-06-01 00:20", "00-220-0002", "감천동", "00", "정상"),
                new Bridge("5.0", "15.0", "경계", "위험", "0.0", "2024-06-01 00:20", "00-220-0004", "대연동", "00", "정상"),
                new Bridge("5.0", "15.0", "경계", "위험", "0.0", "2024-06-01 00:21", "00-220-0005", "용호동", "00", "정상")
        );


        assertEquals(expectedBridges.toString(), real.toString());

    }

    @Test
    @DisplayName("파이어 베이스에서 검색어에 해당하는 데이터를 가져오는지 확인한는 테스트")
    void getBridgesearchData() throws ExecutionException, InterruptedException{
        String searchQuery = "2024-05-27";
        List<Bridge> real= bridgeDao.getBridges(searchQuery);

        List<Bridge> expectedBridges = Arrays.asList(
                new Bridge("5.0", "15.0", "경계", "위험", "10.0", "2024-05-27 00:10", "00-220-0002", "감천동", "00", "정상"),
                new Bridge("5.0", "15.0", "경계", "위험", "0.0", "2024-05-27 00:10", "00-220-0004", "대연동", "00", "정상"),
                new Bridge("5.0", "15.0", "경계", "위험", "0.0", "2024-05-27 00:11", "00-220-0005", "용호동", "00", "정상")
        );
        System.out.println(real);

        assertEquals(expectedBridges.toString(), real.toString());

    }





}