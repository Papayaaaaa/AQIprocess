package com.papaya.processaqi;

import com.papaya.processaqi.controller.AQIController;
import com.papaya.processaqi.service.AQIproService;
import com.papaya.processaqi.service.impl.AQIproSerciveImpl;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;


@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.papaya.processaqi.dao")
public class ProcessaqiApplicationTests {

    @Autowired
//    private AQIproService aqIproService = new AQIproSerciveImpl();
//    @Test
//    public void saveAQICSVtoMySQLTest() throws IOException {
//
//        BufferedReader br = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:CSVbasepath.txt")));
//        String aqibasepath = null;
////        读取存放csv的文件夹名称
//        while ((aqibasepath = br.readLine()) != null) {
//            System.out.println(aqibasepath);
//            //获取目录当前路径下所有csv文件的绝对路径
//            File dir = new File(aqibasepath);
//            File[] fileList = dir.listFiles();
//            ArrayList<String> strList = new ArrayList<String>();
//            for (File f : fileList) {
////                    判断文件是不是csv
//                if ((f.isFile())
//                        && (".csv".equals(
//                        f.getName().substring(f.getName().lastIndexOf("."))))) {
//                    strList.add(f.getAbsolutePath());
//                }
//            }
////            为了保持插入数据库那一块代码的完整性这边就设置一个文件开一个线程好了ORZ
//            CountDownLatch countDownLatch = new CountDownLatch(strList.size());
//            for (String aqicsvfilepath : strList) {
//                try {
//                    aqIproService.saveAQICSVtoMySQL(aqicsvfilepath);
//                    System.out.println(aqicsvfilepath+" down!");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    countDownLatch.countDown();  //这个不管是否异常都需要数量减,否则会被堵塞无法结束
//                }
//            }
//
//            try {
//                countDownLatch.await(); //保证之前的所有的线程都执行完成，才会走下面的；
//                // 这样就可以在下面拿到所有线程执行完的集合结果
//            } catch (Exception e) {
//                System.out.println("阻塞异常");
//            }
//        }
//
//        br.close();
//
//    }

}
