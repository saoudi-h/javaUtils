package com.saoudi.javaUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Classe abstraite représentant une liste chainée abstraite.
 *
 * @param <T> le type des éléments de la liste
 */
public abstract class ListAbstract<T> implements Iterable<T> {
    /**
     * La longueur de la liste.
     */
    public int length;

    /**
     * Le premier élément de la liste.
     */
    protected Element<T> first;

    /**
     * Le dernier élément de la liste.
     */
    protected Element<T> last;


    /**
     * Constructeur par défaut de la liste abstraite.
     */
    public ListAbstract() {
        this.init();
    }

    /**
     * Constructeur de la liste abstraite avec un élément initial.
     *
     * @param t l'élément initial
     */
    public ListAbstract(T t) {
        this.init(t);
    }

    /**
     * Constructeur de la liste abstraite avec un tableau d'éléments.
     *
     * @param tab le tableau d'éléments
     */
    public ListAbstract(T[] tab) {
        this.init(tab);
    }

    /**
     * Retourne un itérateur pour la liste.
     *
     * @return l'itérateur de la liste
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    /**
     * Retourne le premier élément de la liste.
     *
     * @return le premier élément
     */
    public T getFirst() {
        if (this.first == null) return null;
        return first.element;
    }

    /**
     * Définit le premier élément de la liste.
     *
     * @param first le premier élément
     */
    public void setFirst(T first) {
        if (this.first != null)
            this.first.setElement(first);
    }

    /**
     * Retourne le dernier élément de la liste.
     *
     * @return le dernier élément
     */
    public T getLast() {
        if (this.first == null) return null;
        return last.getElement();
    }

    /**
     * Définit le dernier élément de la liste.
     *
     * @param last le dernier élément
     */
    public void setLast(T last) {
        if (this.first != null)
            this.last.setElement(last);
    }

    /**
     * Initialise la liste.
     */
    protected void init() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    /**
     * Méthode abstraite pour initialiser la liste avec un élément.
     *
     * @param t l'élément initial
     */
    protected abstract void init(T t);

    /**
     * Méthode abstraite pour initialiser la liste avec un tableau d'éléments.
     *
     * @param tab le tableau d'éléments
     */
    protected abstract void init(T[] tab);

    /**
     * Méthode abstraite pour ajouter un élément en début de liste.
     *
     * @param t l'élément à ajouter
     */
    public abstract void push(T t);

    /**
     * Méthode abstraite pour ajouter un élément en fin de liste.
     *
     * @param t l'élément à ajouter
     */
    public abstract void append(T t);

    /**
     * Insère un élément à la position spécifiée dans la liste.
     *
     * @param index l'index où insérer l'élément
     * @param t     l'élément à insérer
     * @throws IllegalArgumentException si l'index est hors limites
     */
    public void insert(int index, T t) {
        if (index > length || index < 0)
            throw new IllegalArgumentException("Index hors limites.");
        if (this.last == null || index == length) {
            this.append(t);
        } else {
            Element<T> targetElement = this.getElement(index);
            Element<T> newElement = new Element<>(t);
            newElement.next = targetElement;
            newElement.prev = targetElement.prev;
            targetElement.prev = newElement;
            if (newElement.prev != null)
                newElement.prev.next = newElement;
            this.length++;
            if (index == 0) this.first = newElement;
        }
    }


    /**
     * Récupère l'élément à l'index spécifié dans la liste.
     *
     * @param index l'index de l'élément à récupérer
     * @return l'élément à l'index spécifié, ou null si l'index est hors limites
     */
    protected Element<T> getElement(int index) {
        if (index >= length || index < 0)
            return null;

        boolean isAsc = index < (this.length / 2);
        Element<T> curr;
        if (isAsc) {
            curr = this.first;
            int i = 0;
            while (index != i) {
                curr = curr.next;
                i++;
            }
        } else {
            curr = this.last;
            int i = this.length - 1;
            while (index != i) {
                curr = curr.prev;
                i--;
            }
        }
        return curr;
    }

    /**
     * Récupère l'élément à l'index spécifié dans la liste.
     *
     * @param index l'index de l'élément à récupérer
     * @return l'élément à l'index spécifié, ou null si l'index est hors limites
     */
    public T get(int index) {
        Element<T> tmp = this.getElement(index);
        return tmp == null ? null : tmp.element;
    }

    /**
     * Modifie l'élément à l'index spécifié dans la liste.
     *
     * @param index l'index de l'élément à modifier
     * @param t     le nouvel élément
     * @throws IllegalArgumentException si l'index est hors limites
     */
    public void set(int index, T t) {
        if (index >= length || index < 0)
            throw new IllegalArgumentException("Index hors limites.");
        Element<T> e = this.getElement(index);
        if (e != null) e.setElement(t);
    }

    /**
     * Vérifie si la liste est vide.
     *
     * @return true si la liste est vide, false sinon
     */
    public boolean isEmpty() {
        return this.last == null;
    }

