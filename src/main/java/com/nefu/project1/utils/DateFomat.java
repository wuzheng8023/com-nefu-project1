package com.nefu.project1.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateFomat {

   private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

   public static Date getNowDay(){
       java.util.Date now = new java.util.Date();
              return Date.valueOf(String.valueOf(format.format(now)));
   }

    public static void main(String[] args) {
        System.out.println( getNowDay());
    }

}
