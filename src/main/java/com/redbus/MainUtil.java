package com.redbus;

import java.io.BufferedReader;
import java.io.FileReader;

public class MainUtil {
    public static void main(String[] args) {
       try {
         A a1 = new A();
         a1.setPassword("testing");
         a1.setName("xyz");
           System.out.println(a1.getName());
           System.out.println(a1.getPassword());
       }catch (Exception e){
           e.printStackTrace();
       }

    }
}
