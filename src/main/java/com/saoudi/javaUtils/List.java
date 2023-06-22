package com.saoudi.javaUtils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class List<T> extends ListAbstract<T> {


    public List(){
        this.init();
    }
    public List(T t){
        this.init(t);
    }
    public List(T[] tab){
        this.init(tab);
    }

    @Override
    protected void init(T t) {
        this.first = new Element<>(t);
        this.last = first;
        this.length = 1;
    }

    @Override
    protected void init(T[] tab) {
        if(tab==null || tab.length==0){
            this.init();
            return;
        }
        this.first = new Element<>(tab[0]);
        Element<T> curr = this.first;
        for(int i = 1;i<tab.length;i++){
            Element<T> next = new Element<>(tab[i]);
            curr.setNext(next);
            next.setPrev(curr);
            curr = next;
        }
        this.last = curr;
        this.length = tab.length;
    }

    @Override
    public void push(T t){
        if(this.last==null){
            this.init(t);
        }else{
            Element<T> newElement = new Element<>(t);
            newElement.next = this.first;
            this.first.prev = newElement;
            this.first = newElement;
            this.length++;
        }
    }
    @Override
    public void append(T t){
        if(this.last==null){
            this.init(t);
        }else{
            Element<T> newElement = new Element<>(t);
            newElement.prev = this.last;
            this.last.next = newElement;
            this.last = newElement;
            this.length++;
        }
    }

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

}
