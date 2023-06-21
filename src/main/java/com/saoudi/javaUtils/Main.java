package com.saoudi.javaUtils;

import com.diogonunes.jcolor.Attribute;

import java.util.Arrays;
import java.util.HashMap;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
public class Main {
    public static void main(String[] args) {


        printFromArray(new String[]{
                        "                                                                                   " ,
                        "           ██╗ █████╗ ██╗   ██╗ █████╗ ██╗   ██╗████████╗██╗██╗     ███████╗       " ,
                        "           ██║██╔══██╗██║   ██║██╔══██╗██║   ██║╚══██╔══╝██║██║     ██╔════╝       " ,
                        "           ██║███████║██║   ██║███████║██║   ██║   ██║   ██║██║     ███████╗       " ,
                        "      ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║██║   ██║   ██║   ██║██║     ╚════██║       " ,
                        "      ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║╚██████╔╝   ██║   ██║███████╗███████║       " ,
                        "       ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚═╝╚══════╝╚══════╝       " ,
                        "                                                                                   "
                        });


        System.out.println(" ".repeat(100));
        System.out.println("Exemples d'utilisation de notre structure de données doublement chaînée !");
        System.out.println(" ".repeat(100));


        /////////////////////////////////////////////////////////////////////////////////////
        // Exemples basiques
        /////////////////////////////////////////////////////////////////////////////////////
        printTitleBox("█ Exemples basiques");


        Point a = new Point(4, 5);
        Point b = new Point(5, 6);
        Point c = new Point(6, 7);

        System.out.println("\n// creation de trois Point a,b et c");
        System.out.println("-".repeat(80));

        printCode("Point a = new Point(4, 5);");
        System.out.println(a);
        printCode("Point b = new Point(5, 6);");
        System.out.println(b);
        printCode("Point c = new Point(6, 7);");
        System.out.println(c);


        System.out.println("\n// creation d'une nouvelle liste List avec le constructeur a un argument");
        System.out.println("-".repeat(80));

        List<Point> list = new List<>(a);
        printCode("List<Point> list = new List<>(a);");


        System.out.println("\n// Ajout a la fin de la liste de b et c");
        list.append(b);
        list.append(c);
        printCode("list.append(b);");
        printCode("list.append(c);");

        System.out.println("\n// Récupèration du première element");
        System.out.println("-".repeat(80));
        printCode("list.getFirst();");
        System.out.println(list.getFirst());

        System.out.println("\n// Récupèration du dérnière element");
        System.out.println("-".repeat(80));
        printCode("list.getLast();");
        System.out.println(list.getLast());

        System.out.println("\n// Récupèration de la longeur de la Liste");
        System.out.println("-".repeat(80));
        printCode("list.length;");
        System.out.println(list.length);

        System.out.println("\n// Verifier si la liste est vide");
        System.out.println("-".repeat(80));
        printCode("list.isEmpty();");
        System.out.println(list.isEmpty());

        System.out.println("\n// Récupèrer un élement via l'index");
        System.out.println("-".repeat(80));
        printCode("list.get(1);");
        System.out.println(list.get(1));


        System.out.println("\n// Supression du deuxième élement");
        System.out.println("-".repeat(80));
        printCode("list.remove(1);");
        list.remove(1);
        printCode("list.length;");
        System.out.println(list.length);

        printCode("list.remove(1);");
        list.remove(1);
        printCode("list.length;");
        System.out.println(list.length);




        // insert
        printTitleBox("█ Exemples d'insertion:");

        System.out.println("\nRéaffectation de notre variable list avec un nouvel objet 'List' vide");
        System.out.println("-".repeat(80));

        list = new List<>();
        list.insert(0, new Point(1,1));
        list.insert(1, new Point(2,2));
        list.insert(2, new Point(3,3));
        list.insert(0, new Point(4,4));
        System.out.println(
                ">list = new List<>();\n" +
                        ">list.insert(0, new Point(1,1));\n" +
                        ">list.insert(1, new Point(2,2));\n" +
                        ">list.insert(2, new Point(3,3));\n" +
                        ">list.insert(0, new Point(4,4));");
        // affichage
        System.out.println("Resultat:");
        printCode("list.get(0);");
        System.out.println(list.get(0));
        printCode("list.get(1);");
        System.out.println(list.get(1));
        printCode("list.get(2);");
        System.out.println(list.get(2));
        printCode("list.get(3);");
        System.out.println(list.get(3));


        /////////////////////////////////////////////////////////////////////////////////////
        // Filtres
        /////////////////////////////////////////////////////////////////////////////////////

        printTitleBox("█ Exemples de filtres");


        System.out.println("\n// creation d'un tableau de cinq points(Point):");

        Point[] points = new Point[]{
                new Point(1, 5),
                new Point(4, 4),
                new Point(3, 3),
                new Point(4, 2),
                new Point(5, 1)
        };

        for(Point p:points){
            System.out.println(p);
        }

        list = new List<>(points);
        System.out.println("\n// Réaffectation de notre variable list avec un nouvel objet List crée a partir d'un tableau de points cet fois");
        printCode("list = new List<>(points);");




        // filtre carre
        Filtre<Point> carre = new Filtre<>() {
            @Override
            public boolean apply(Point p) {
                return p.getX() == p.getY();
            }
        };
        System.out.println("\n// creation d'une instance d'une class anonyme appeler 'carre' qui étand la class abstraite Filtre<Point>");
        printCode("Filtre<Point> carre = new Filtre<>() {\n" +
                "            @Override\n" +
                "            public boolean apply(Point p) {\n" +
                "                return p.getX() == p.getY();\n" +
                "            }\n" +
                "        };");

        System.out.println("\n//utilisation du filtre 'carre':");
        printCode("list.find(carre);");
        System.out.println(list.find(carre));



        // Filtre xGreaterTwiceY
        Filtre<Point> xGreaterTwiceY = point -> point.getX() > point.getY() * 2;
        System.out.println("\n// creation de 'xGreaterTwiceY' une instance d'une class anonyme et fonctionnel qui implemente Filtre ");
        printCode("Filtre<Point> xGreaterTwiceY = point -> point.getX() > point.getY() * 2;");

        System.out.println("\n//utilisation du filtre 'xGreaterTwiceY':");
        printCode("list.find(xGreaterTwiceY);");
        System.out.println(list.find(xGreaterTwiceY));

        // Filtre yGreaterTwiceX
        System.out.println("\n// creation et utilisation d'un filtre anonyme qui aurais pu s'appeler 'yGreaterTwiceX'");
        printCode("list.find(point -> point.getY() > point.getX() * 2)");
        System.out.println(list.find(point -> point.getY() > point.getX() * 2));



        /////////////////////////////////////////////////////////////////////////////////////
        // Iterator
        /////////////////////////////////////////////////////////////////////////////////////

        printTitleBox("█ Iterator example : ");


        System.out.println("Creation d'un nouvel objet 'List'");
        list = new List<>(new Point[]{
                new Point(4, 1),
                new Point(8, 4),
                new Point(4, 9),
                new Point(1, 3),
                new Point(7, 7)
        });
        printCode("list = new List<>(\n" +
                "        new Point[]{\n" +
                "        new Point(4, 1),\n" +
                "        new Point(8, 4),\n" +
                "        new Point(4, 9),\n" +
                "        new Point(1, 3),\n" +
                "        new Point(7, 7)\n" +
                "});");


        System.out.println("Utilisation de la boucle for-each sur notre structure:");
        System.out.println("for (Point x : list) {\n" +
                "       System.out.println(x);\n" +
                "}");
        for (Point x : list) {
            System.out.println(x);
        }
        printFromArray(new String[]{
                "                                                                                                   " ,
                "       ██╗  ██╗ █████╗ ██╗  ██╗██╗███╗   ███╗    ███████╗ █████╗  ██████╗ ██╗   ██╗██████╗ ██╗     " ,
                "       ██║  ██║██╔══██╗██║ ██╔╝██║████╗ ████║    ██╔════╝██╔══██╗██╔═══██╗██║   ██║██╔══██╗██║     " ,
                "       ███████║███████║█████╔╝ ██║██╔████╔██║    ███████╗███████║██║   ██║██║   ██║██║  ██║██║     " ,
                "       ██╔══██║██╔══██║██╔═██╗ ██║██║╚██╔╝██║    ╚════██║██╔══██║██║   ██║██║   ██║██║  ██║██║     " ,
                "       ██║  ██║██║  ██║██║  ██╗██║██║ ╚═╝ ██║    ███████║██║  ██║╚██████╔╝╚██████╔╝██████╔╝██║     " ,
                "       ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝╚═╝     ╚═╝    ╚══════╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═════╝ ╚═╝     " ,
                "                                                                                                   " }
                );

    }

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