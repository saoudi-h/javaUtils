# Documentation

## `public abstract class ListAbstract<T> implements Iterable<T>`

Classe abstraite représentant une liste chainée abstraite.

* **Parameters:** `<T>` — le type des éléments de la liste

## `public int length`

La longueur de la liste.

## `protected Element<T> first`

Le premier élément de la liste.

## `protected Element<T> last`

Le dernier élément de la liste.

## `public ListAbstract()`

Constructeur par défaut de la liste abstraite.

## `public ListAbstract(T t)`

Constructeur de la liste abstraite avec un élément initial.

* **Parameters:** `t` — l'élément initial

## `public ListAbstract(T[] tab)`

Constructeur de la liste abstraite avec un tableau d'éléments.

* **Parameters:** `tab` — le tableau d'éléments

## `@Override public Iterator<T> iterator()`

Retourne un itérateur pour la liste.

* **Returns:** l'itérateur de la liste

## `public T getFirst()`

Retourne le premier élément de la liste.

* **Returns:** le premier élément

## `public void setFirst(T first)`

Définit le premier élément de la liste.

* **Parameters:** `first` — le premier élément

## `public T getLast()`

Retourne le dernier élément de la liste.

* **Returns:** le dernier élément

## `public void setLast(T last)`

Définit le dernier élément de la liste.

* **Parameters:** `last` — le dernier élément

## `protected void init()`

Initialise la liste.

## `protected abstract void init(T t)`

Méthode abstraite pour initialiser la liste avec un élément.

* **Parameters:** `t` — l'élément initial

## `protected abstract void init(T[] tab)`

Méthode abstraite pour initialiser la liste avec un tableau d'éléments.

* **Parameters:** `tab` — le tableau d'éléments

## `public abstract void push(T t)`

Méthode abstraite pour ajouter un élément en début de liste.

* **Parameters:** `t` — l'élément à ajouter

## `public abstract void append(T t)`

Méthode abstraite pour ajouter un élément en fin de liste.

* **Parameters:** `t` — l'élément à ajouter

## `public void insert(int index, T t)`

Insère un élément à la position spécifiée dans la liste.

* **Parameters:**
    * `index` — l'index où insérer l'élément
    * `t` — l'élément à insérer
* **Exceptions:** `IllegalArgumentException` — si l'index est hors limites

## `protected Element<T> getElement(int index)`

Récupère l'élément à l'index spécifié dans la liste.

* **Parameters:** `index` — l'index de l'élément à récupérer
* **Returns:** l'élément à l'index spécifié, ou null si l'index est hors limites

## `public T get(int index)`

Récupère l'élément à l'index spécifié dans la liste.

* **Parameters:** `index` — l'index de l'élément à récupérer
* **Returns:** l'élément à l'index spécifié, ou null si l'index est hors limites

## `public void set(int index, T t)`

Modifie l'élément à l'index spécifié dans la liste.

* **Parameters:**
    * `index` — l'index de l'élément à modifier
    * `t` — le nouvel élément
* **Exceptions:** `IllegalArgumentException` — si l'index est hors limites

## `public boolean isEmpty()`

Vérifie si la liste est vide.

* **Returns:** true si la liste est vide, false sinon

## `public void clear()`

Vide la liste, supprime tous les éléments.

## `public void remove(int index)`

Supprime l'élément à l'index spécifié dans la liste.

* **Parameters:** `index` — l'index de l'élément à supprimer
* **Exceptions:** `IndexOutOfBoundsException` — si l'index est hors limites

## `public T find(Filtre<T> f)`

Recherche un élément qui correspond au filtre spécifié dans la liste.

* **Parameters:** `f` — le filtre à appliquer
* **Returns:** le premier élément correspondant au filtre, ou null s'il n'y en a pas

## `public abstract ListAbstract<T> findAll(Filtre<T> f)`

Recherche tous les éléments qui correspondent au filtre spécifié dans la liste.

* **Parameters:** `f` — le filtre à appliquer
* **Returns:** une liste contenant tous les éléments correspondants au filtre

## `protected static class Element<T>`

Classe interne représentant un élément d'une liste.

* **Parameters:** `<T>` — le type des éléments de la liste

## `public Element(Element<T> next, Element<T> prev, T element)`

Constructeur de la classe Element avec les éléments suivant, précédent et la valeur de l'élément.

* **Parameters:**
    * `next` — l'élément suivant
    * `prev` — l'élément précédent
    * `element` — la valeur de l'élément

## `public Element(T element)`

Constructeur de la classe Element avec la valeur de l'élément. Les éléments suivant et précédent sont initialisés à null.

* **Parameters:** `element` — la valeur de l'élément

## `public T getElement()`

Retourne la valeur de l'élément.

* **Returns:** la valeur de l'élément

## `public void setElement(T element)`

Modifie la valeur de l'élément.

* **Parameters:** `element` — la nouvelle valeur de l'élément

## `@Override public String toString()`

Retourne une représentation sous forme de chaîne de caractères de l'élément.

* **Returns:** la représentation sous forme de chaîne de caractères de l'élément

## `@Override public boolean equals(Object o)`

Vérifie si l'objet spécifié est égal à l'élément actuel.

* **Parameters:** `o` — l'objet à comparer
* **Returns:** true si l'objet spécifié est égal à l'élément actuel, sinon false

## `@Override public int hashCode()`

Retourne le code de hachage de l'élément.

* **Returns:** le code de hachage de l'élément

## `public Element<T> getNext()`

Retourne l'élément suivant.

* **Returns:** l'élément suivant

## `public void setNext(Element<T> next)`

Modifie l'élément suivant.

* **Parameters:** `next` — le nouvel élément suivant

## `public Element<T> getPrev()`

Retourne l'élément précédent.

* **Returns:** l'élément précédent

## `public void setPrev(Element<T> prev)`

Modifie l'élément précédent.

* **Parameters:** `prev` — le nouvel element précédent

## `protected class ListIterator implements Iterator<T>`

Classe interne représentant un itérateur pour parcourir les éléments d'une liste.

## `@Override public boolean hasNext()`

Vérifie s'il y a un élément suivant dans la liste.

* **Returns:** true s'il y a un élément suivant, sinon false

## `@Override public T next()`

Retourne l'élément suivant dans la liste.

* **Returns:** l'élément suivant
* **Exceptions:** `NoSuchElementException` — si aucun élément suivant n'existe