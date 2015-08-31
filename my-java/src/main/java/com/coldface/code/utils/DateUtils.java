package com.coldface.code.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	/**
     * 将日期格式yyyyMMdd转换成yyyy-MM-dd格式
     * @param dateStr
     * @return
     */
    public static String formatDate(String dateStr){
        SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sf2 =new SimpleDateFormat("yyyy-MM-dd");
        String sfstr = "";
        try {
            sfstr = sf2.format(sf1.parse(dateStr));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sfstr;
    }

    /**
     * 比较两个日期的大小
     * @param data1
     * @param data2
     * @return
     */
    public static int DateCompareSize(String data1,String data2){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = sdf.parse(data1);
            Date d2 = sdf.parse(data2);
            if(d1.getTime()>d2.getTime()){
                return 1;
            }else if(d1.getTime()<d2.getTime()){
                return -1;
            }else{
                return 0;
            }
        }catch (ParseException ex){
            return 404;
        }
    }

}
