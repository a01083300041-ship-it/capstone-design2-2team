package com.example.dataget.Firedoc.Structure;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bridge {
    private String alertLevel3;
    private String alertLevel4;
    private String alertLevel3Nm;
    private String alertLevel4Nm;
    private String fludLevel;
    private String obsrTime;
    private String siteCode;
    private String siteName;
    private String sttus;
    private String sttusNm;


    public Bridge(String alertLevel3, String alertLevel4, String alertLevel3Nm, String alertLevel4Nm, String fludLevel,
                  String obsrTime, String siteCode, String siteName, String sttus, String sttusNm) {
        this.alertLevel3 = alertLevel3;
        this.alertLevel4 = alertLevel4;
        this.alertLevel3Nm = alertLevel3Nm;
        this.alertLevel4Nm = alertLevel4Nm;
        this.fludLevel = fludLevel;
        this.obsrTime = obsrTime;
        this.siteCode = siteCode;
        this.siteName = siteName;
        this.sttus = sttus;
        this.sttusNm = sttusNm;
    }
}
