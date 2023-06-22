# Documentation

## `public class Point implements Cloneable`

Classe représentant un point dans un plan cartésien. Les coordonnées du point sont des entiers.

## `public Point(int x, int y)`

Constructeur de la classe Point. Crée un point avec les coordonnées spécifiées.

* **Parameters:**
    * `x` — La coordonnée x du point.
    * `y` — La coordonnée y du point.

## `public Point(int n)`

Constructeur de la classe Point. Crée un point avec les mêmes coordonnées pour x et y.

* **Parameters:** `n` — La valeur des coordonnées x et y du point.

## `@Override public String toString()`

Renvoie une représentation sous forme de chaîne de caractères du point.

* **Returns:** La représentation du point sous forme de chaîne de caractères.

## `@Override public boolean equals(Object o)`

Vérifie si le point est égal à un autre objet.

* **Parameters:** `o` — L'objet à comparer.
* **Returns:** true si l'objet est un point et a les mêmes coordonnées, false sinon.

## `@Override public Point clone() throws CloneNotSupportedException`

Crée et renvoie une copie du point.

* **Returns:** La copie du point.
* **Exceptions:** `CloneNotSupportedException` — Si la classe Point n'implémente pas l'interface Cloneable.

## `@Override public int hashCode()`

Calcule et renvoie le code de hachage du point.

* **Returns:** Le code de hachage du point.

## `public int getX()`

Renvoie la coordonnée x du point.

* **Returns:** La coordonnée x du point.

## `public void setX(int x)`

Définit la coordonnée x du point.

* **Parameters:** `x` — La nouvelle coordonnée x du point.

## `public int getY()`

Renvoie la coordonnée y du point.

* **Returns:** La coordonnée y du point.

## `public void setY(int y)`

Définit la coordonnée y du point.

* **Parameters:** `y` — La nouvelle coordonnée y du point.