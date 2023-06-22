package com.saoudi.javaUtils;


import com.diogonunes.jcolor.Attribute;

import java.util.Arrays;
import java.util.HashMap;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
public class ConsoleColor {

    private static final int lenDefault = 80;
    private static final int lenTitle = 80;
    private static final Attribute textTitle = TEXT_COLOR(24,142,116);
    private static final Attribute bgTitle = BACK_COLOR(254,246,218);

    private static final int lenArray = 80;
    private static final Attribute textArray = TEXT_COLOR(24,142,116);
    private static final Attribute bgArray = BACK_COLOR(254,246,218);
    private static final Attribute textLineStartArray = TEXT_COLOR(208,63,24);
    private static final Attribute textLineEndArray = TEXT_COLOR(250,181,38);


    private static final int lenBigTitle = 80;
    private static final Attribute textBigTitle = TEXT_COLOR(2, 62,138);
    private static final Attribute bgBigTitle = BACK_COLOR(144, 224,239);
    public static void printTitleBox(String title){
        printTitleBox(title, 80, textTitle, bgTitle);
    }
    public static void printTitleBox(String title, int length){
        printTitleBox(title, length, textTitle, bgTitle);
    }

    public static void printBigTitleBox(String title, int length, Attribute textColor,Attribute bgColor){
        int lengthBox = title.length()+4;
        int marginEnd = 2;
        if(lengthBox<=length){
            lengthBox = length;
            marginEnd = ((lengthBox-2)-title.length());
        }

        System.out.println(colorize("█".repeat(lengthBox),textColor));
        System.out.println(colorize("  "+title+" ".repeat(marginEnd),textColor,bgColor));
        System.out.println(colorize("█".repeat(lengthBox),textColor));
    }
    public static void printBigTitleBox(String title){
        printBigTitleBox(title,lenBigTitle,textBigTitle,bgBigTitle);
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
        printFromArray(arr,textArray,bgArray);
    }
    public static void printFromArray(String[] arr,Attribute textColor,Attribute bgColor){
        if(arr==null || arr.length==0) return;
        int len = arr[0].length();
        System.out.println(colorize("█".repeat(len),textLineStartArray));

        for(String line:arr){
            System.out.println(colorize(line,textColor,bgColor));
        }
        System.out.println(colorize("█".repeat(len),textLineEndArray));

    }

    public static void printCode(String[] arr){

        // trouver la langeur max
        int len = 0;
        for(String line:arr){if(line.length()>len) len = line.length();}

        int lengthBox = lenDefault;
        if(lengthBox<len+4){
            lengthBox = len+4;
        }


        System.out.println(getLineCode(" ".repeat(lengthBox)));
        for(String line:arr){
            int margin = lengthBox-2-line.length();
            System.out.println(getLineCode("  "+line+" ".repeat(margin)));
        }
        System.out.println(getLineCode(" ".repeat(lengthBox)));
    }
    public static void printCode(String code){
        printCode(code.split("\n"));
    }

    private static String getLineCode(String line) {
        Attribute defaultTextColor = TEXT_COLOR(254, 242, 199);
        Attribute background = BACK_COLOR(11, 73, 72);
        HashMap<String, Attribute> charMap = new HashMap<>();
        charMap.put("{", TEXT_COLOR(205, 66, 28));
        charMap.put("}", TEXT_COLOR(205, 66, 28));
        charMap.put("[", TEXT_COLOR(18, 104, 85));
        charMap.put("]", TEXT_COLOR(18, 104, 85));
        charMap.put("(", TEXT_COLOR(232, 154, 65));
        charMap.put(")", TEXT_COLOR(232, 154, 65));
        charMap.put("\"", TEXT_COLOR(209, 71, 26));
        charMap.put("=", TEXT_COLOR(209, 71, 26));
        charMap.put("<", TEXT_COLOR(209, 71, 26));
        charMap.put(">", TEXT_COLOR(209, 71, 26));
        charMap.put("!", TEXT_COLOR(209, 71, 26));
        charMap.put(".", TEXT_COLOR(144, 224, 239));
        charMap.put(";", TEXT_COLOR(144, 224, 239));
        charMap.put("/", TEXT_COLOR(144, 224, 239));
        charMap.put("*", TEXT_COLOR(144, 224, 239));
        charMap.put("-", TEXT_COLOR(144, 224, 239));
        charMap.put("+", TEXT_COLOR(144, 224, 239));

        String[] subStr = line.split("");
        StringBuilder res = new StringBuilder();
        for (String c : subStr) {
            res.append(colorize(c, charMap.getOrDefault(c, defaultTextColor), background));
        }
        return res.toString();
    }
}
