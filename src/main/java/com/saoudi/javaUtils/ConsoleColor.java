package com.saoudi.javaUtils;


import com.diogonunes.jcolor.Attribute;

import java.util.Arrays;
import java.util.HashMap;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

/**
 * Classe utilitaire pour l'affichage de texte coloré dans la console.
 */
public class ConsoleColor {

    private ConsoleColor() {
        // Constructeur privé pour empêcher l'instanciation de la classe
    }
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

    /**
     * Affiche une boîte de titre colorée avec le texte spécifié.
     *
     * @param title le texte du titre
     */
    public static void printTitleBox(String title){
        printTitleBox(title, lenTitle, textTitle, bgTitle);
    }

    /**
     * Affiche une boîte de titre colorée avec le texte et la longueur spécifiés.
     *
     * @param title  le texte du titre
     * @param length la longueur de la boîte
     */
    public static void printTitleBox(String title, int length){
        printTitleBox(title, length, textTitle, bgTitle);
    }


    /**
     * Affiche une grande boîte de titre colorée avec le texte, la longueur et les attributs de couleur spécifiés.
     *
     * @param title     le texte du titre
     * @param length    la longueur de la boîte
     * @param textColor l'attribut de couleur du texte
     * @param bgColor   l'attribut de couleur de l'arrière-plan
     */
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

    /**
     * Affiche une grande boîte de titre colorée avec le texte spécifié.
     *
     * @param title le texte du titre
     */
    public static void printBigTitleBox(String title){
        printBigTitleBox(title,lenBigTitle,textBigTitle,bgBigTitle);
    }

    /**
     * Affiche une boîte de titre colorée avec le texte, la longueur et les attributs de couleur spécifiés.
     *
     * @param title     le texte du titre
     * @param length    la longueur de la boîte
     * @param textColor l'attribut de couleur du texte
     * @param bgColor   l'attribut de couleur de l'arrière-plan
     */
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


    /**
     * Affiche le contenu d'un tableau de chaînes avec les attributs de couleur par défaut.
     *
     * @param arr le tableau de chaînes à afficher
     */
    public static void printFromArray(String[] arr){
        printFromArray(arr,textArray,bgArray);
    }

    /**
     * Affiche le contenu d'un tableau de chaînes avec des attributs de couleur spécifiés.
     *
     * @param arr       le tableau de chaînes à afficher
     * @param textColor l'attribut de couleur du texte
     * @param bgColor   l'attribut de couleur de l'arrière-plan
     */
    public static void printFromArray(String[] arr,Attribute textColor,Attribute bgColor){
        if(arr==null || arr.length==0) return;
        int len = arr[0].length();
        System.out.println(colorize("█".repeat(len),textLineStartArray));

        for(String line:arr){
            System.out.println(colorize(line,textColor,bgColor));
        }
        System.out.println(colorize("█".repeat(len),textLineEndArray));

    }

    /**
     * Affiche du code source avec une coloration syntaxique basique.
     *
     * @param arr le code source à afficher, chaque ligne étant un élément du tableau
     */
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


    /**
     * Affiche du code source avec une coloration syntaxique basique.
     *
     * @param code le code source à afficher sous forme d'une seule chaîne
     */
    public static void printCode(String code){
        printCode(code.split("\n"));
    }


    /**
     * Retourne une ligne de code source avec une coloration syntaxique basique.
     *
     * @param line la ligne de code source à colorer
     * @return la ligne de code source colorée
     */
    private static String getLineCode(String line) {
        Attribute others = TEXT_COLOR(144, 224, 239); // bleu clair
        Attribute conditions = TEXT_COLOR(209, 71, 26); //
        Attribute defaultTextColor = TEXT_COLOR(254, 242, 199);
        Attribute background = BACK_COLOR(11, 73, 72);
        HashMap<String, Attribute> charMap = new HashMap<>();
        charMap.put("{", TEXT_COLOR(205, 66, 28));
        charMap.put("}", TEXT_COLOR(205, 66, 28));
        charMap.put("[", TEXT_COLOR(18, 104, 85));
        charMap.put("]", TEXT_COLOR(18, 104, 85));
        charMap.put("(", TEXT_COLOR(232, 154, 65));
        charMap.put(")", TEXT_COLOR(232, 154, 65));
        charMap.put("\"", conditions);
        charMap.put("=", conditions);
        charMap.put("<", conditions);
        charMap.put(">", conditions);
        charMap.put("!", conditions);
        charMap.put(".", others);
        charMap.put(";", others);
        charMap.put("/", others);
        charMap.put("*", others);
        charMap.put("-", others);
        charMap.put("+", others);

        String[] subStr = line.split("");
        StringBuilder res = new StringBuilder();
        for (String c : subStr) {
            res.append(colorize(c, charMap.getOrDefault(c, defaultTextColor), background));
        }
        return res.toString();
    }
}
