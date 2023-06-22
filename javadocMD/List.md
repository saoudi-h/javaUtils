# Documentation

## `public class List<T> extends ListAbstract<T>`

Classe concrète représentant une liste générique.

* **Parameters:** `<T>` — le type des éléments de la liste

## `public List()`

Construit une liste vide.

## `public List(T t)`

Construit une liste avec un seul élément.

* **Parameters:** `t` — l'élément à ajouter à la liste

## `public List(T[] tab)`

Construit une liste à partir d'un tableau d'éléments.

* **Parameters:** `tab` — le tableau d'éléments à ajouter à la liste

## `@Override protected void init(T t)`

Initialise la liste avec un seul élément.

* **Parameters:** `t` — l'élément à ajouter à la liste

## `@Override protected void init(T[] tab)`

Initialise la liste à partir d'un tableau d'éléments.

* **Parameters:** `tab` — le tableau d'éléments à ajouter à la liste

## `@Override public void push(T t)`

Ajoute un élément au début de la liste.

* **Parameters:** `t` — l'élément à ajouter

## `@Override public void append(T t)`

Ajoute un élément à la fin de la liste.

* **Parameters:** `t` — l'élément à ajouter

## `@Override public List<T> findAll(Filtre<T> f)`

Retourne une nouvelle liste contenant tous les éléments qui satisfont le filtre spécifié.

* **Parameters:** `f` — le filtre à appliquer
* **Returns:** une nouvelle liste contenant les éléments filtrés