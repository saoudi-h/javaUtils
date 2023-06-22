package com.saoudi.javaUtils;


import java.util.Objects;

/**
 * Classe représentant un point dans un plan cartésien.
 * Les coordonnées du point sont des entiers.
 */
public class Point implements Cloneable {
    private int x;
    private int y;

    /**
     * Constructeur de la classe Point.
     * Crée un point avec les coordonnées spécifiées.
     *
     * @param x La coordonnée x du point.
     * @param y La coordonnée y du point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructeur de la classe Point.
     * Crée un point avec les mêmes coordonnées pour x et y.
     *
     * @param n La valeur des coordonnées x et y du point.
     */
    public Point(int n) {
        this.x = n;
        this.y = n;
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères du point.
     *
     * @return La représentation du point sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return "Point : {" +
                "x:" + x +
                ", y:" + y +
                '}';
    }

    /**
     * Vérifie si le point est égal à un autre objet.
     *
     * @param o L'objet à comparer.
     * @return true si l'objet est un point et a les mêmes coordonnées, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    /**
     * Crée et renvoie une copie du point.
     *
     * @return La copie du point.
     * @throws CloneNotSupportedException Si la classe Point n'implémente pas l'interface Cloneable.
     */
    @Override
    public Point clone() throws CloneNotSupportedException {
        Point clonedPoint = (Point) super.clone();
        clonedPoint.x = this.x;
        clonedPoint.y = this.y;
        return clonedPoint;
    }

    /**
     * Calcule et renvoie le code de hachage du point.
     *
     * @return Le code de hachage du point.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Renvoie la coordonnée x du point.
     *
     * @return La coordonnée x du point.
     */
    public int getX() {
        return x;
    }

    /**
     * Définit la coordonnée x du point.
     *
     * @param x La nouvelle coordonnée x du point.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Renvoie la coordonnée y du point.
     *
     * @return La coordonnée y du point.
     */
    public int getY() {
        return y;
    }

    /**
     * Définit la coordonnée y du point.
     *
     * @param y La nouvelle coordonnée y du point.
     */
    public void setY(int y) {
        this.y = y;
    }
}