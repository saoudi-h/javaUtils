package com.saoudi.javaUtils;

import java.sql.SQLOutput;

public class ListCloneable<T extends Cloneable> extends ListAbstract<T>{

    public ListCloneable(T t) {

        super(t);
    }
    public ListCloneable(T[] tab) {
        this.init(tab);
    }

    @Override
    protected void init(T t) {
        this.first = new Element<>(copyT(t));
        this.last = first;
        this.length = 1;
    }

    @Override
    protected void init(T[] tab) {
        if(tab==null || tab.length==0){
            this.init();
            return;
        }
        this.first = new Element<>(copyT(tab[0]));
        Element<T> curr = this.first;
        for(int i = 1;i<tab.length;i++){
            Element<T> next = new Element<>(copyT(tab[i]));
            curr.setNext(next);
            next.setPrev(curr);
            curr = next;
        }
        this.last = curr;
        this.length = tab.length;
    }

    public ListCloneable() {
        super();
    }
    @Override
    public void push(T t) {
        if(this.last==null){
            this.init(t);
        }else{
            Element<T> newElement = new Element<>(copyT(t));
            newElement.next = this.first;
            this.first.prev = newElement;
            this.first = newElement;
            this.length++;
        }
    }

    private T copyT(T t){
        try {
            T clone = (T) t.getClass().getMethod("clone").invoke(t);
            return clone;
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public void append(T t){
        if(this.last==null){
            this.init(t);
        }else{
            Element<T> newElement = new Element<>(copyT(t));
            System.out.println(newElement.element);
            newElement.prev = this.last;
            this.last.next = newElement;
            this.last = newElement;
            this.length++;
        }
    }

    @Override
    public void insert(int index, T t) {
        super.insert(index, copyT(t));
    }


    @Override
    public T get(int index) {
        return copyT(super.get(index));
    }

    @Override
    public void set(int index, T t) {
        super.set(index,copyT(t));
    }

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
}
