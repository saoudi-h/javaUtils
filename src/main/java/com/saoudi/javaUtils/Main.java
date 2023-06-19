package com.saoudi.javaUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start !");
        Point a = new Point(4,5);
        Point b = new Point(5,6);
        Point c = new Point(6,7);
        List<Point> listA = new List<Point>(a);
        listA.append(b);
        listA.append(c);
        System.out.println(listA.getFirst());
        System.out.println(listA.getLast());
        System.out.println(listA.length);
        System.out.println(listA.isEmpty());
        System.out.println("recuperation de l'index 1 "+ listA.get(1));
        listA.remove(1);
        System.out.println(listA.length);
        listA.remove(1);
        System.out.println(listA.length);
        System.out.println("End !");
        /////////////////////////////////////////////////////////////////////
        //  filtre
        /////////////////////////////////////////////////////////////////////


        List<Point> listB = new List<Point>(
                new Point[]{
                        new Point(1,5),
                        new Point(4,4),
                        new Point(3,3),
                        new Point(4,2),
                        new Point(5,1)
                }
        );
        System.out.println("list b get : " + listB.get(0));
        System.out.println("list b get : " + listB.get(1));
        System.out.println("list b get : " + listB.get(2));
        System.out.println("list b get : " + listB.get(3));
        System.out.println("list b get : " + listB.get(4));
        System.out.println("list b get : " + listB.get(5));


        // filtre carre
        Filtre<Point> carre = new Filtre<Point>() {
            @Override
            public boolean apply(Point p) {
                return p.getX()==p.getY();
            }
        };

        System.out.println(listB.getFirst(carre));
        // filtre xGreaterTwiceY
         Filtre<Point> xGreaterTwiceY = point -> point.getX()>point.getY()*2;
        System.out.println(listB.getFirst(xGreaterTwiceY));
        // filtre yGreaterTwiceX
        System.out.println(listB.getFirst(point -> point.getY()>point.getX()*2));

    }
}