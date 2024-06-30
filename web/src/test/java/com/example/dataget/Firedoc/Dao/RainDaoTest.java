package com.example.dataget.Firedoc.Dao;


import com.example.dataget.Firedoc.Structure.Rain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RainDaoTest {

    @Autowired
    RainDao rainDao;

    @Test
    @DisplayName("파이어 베이스에서 올바른 데이터를 가져오는지 확인하는 테스트")
    void getRainData() throws ExecutionException, InterruptedException {
        // 실제 값
        List<Rain> actualRains = rainDao.getRains();

        // 예상 값
        List<Rain> expectedRains = Arrays.asList(
                new Rain("00-100-0012", "강서구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0008", "금정구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0017", "기장읍", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0006", "남구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0013", "녹산수문", "", null, null, null, null, "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0016", "동구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0005", "동래구", "", "0,0",null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0024", "동인고", "", "0,0", null, "0,0", "0,0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0044", "만덕2동", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0032", "명지동", "", null, null, null, null, "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0022", "부산과학고", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0004", "부산진구", "", "0,0",null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("07-100-0001", "북구보건소", "", "0,0", null, "0,0", "0,0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0011", "사상구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0010", "사하구", "", "0,0",null, "0,0", "0,0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0035", "산단사업소", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0002", "서구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0015", "수영구", "", "0,0", null, "0,0", "0,0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0014", "연제구", "", "0,0", null, "0.0" ,"0.0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0003", "영도구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0020", "정관읍", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0001", "중구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0021", "철마면", "", "0,0",null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0023", "해양자연사", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0009", "해운대구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000"))
        );

        if(expectedRains == actualRains){
            System.out.println("데이터가 일치합니다.");
        }
    }


    @Test
    @DisplayName("파이어 베이스에서 검색한 데이터를 가져오는지 확인하는 테스트")
    void getRainsearchData() throws ExecutionException, InterruptedException {

        String searchQueary = "2024-06-01";

        // 실제 값
        List<Rain> actualRains = rainDao.getRains(searchQueary);

        // 예상 값
        List<Rain> expectedRains = Arrays.asList(
                new Rain("00-100-0012", "강서구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0008", "금정구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0017", "기장읍", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0006", "남구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0013", "녹산수문", "", null, null, null, null, "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0016", "동구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0005", "동래구", "", "0,0",null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0024", "동인고", "", "0,0", null, "0,0", "0,0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0044", "만덕2동", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0032", "명지동", "", null, null, null, null, "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0022", "부산과학고", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0004", "부산진구", "", "0,0",null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("07-100-0001", "북구보건소", "", "0,0", null, "0,0", "0,0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0011", "사상구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0010", "사하구", "", "0,0",null, "0,0", "0,0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0035", "산단사업소", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0002", "서구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0015", "수영구", "", "0,0", null, "0,0", "0,0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0014", "연제구", "", "0,0", null, "0.0" ,"0.0","2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0003", "영도구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0020", "정관읍", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0001", "중구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0021", "철마면", "", "0,0",null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0023", "해양자연사", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000")),
                new Rain("00-100-0009", "해운대구", "", "0,0", null, "0,0", "0,0", "2024-06-01", Timestamp.valueOf("2024-06-01 01:57:24.017778000"))
        );

        if(expectedRains == actualRains){
            System.out.println("데이터가 일치합니다.");
        }
    }


}