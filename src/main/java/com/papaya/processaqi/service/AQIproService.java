package com.papaya.processaqi.service;

import com.papaya.processaqi.bean.AQIData;
import com.papaya.processaqi.bean.AQISite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;


public interface AQIproService {
    void saveSiteCSVtoMySQL(String sitefilepath) throws IOException;
    void saveAQICSVtoMySQL(String aqifilepath) throws IOException ;
    boolean existTable(String tableName);
}
