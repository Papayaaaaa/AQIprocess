package com.papaya.processaqi.service.impl;

import com.opencsv.CSVReader;
import com.papaya.processaqi.bean.AQIData;
import com.papaya.processaqi.bean.AQISite;
import com.papaya.processaqi.dao.AQIMapper;
import com.papaya.processaqi.service.AQIproService;
import com.sun.org.apache.bcel.internal.generic.FLOAD;
import org.joda.time.DateTime;
import org.joda.time.format.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Service
public class AQIproSerciveImpl implements AQIproService {

    @Autowired
    private AQIMapper aqiMapper=null;

    @Override
    public boolean existTable(String tableName) {
        return aqiMapper.QueryexistTable(tableName) != 0;
    }

//    终于要开始写读取csv文件的代码了

    @Override
    @Async
    public void saveSiteCSVtoMySQL(String sitefilepath) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(sitefilepath));
        String[] nextLine;
//        若站点列表不存在，则创建site表并导入site数据
        if (!existTable("SiteInfo")) {
            aqiMapper.createSiteTable();
        }
//        逐行读取
        if(existTable("SiteInfo")) {
            nextLine = reader.readNext();//跳过第一行表头
            while ((nextLine = reader.readNext()) != null) {
                AQISite aqiSite = new AQISite();
                aqiSite.setSitenumber(nextLine[0]);
                aqiSite.setSitename(nextLine[1]);
                aqiSite.setSitecity(nextLine[2]);
                aqiSite.setSitelon(Str2Float(nextLine[3]));
                aqiSite.setSitelat(Str2Float(nextLine[4]));
                // nextLine[] is an array of values from the line
                System.out.println(aqiSite.toString());
                aqiMapper.insertSite(aqiSite);
            }
        }
    }


    @Override
    @Async
    public void saveAQICSVtoMySQL(String aqifilepath) throws IOException {
        CSVReader reader = null;
        String[] nextLine;
        reader = new CSVReader(new FileReader(aqifilepath));
        nextLine = reader.readNext();//读取表头

        String[] siteNumbers = Arrays.copyOfRange(nextLine, 3, nextLine.length);//截取站点列表
        for (int i = 3; i < nextLine.length; i++) {
//            从第四列开始为站点序号
            if (!existTable("AQIData")) {
                System.out.println("creating AQI table ");
                aqiMapper.createAQIDataTable();
            }
        }
//        这边使用15行一读取csv的形式，使用一个AQIData数组去转换映射，15行为一个时间的记录
        ArrayList<String[]> csvList = new ArrayList<String[]>();
        while (nextLine != null) {
            csvList.clear();
            for (int j = 0; j < 15 && (nextLine = reader.readNext()) != null; j++) {
                csvList.add(nextLine);
            }
            if (csvList.size() == 15) {
//            每15行的记录都可以并行执行
            AQIHourData2MySQL(nextLine, siteNumbers, csvList);
            }
            else{System.out.println("csvList.size() is not correct");}
        }
    }

//    将每小时记录插入数据库
    public void AQIHourData2MySQL(String[] nextLine, String[] siteNumbers, ArrayList<String[]> csvList) {
        if (csvList.size() == 15) {
//                转换时间
            DateTimeFormatter format = DateTimeFormat.forPattern("yyyyMMddHH");
            if (csvList.get(0)[1].length() == 1) {
                csvList.get(0)[1] = "0" + csvList.get(0)[1];
            }
            String dateTimeStr = DateTime.parse(nextLine[0] + nextLine[1], format).toString("yyyy-MM-dd HH-mm-ss");
//                循环存储站点信息
            for (int k = 0; k < siteNumbers.length; k++) {
                AQIData aqi = new AQIData();
                aqi.setSiteNumber(siteNumbers[k]);
                aqi.setDateTimeStr(dateTimeStr);
                aqi.setAQI(Str2int(csvList.get(0)[k + 3]));
                aqi.setPM25(Str2int(csvList.get(1)[k + 3]));
                aqi.setPM25_24h(Str2int(csvList.get(2)[k + 3]));
                aqi.setPM10(Str2int(csvList.get(3)[k + 3]));
                aqi.setPM10_24h(Str2int(csvList.get(4)[k + 3]));
                aqi.setSO2(Str2int(csvList.get(5)[k + 3]));
                aqi.setSO2_24h(Str2int(csvList.get(6)[k + 3]));
                aqi.setNO2(Str2int(csvList.get(7)[k + 3]));
                aqi.setNO2_24h(Str2int(csvList.get(8)[k + 3]));
                aqi.setO3(Str2int(csvList.get(9)[k + 3]));
                aqi.setO3_24h(Str2int(csvList.get(10)[k + 3]));
                aqi.setO3_8h(Str2int(csvList.get(11)[k + 3]));
                aqi.setO3_8h_24h(Str2int(csvList.get(12)[k + 3]));
                aqi.setCO(Str2Float(csvList.get(13)[k + 3]));
                aqi.setCO_24h(Str2Float(csvList.get(14)[k + 3]));
                System.out.println(aqi.toString());
//                    存储一条aqi数据
                aqiMapper.insertAQIData(siteNumbers[k], aqi);
            }
        } else {
            System.out.println("csvList.size() is not correct");
        }
    }

    public int Str2int(String str){
        if(str.isEmpty()){
            System.out.println("null string!");
            return -1;
        }
        else return Integer.parseInt(str);
    }
    public Float Str2Float(String str){
        if(str.isEmpty()){
            System.out.println("null string!");
            return -1f;
        }
        else return Float.parseFloat(str);
    }
}