    /**
     * Vide la liste, supprime tous les éléments.
     */
    public void clear() {
        Element<T> curr = this.first;
        this.first = this.last = null;

        while (curr != null) {
            Element<T> next = curr.next;
            curr.next = null;
            curr.prev = null;
            curr.element = null;
            curr = next;
        }
        this.length = 0;
    }

    /**
     * Supprime l'élément à l'index spécifié dans la liste.
     *
     * @param index l'index de l'élément à supprimer
     * @throws IndexOutOfBoundsException si l'index est hors limites
     */
    public void remove(int index) {
        if (index >= this.length || index < 0)
            throw new IndexOutOfBoundsException("Index hors limites.");
        Element<T> target = this.getElement(index);
        if (target.next != null)
            target.next.prev = target.prev;
        if (target.prev != null)
            target.prev.next = target.next;
        target.element = null;
        target.next = null;
        target.prev = null;
        this.length--;
    }

    /**
     * Recherche un élément qui correspond au filtre spécifié dans la liste.
     *
     * @param f le filtre à appliquer
     * @return le premier élément correspondant au filtre, ou null s'il n'y en a pas
     */
    public T find(Filtre<T> f) {
        Element<T> curr = this.first;
        while (curr != null) {
            if (f.apply(curr.element))
                return curr.element;
            curr = curr.next;
        }
        return null;
    }

    /**
     * Recherche tous les éléments qui correspondent au filtre spécifié dans la liste.
     *
     * @param f le filtre à appliquer
     * @return une liste contenant tous les éléments correspondants au filtre
     */
    public abstract ListAbstract<T> findAll(Filtre<T> f);

    /**
     * Méthode abstraite retourne un ArrayList contenant tous les éléments de List.
     *
     * @return un ArrayList contenant tous nos éléments.
     */
    public abstract ArrayList<T> toArrayList();

    /**
     * Méthode abstraite qui retourne un nouveau tableau Object[] contenant tous les éléments de type T.
     *
     * @return un tableau Object[] contenant tous nos éléments.
     */
    public abstract Object[] toArray();


    /**
     * Classe interne représentant un élément d'une liste.
     *
     * @param <T> le type des éléments de la liste
     */
    protected static class Element<T> {

        protected Element<T> next;
        protected Element<T> prev;
        protected T element;

        /**
         * Constructeur de la classe Element avec les éléments suivant, précédent et la valeur de l'élément.
         *
         * @param next    l'élément suivant
         * @param prev    l'élément précédent
         * @param element la valeur de l'élément
         */
        public Element(Element<T> next, Element<T> prev, T element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }

        /**
         * Constructeur de la classe Element avec la valeur de l'élément. Les éléments suivant et précédent sont initialisés à null.
         *
         * @param element la valeur de l'élément
         */
        public Element(T element) {
            this.next = null;
            this.prev = null;
            this.element = element;
        }

        /**
         * Retourne la valeur de l'élément.
         *
         * @return la valeur de l'élément
         */
        public T getElement() {
            return element;
        }

        /**
         * Modifie la valeur de l'élément.
         *
         * @param element la nouvelle valeur de l'élément
         */
        public void setElement(T element) {
            this.element = element;
        }

        /**
         * Retourne une représentation sous forme de chaîne de caractères de l'élément.
         *
         * @return la représentation sous forme de chaîne de caractères de l'élément
         */
        @Override
        public String toString() {
            return this.element.toString();
        }

        /**
         * Vérifie si l'objet spécifié est égal à l'élément actuel.
         *
         * @param o l'objet à comparer
         * @return true si l'objet spécifié est égal à l'élément actuel, sinon false
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element<?> element1 = (Element<?>) o;
            return Objects.equals(element, element1.element);
        }

        /**
         * Retourne le code de hachage de l'élément.
         *
         * @return le code de hachage de l'élément
         */
        @Override
        public int hashCode() {
            return Objects.hash(element);
        }

        /**
         * Retourne l'élément suivant.
         *
         * @return l'élément suivant
         */
        public Element<T> getNext() {
            return next;
        }

        /**
         * Modifie l'élément suivant.
         *
         * @param next le nouvel élément suivant
         */
        public void setNext(Element<T> next) {
            this.next = next;
        }

        /**
         * Retourne l'élément précédent.
         *
         * @return l'élément précédent
         */
        public Element<T> getPrev() {
            return prev;
        }

        /**
         * Modifie l'élément précédent.
         *
         * @param prev le nouvel element précédent
         */
        public void setPrev(Element<T> prev) {
            this.prev = prev;
        }

    }

    /**
     * Classe interne représentant un itérateur pour parcourir les éléments d'une liste.
     */
    protected class ListIterator implements Iterator<T> {

        protected Element<T> current = first;

        /**
         * Vérifie s'il y a un élément suivant dans la liste.
         *
         * @return true s'il y a un élément suivant, sinon false
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Retourne l'élément suivant dans la liste.
         *
         * @return l'élément suivant
         * @throws NoSuchElementException si aucun élément suivant n'existe
         */
        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            T element = current.getElement();
            current = current.getNext();
            return element;
        }
    }
}
