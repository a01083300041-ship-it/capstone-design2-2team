package com.example.dataget.Firedoc.Structure;

import com.google.cloud.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Rain {
    private String clientId;
    private String clientName;
    private String lastRainDt;
    private String accRain;
    private String timeDay;
    private String level6;
    private String level12;
    private String accRainDt;
    private Timestamp createdAt;



    public Rain(String clientId, String clientName, String lastRainDt, String accRain, String timeDay, String level6, String level12, String date, java.sql.Timestamp timestamp) {
    }


}
