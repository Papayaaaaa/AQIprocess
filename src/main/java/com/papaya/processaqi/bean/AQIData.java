package com.papaya.processaqi.bean;

import org.joda.time.DateTime;

/*
每个站点的空气质量类
 */
public class AQIData {

    private String siteNumber;

    public void setDateTimeStr(String dateTimeStr) {
        this.dateTimeStr = dateTimeStr;
    }

    public String getDateTimeStr() {
        return dateTimeStr;
    }

    //    为了数据库操作方便这里使用string存储dateTime
    private String dateTimeStr;
    private int AQI;
    private int PM25;
    private int PM25_24h;
    private int PM10;
    private int PM10_24h;
    private int SO2;
    private int SO2_24h;
    private int NO2;
    private int NO2_24h;
    private int O3;
    private int O3_24h;
    private int O3_8h;
    private int O3_8h_24h;
    private float CO;
    private float CO_24h;


    public AQIData() {
    }

    public String getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(String siteNumber) {
        this.siteNumber = siteNumber;
    }

    @Override
    public String toString() {
        return "AQIData{" +
                "siteNumber='" + siteNumber + '\'' +
                ", dateTime=" + dateTimeStr +
                ", AQI=" + AQI +
                ", PM25=" + PM25 +
                ", PM25_24h=" + PM25_24h +
                ", PM10=" + PM10 +
                ", PM10_24h=" + PM10_24h +
                ", SO2=" + SO2 +
                ", SO2_24h=" + SO2_24h +
                ", NO2=" + NO2 +
                ", NO2_24h=" + NO2_24h +
                ", O3=" + O3 +
                ", O3_24h=" + O3_24h +
                ", O3_8h=" + O3_8h +
                ", O3_8h_24h=" + O3_8h_24h +
                ", CO=" + CO +
                ", CO_24h=" + CO_24h +
                '}';
    }



    public int getAQI() {
        return AQI;
    }

    public void setAQI(int AQI) {
        this.AQI = AQI;
    }

    public int getPM25() {
        return PM25;
    }

    public void setPM25(int PM25) {
        this.PM25 = PM25;
    }

    public int getPM25_24h() {
        return PM25_24h;
    }

    public void setPM25_24h(int PM25_24h) {
        this.PM25_24h = PM25_24h;
    }

    public int getPM10() {
        return PM10;
    }

    public void setPM10(int PM10) {
        this.PM10 = PM10;
    }

    public int getPM10_24h() {
        return PM10_24h;
    }

    public void setPM10_24h(int PM10_24h) {
        this.PM10_24h = PM10_24h;
    }

    public int getSO2() {
        return SO2;
    }

    public void setSO2(int SO2) {
        this.SO2 = SO2;
    }

    public int getSO2_24h() {
        return SO2_24h;
    }

    public void setSO2_24h(int SO2_24h) {
        this.SO2_24h = SO2_24h;
    }

    public int getNO2() {
        return NO2;
    }

    public void setNO2(int NO2) {
        this.NO2 = NO2;
    }

    public int getNO2_24h() {
        return NO2_24h;
    }

    public void setNO2_24h(int NO2_24h) {
        this.NO2_24h = NO2_24h;
    }

    public int getO3() {
        return O3;
    }

    public void setO3(int o3) {
        O3 = o3;
    }

    public int getO3_24h() {
        return O3_24h;
    }

    public void setO3_24h(int o3_24h) {
        O3_24h = o3_24h;
    }

    public int getO3_8h() {
        return O3_8h;
    }

    public void setO3_8h(int o3_8h) {
        O3_8h = o3_8h;
    }

    public int getO3_8h_24h() {
        return O3_8h_24h;
    }

    public void setO3_8h_24h(int o3_8h_24h) {
        O3_8h_24h = o3_8h_24h;
    }

    public float getCO() {
        return CO;
    }

    public void setCO(float CO) {
        this.CO = CO;
    }

    public float getCO_24h() {
        return CO_24h;
    }

    public void setCO_24h(float CO_24h) {
        this.CO_24h = CO_24h;
    }
}
