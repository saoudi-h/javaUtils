package com.saoudi.javaUtils;

import static com.saoudi.javaUtils.ConsoleColor.*;
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


        listExamples();
        listCloneableExamples();


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

    public static void listExamples(){
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




        /////////////////////////////////////////////////////////////////////////////////////
        // Find All
        /////////////////////////////////////////////////////////////////////////////////////
        printTitleBox("█ findAll exemple : ");

        printCode("        Point[] points2 = new Point[]{\n" +
                "                new Point(1, 5),\n" +
                "                new Point(4, 4),\n" +
                "                new Point(3, 3),\n" +
                "                new Point(4, 2),\n" +
                "                new Point(5, 1),\n" +
                "                new Point(1, 9),\n" +
                "                new Point(1, 4),\n" +
                "                new Point(13, 3),\n" +
                "                new Point(44, 2),\n" +
                "                new Point(5, 15)\n" +
                "        };\n" +
                "\n" +
                "        for(Point p:points2){\n" +
                "            System.out.println(p);\n" +
                "        }");
        Point[] points2 = new Point[]{
                new Point(1, 5),
                new Point(4, 4),
                new Point(3, 3),
                new Point(4, 2),
                new Point(5, 1),
                new Point(1, 9),
                new Point(1, 4),
                new Point(13, 3),
                new Point(44, 2),
                new Point(5, 15)
        };

        for(Point p:points2){
            System.out.println(p);
        }

        list = new List<>(points2);
        System.out.println("\n// Réaffectation de notre variable list avec un nouvel objet List crée a partir d'un tableau de points cet fois");
        printCode("list = new List<>(points2);");

        // filtre carre
        System.out.println("\n//utilisation du filtre 'carre':");
        printCode("        List<Point> findList = list.findAll(carre);\n" +
                "        for(Point p:findList){\n" +
                "            System.out.println(p);\n" +
                "        }");
        List<Point> findList = list.findAll(carre);
        for(Point p:findList){
            System.out.println(p);
        }



        // Filtre xGreaterTwiceY
        System.out.println("\n//utilisation du filtre 'xGreaterTwiceY':");
        printCode("        findList = list.findAll(xGreaterTwiceY);\n" +
                "        for(Point p:findList){\n" +
                "            System.out.println(p);\n" +
                "        }");
        findList = list.findAll(xGreaterTwiceY);
        for(Point p:findList){
            System.out.println(p);
        }

        // Filtre yGreaterTwiceX
        System.out.println("//utilisation du filtre 'yGreaterTwiceX':");
        printCode("        findList = list.findAll(point -> point.getY() > point.getX() * 2);\n" +
                "        for(Point p:findList){\n" +
                "            System.out.println(p);\n" +
                "        }");
        findList = list.findAll(point -> point.getY() > point.getX() * 2);
        for(Point p:findList){
            System.out.println(p);
        }
    }
    public static void listCloneableExamples(){
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




        /////////////////////////////////////////////////////////////////////////////////////
        // Find All
        /////////////////////////////////////////////////////////////////////////////////////
        printTitleBox("█ findAll exemple : ");

        printCode("        Point[] points2 = new Point[]{\n" +
                "                new Point(1, 5),\n" +
                "                new Point(4, 4),\n" +
                "                new Point(3, 3),\n" +
                "                new Point(4, 2),\n" +
                "                new Point(5, 1),\n" +
                "                new Point(1, 9),\n" +
                "                new Point(1, 4),\n" +
                "                new Point(13, 3),\n" +
                "                new Point(44, 2),\n" +
                "                new Point(5, 15)\n" +
                "        };\n" +
                "\n" +
                "        for(Point p:points2){\n" +
                "            System.out.println(p);\n" +
                "        }");
        Point[] points2 = new Point[]{
                new Point(1, 5),
                new Point(4, 4),
                new Point(3, 3),
                new Point(4, 2),
                new Point(5, 1),
                new Point(1, 9),
                new Point(1, 4),
                new Point(13, 3),
                new Point(44, 2),
                new Point(5, 15)
        };

        for(Point p:points2){
            System.out.println(p);
        }

        list = new List<>(points2);
        System.out.println("\n// Réaffectation de notre variable list avec un nouvel objet List crée a partir d'un tableau de points cet fois");
        printCode("list = new List<>(points2);");

        // filtre carre
        System.out.println("\n//utilisation du filtre 'carre':");
        printCode("        List<Point> findList = list.findAll(carre);\n" +
                "        for(Point p:findList){\n" +
                "            System.out.println(p);\n" +
                "        }");
        List<Point> findList = list.findAll(carre);
        for(Point p:findList){
            System.out.println(p);
        }



        // Filtre xGreaterTwiceY
        System.out.println("\n//utilisation du filtre 'xGreaterTwiceY':");
        printCode("        findList = list.findAll(xGreaterTwiceY);\n" +
                "        for(Point p:findList){\n" +
                "            System.out.println(p);\n" +
                "        }");
        findList = list.findAll(xGreaterTwiceY);
        for(Point p:findList){
            System.out.println(p);
        }

        // Filtre yGreaterTwiceX
        System.out.println("//utilisation du filtre 'yGreaterTwiceX':");
        printCode("        findList = list.findAll(point -> point.getY() > point.getX() * 2);\n" +
                "        for(Point p:findList){\n" +
                "            System.out.println(p);\n" +
                "        }");
        findList = list.findAll(point -> point.getY() > point.getX() * 2);
        for(Point p:findList){
            System.out.println(p);
        }
    }
}