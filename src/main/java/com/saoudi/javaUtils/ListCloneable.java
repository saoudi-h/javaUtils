package com.saoudi.javaUtils;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * Classe représentant une liste chainée d'éléments implémentant l'interface Clonaeable.
 * Cette classe a la particularité de travailler avec des clones des éléments et retourne égalements des clones.
 *
 * @param <T> le type des éléments de la liste
 */
/**
 * Classe concrète représentant une liste générique clonable.
 *
 * @param <T> le type des éléments de la liste, qui doit implémenter l'interface Cloneable
 */
public class ListCloneable<T extends Cloneable> extends ListAbstract<T> {


    private Class<T> elementType;
    /**
     * Construit une liste avec un seul élément clonable.
     *
     * @param t l'élément clonable à ajouter à la liste
     */
    public ListCloneable(T t) {
        super(t);
    }

    /**
     * Construit une liste à partir d'un tableau d'éléments clonables.
     *
     * @param tab le tableau d'éléments clonables à ajouter à la liste
     */
    public ListCloneable(T[] tab) {
        this.init(tab);
    }

    /**
     * Initialise la liste avec un seul élément clonable.
     *
     * @param t l'élément clonable à ajouter à la liste
     */
    @Override
    protected void init(T t) {
        this.first = new Element<>(copyT(t));
        this.last = first;
        this.length = 1;
    }

    /**
     * Initialise la liste à partir d'un tableau d'éléments clonables.
     *
     * @param tab le tableau d'éléments clonables à ajouter à la liste
     */
    @Override
    protected void init(T[] tab) {
        if (tab == null || tab.length == 0) {
            this.init();
            return;
        }
        this.first = new Element<>(copyT(tab[0]));
        Element<T> curr = this.first;
        for (int i = 1; i < tab.length; i++) {
            Element<T> next = new Element<>(copyT(tab[i]));
            curr.setNext(next);
            next.setPrev(curr);
            curr = next;
        }
        this.last = curr;
        this.length = tab.length;
    }

    /**
     * Construit une liste vide.
     */
    public ListCloneable() {
        super();
    }

    /**
     * Ajoute un élément clonable au début de la liste.
     *
     * @param t l'élément clonable à ajouter
     */
    @Override
    public void push(T t) {
        if (this.last == null) {
            this.init(t);
        } else {
            Element<T> newElement = new Element<>(copyT(t));
            newElement.next = this.first;
            this.first.prev = newElement;
            this.first = newElement;
            this.length++;
        }
    }

    /**
     * Ajoute un élément clonable à la fin de la liste.
     *
     * @param t l'élément clonable à ajouter
     */
    @Override
    public void append(T t) {
        if (this.last == null) {
            this.init(t);
        } else {
            Element<T> newElement = new Element<>(copyT(t));
            newElement.prev = this.last;
            this.last.next = newElement;
            this.last = newElement;
            this.length++;
        }
    }

    /**
     * Insère un élément clonable à l'index spécifié dans la liste.
     *
     * @param index l'index d'insertion
     * @param t     l'élément clonable à insérer
     */
    @Override
    public void insert(int index, T t) {
        super.insert(index, copyT(t));
    }

    /**
     * Récupère l'élément clonable à l'index spécifié dans la liste.
     *
     * @param index l'index de l'élément à récupérer
     * @return l'élément clonable à l'index spécifié
     */
    @Override
    public T get(int index) {
        return copyT(super.get(index));
    }

    /**
     * Remplace l'élément à l'index spécifié dans la liste par l'élément clonable spécifié.
     *
     * @param index l'index de l'élément à remplacer
     * @param t     le nouvel élément clonable
     */
    @Override
    public void set(int index, T t) {
        super.set(index, copyT(t));
    }

    /**
     * Retourne une nouvelle liste contenant tous les éléments qui satisfont le filtre spécifié.
     *
     * @param f le filtre à appliquer
     * @return une nouvelle liste contenant les éléments filtrés
     */
    @Override
    public ListCloneable<T> findAll(Filtre<T> f) {
        ListCloneable<T> newList = new ListCloneable<>();
        Element<T> curr = this.first;
        while (curr != null) {
            if (f.apply(curr.element))
                newList.append(copyT(curr.element));
            curr = curr.next;
        }
        return newList;
    }

    /**
     * Effectue une copie de l'objet clonable spécifié en utilisant la méthode de clonage.
     *
     * @param t l'objet clonable à copier
     * @return la copie de l'objet clonable, ou null en cas d'erreur de clonage
     */
    private T copyT(T t) {
        try {
            T clone = (T) t.getClass().getMethod("clone").invoke(t);
            return clone;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Retourne un nouvel ArrayList contenant la copie de tous les éléments.
     *
     * @return un ArrayList contenant la copie de tous nos éléments.
     */
    @Override
    public ArrayList<T> toArrayList(){
        ArrayList<T> res = new ArrayList<>();
        for(T t:this){
            res.add(copyT(t));
        }
        return res;
    }

    /**
     * Retourne un nouveau tableau Object[] contenant la copie de tous les éléments.
     *
     * @return un tableau Object[] contenant la copie de tous nos éléments.
     */
    @Override
    public Object[] toArray(){
        Object[] res = new Object[length];
        int i = 0;
        for(T t:this){
            res[i] = copyT(t);
            i++;
        }
        return res;
    }
}