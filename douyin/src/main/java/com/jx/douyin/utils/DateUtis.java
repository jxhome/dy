package com.jx.douyin.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author jx
 * @Date 2019/5/22 9:38
 */
public class DateUtis {

    public static String getCurrentDate(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
}
