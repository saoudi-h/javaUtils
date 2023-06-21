package com.saoudi.javaUtils;


import com.diogonunes.jcolor.Attribute;

import java.util.Arrays;
import java.util.HashMap;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
public class ConsoleColor {
    public static void printTitleBox(String title){
        printTitleBox(title, 80, TEXT_COLOR(24,142,116), BACK_COLOR(254,246,218));
    }
    public static void printTitleBox(String title, int length){
        printTitleBox(title, length, TEXT_COLOR(24,142,116), BACK_COLOR(254,246,218));
    }
    public static void printTitleBox(String title, int length, Attribute textColor,Attribute bgColor){
        int lengthBox = title.length()+4;
        int marginEnd = 2;
        if(lengthBox<=length){
            lengthBox = length;
            marginEnd = ((lengthBox-2)-title.length());
        }
        System.out.println(colorize(" ".repeat(lengthBox),textColor,bgColor));
        System.out.println(colorize("  "+title+" ".repeat(marginEnd),textColor,bgColor));
        System.out.println(colorize(" ".repeat(lengthBox),textColor,bgColor));

    }

    public static void printFromArray(String[] arr){
        printFromArray(arr,TEXT_COLOR(24,142,116),BACK_COLOR(254,246,218));
    }
    public static void printFromArray(String[] arr,Attribute textColor,Attribute bgColor){
        if(arr==null || arr.length==0) return;
        int len = arr[0].length();
        System.out.println(colorize("█".repeat(len),Attribute.TEXT_COLOR(208,63,24)));

        for(String line:arr){
            System.out.println(colorize(line,textColor,bgColor));
        }
        System.out.println(colorize("█".repeat(len),Attribute.TEXT_COLOR(250,181,38)));

    }

    public static void printCode(String[] arr){

        // trouver la langeur max
        int len = 0;
        for(String line:arr){if(line.length()>len) len = line.length();}

        int lengthBox = 80;
        if(lengthBox<len+4){
            lengthBox = len+4;
        }


        System.out.println(printLineCode(" ".repeat(lengthBox)));
        for(String line:arr){
            int margin = lengthBox-2-line.length();
            System.out.println(printLineCode("  "+line+" ".repeat(margin)));
        }
        System.out.println(printLineCode(" ".repeat(lengthBox)));
    }
    public static void printCode(String code){
        printCode(code.split("\n"));
    }

    public static String printLineCode(String line) {
        Attribute defaultTextColor = TEXT_COLOR(254, 242, 199);
        Attribute background = BACK_COLOR(11, 73, 72);
        HashMap<String, Attribute> charMap = new HashMap<>();
        charMap.put("{", TEXT_COLOR(205, 66, 28));
        charMap.put("}", TEXT_COLOR(205, 66, 28));
        charMap.put("[", TEXT_COLOR(18, 104, 85));
        charMap.put("]", TEXT_COLOR(18, 104, 85));
        charMap.put("(", TEXT_COLOR(232, 154, 65));
        charMap.put(")", TEXT_COLOR(232, 154, 65));
        charMap.put("\"", TEXT_COLOR(126, 0, 160));
        charMap.put("=", TEXT_COLOR(126, 0, 160));
        charMap.put("<", TEXT_COLOR(126, 0, 160));
        charMap.put(">", TEXT_COLOR(126, 0, 160));
        charMap.put("!", TEXT_COLOR(126, 0, 160));

        String[] subStr = line.split("");
        StringBuilder res = new StringBuilder();
        for (String c : subStr) {
            res.append(colorize(c, charMap.getOrDefault(c, defaultTextColor), background));
        }
        return res.toString();
    }
}
