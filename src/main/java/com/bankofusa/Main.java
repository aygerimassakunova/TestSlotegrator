package com.bankofusa;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Main {

    public static void main(String[] args) {
        testLog();
    }
    public static void testLog(){
        log.info("Kakybay");
        log.warn("Error");
        log.error("O my God");

    }


    /*    public static void main(String[] args) {
        String[] arrays = new String[]{
                "snows",
                "flower",
                "crows"
        };
        System.out.println(getSubString(arrays));
    }

    private static String getSubString(String[] array) {
        var result = array[0];
        var tempResult = "";
        for (int a = 1; a < array.length; a++) {

            for (int i = 0; i < result.length(); i++) {

                var word = array[a];

                if (result.charAt(i) == word.charAt(i)) {

                    tempResult += result.charAt(i);
                } else {
                    tempResult = "";
                }
            }
            result = tempResult;
            tempResult = "";
        }
        return result;
    }*/
}