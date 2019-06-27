package com.papaya.processaqi.bean;

import org.springframework.context.annotation.Bean;
/*
空气质量监测站点类
 */
public class AQISite {
    public String getSitenumber() {
        return sitenumber;
    }

    public void setSitenumber(String sitenumber) {
        this.sitenumber = sitenumber;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getSitecity() {
        return sitecity;
    }

    public void setSitecity(String sitecity) {
        this.sitecity = sitecity;
    }

    public void setSitelon(Float sitelon) {
        this.sitelon = sitelon;
    }

    public void setSitelat(Float sitelat) {
        this.sitelat = sitelat;
    }



    private String sitenumber;  //监测点编码

    private String sitename;    //监测点名称
    private String sitecity;    //城市

    @Override
    public String toString() {
        return "AQISite{" +
                "sitenumber='" + sitenumber + '\'' +
                ", sitename='" + sitename + '\'' +
                ", sitecity='" + sitecity + '\'' +
                ", sitelon=" + sitelon +
                ", sitelat=" + sitelat +
                '}';
    }

    private Float sitelon;     //经度
    private Float sitelat;     //纬度

}
