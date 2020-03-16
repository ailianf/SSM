package com.ailian.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String date2Str(Date date, String prtt) {
        SimpleDateFormat sdf = new SimpleDateFormat(prtt);
        return sdf.format(date);
    }

    public static Date str2Date(String str, String prtt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(prtt);
        return sdf.parse(str);
    }

    public static void main(String[] args) throws ParseException {

        Date date = str2Date("February/Thursday/YYYY 16:02 A", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
    }
}
