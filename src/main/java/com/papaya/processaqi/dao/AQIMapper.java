package com.papaya.processaqi.dao;

import com.papaya.processaqi.bean.AQIData;
import com.papaya.processaqi.bean.AQISite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AQIMapper {
    int QueryexistTable(@Param("tableName")String tableName);
    int insertSite(@Param("aqiSite")AQISite aqiSite);
    int insertAQIData(@Param("siteNumber")String siteNumber,@Param("aqiData") AQIData aqiData);
    int createAQIDataTable();
    int createSiteTable();
}
