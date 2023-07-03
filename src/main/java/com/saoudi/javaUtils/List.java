package com.saoudi.javaUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Classe concrète représentant une liste générique.
 *
 * @param <T> le type des éléments de la liste
 */
public class List<T> extends ListAbstract<T> {

    /**
     * Construit une liste vide.
     */
    public List() {
        this.init();
    }

    /**
     * Construit une liste avec un seul élément.
     *
     * @param t l'élément à ajouter à la liste
     */
    public List(T t) {
        this.init(t);
    }

    /**
     * Construit une liste à partir d'un tableau d'éléments.
     *
     * @param tab le tableau d'éléments à ajouter à la liste
     */
    public List(T[] tab) {
        this.init(tab);
    }

    /**
     * Initialise la liste avec un seul élément.
     *
     * @param t l'élément à ajouter à la liste
     */
    @Override
    protected void init(T t) {
        this.first = new Element<>(t);
        this.last = first;
        this.length = 1;
    }

    /**
     * Initialise la liste à partir d'un tableau d'éléments.
     *
     * @param tab le tableau d'éléments à ajouter à la liste
     */
    @Override
    protected void init(T[] tab) {
        if (tab == null || tab.length == 0) {
            this.init();
            return;
        }
        this.first = new Element<>(tab[0]);
        Element<T> curr = this.first;
        for (int i = 1; i < tab.length; i++) {
            Element<T> next = new Element<>(tab[i]);
            curr.setNext(next);
            next.setPrev(curr);
            curr = next;
        }
        this.last = curr;
        this.length = tab.length;
    }

    /**
     * Ajoute un élément au début de la liste.
     *
     * @param t l'élément à ajouter
     */
    @Override
    public void push(T t) {
        if (this.last == null) {
            this.init(t);
        } else {
            Element<T> newElement = new Element<>(t);
            newElement.next = this.first;
            this.first.prev = newElement;
            this.first = newElement;
            this.length++;
        }
    }

    /**
     * Ajoute un élément à la fin de la liste.
     *
     * @param t l'élément à ajouter
     */
    @Override
    public void append(T t) {
        if (this.last == null) {
            this.init(t);
        } else {
            Element<T> newElement = new Element<>(t);
            newElement.prev = this.last;
            this.last.next = newElement;
            this.last = newElement;
            this.length++;
        }
    }

    /**
     * Retourne une nouvelle liste contenant tous les éléments qui satisfont le filtre spécifié.
     *
     * @param f le filtre à appliquer
     * @return une nouvelle liste contenant les éléments filtrés
     */
    @Override
    public List<T> findAll(Filtre<T> f) {
        List<T> newList = new List<>();
        Element<T> curr = this.first;
        while (curr != null) {
            if (f.apply(curr.element))
                newList.append(curr.element);
            curr = curr.next;
        }
        return newList;
    }

    /**
     * Retourne un nouvel ArrayList contenant tous les éléments.
     *
     * @return un ArrayList contenant tous nos éléments.
     */
    @Override
    public ArrayList<T> toArrayList(){
        ArrayList<T> res = new ArrayList<>();
        for(T t:this){
            res.add(t);
        }
        return res;
    }

    /**
     * Retourne un nouveau tableau T[] contenant tous les éléments.
     *
     * @return un tableau T[] contenant tous nos éléments.
     */
    @Override
    public Object[] toArray(){
        Object[] res = new Object[length];
        int i = 0;
        for(T t:this){
            res[i] = t;
            i++;
        }
        return res;
    }

//    public T[] toArrayTest(){
//        if(first==null) return null;
//        T[] res = (T[]) Array.newInstance(first.element.getClass(), length);
////        T[] res = (T[]) new Object[length];
//        int i = 0;
//        for(T t:this){
//            res[i] = t;
//            i++;
//        }
//        return res;
//    }
}
