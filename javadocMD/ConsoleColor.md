# Documentation

## `public class ConsoleColor`

Classe utilitaire pour l'affichage de texte coloré dans la console.

## `public static void printTitleBox(String title)`

Affiche une boîte de titre colorée avec le texte spécifié.

* **Parameters:** `title` — le texte du titre

## `public static void printTitleBox(String title, int length)`

Affiche une boîte de titre colorée avec le texte et la longueur spécifiés.

* **Parameters:**
    * `title` — le texte du titre
    * `length` — la longueur de la boîte

## `public static void printBigTitleBox(String title, int length, Attribute textColor,Attribute bgColor)`

Affiche une grande boîte de titre colorée avec le texte, la longueur et les attributs de couleur spécifiés.

* **Parameters:**
    * `title` — le texte du titre
    * `length` — la longueur de la boîte
    * `textColor` — l'attribut de couleur du texte
    * `bgColor` — l'attribut de couleur de l'arrière-plan

## `public static void printBigTitleBox(String title)`

Affiche une grande boîte de titre colorée avec le texte spécifié.

* **Parameters:** `title` — le texte du titre

## `public static void printTitleBox(String title, int length, Attribute textColor,Attribute bgColor)`

Affiche une boîte de titre colorée avec le texte, la longueur et les attributs de couleur spécifiés.

* **Parameters:**
    * `title` — le texte du titre
    * `length` — la longueur de la boîte
    * `textColor` — l'attribut de couleur du texte
    * `bgColor` — l'attribut de couleur de l'arrière-plan

## `public static void printFromArray(String[] arr)`

Affiche le contenu d'un tableau de chaînes avec les attributs de couleur par défaut.

* **Parameters:** `arr` — le tableau de chaînes à afficher

## `public static void printFromArray(String[] arr,Attribute textColor,Attribute bgColor)`

Affiche le contenu d'un tableau de chaînes avec des attributs de couleur spécifiés.

* **Parameters:**
    * `arr` — le tableau de chaînes à afficher
    * `textColor` — l'attribut de couleur du texte
    * `bgColor` — l'attribut de couleur de l'arrière-plan

## `public static void printCode(String[] arr)`

Affiche du code source avec une coloration syntaxique basique.

* **Parameters:** `arr` — le code source à afficher, chaque ligne étant un élément du tableau

## `public static void printCode(String code)`

Affiche du code source avec une coloration syntaxique basique.

* **Parameters:** `code` — le code source à afficher sous forme d'une seule chaîne

## `private static String getLineCode(String line)`

Retourne une ligne de code source avec une coloration syntaxique basique.

* **Parameters:** `line` — la ligne de code source à colorer
* **Returns:** la ligne de code source colorée