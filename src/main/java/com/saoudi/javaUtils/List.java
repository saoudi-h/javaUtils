package com.saoudi.javaUtils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class List<T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    protected class ListIterator implements Iterator<T> {
        protected Element<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

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

    public T getFirst() {
        if(this.first==null) return null;
        return first.element;
    }

    public void setFirst(T first) {
        if(this.first!=null)
            this.first.setElement(first);
    }

    public T getLast() {
        if(this.first==null) return null;
        return last.getElement();
    }

    public void setLast(T last) {
        if(this.first!=null)
            this.last.setElement(last);
    }

    protected static class Element<T>{
        protected Element<T> next;
        protected Element<T> prev;
        protected T element;


        public Element(Element<T> next, Element<T> prev, T element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }
        public Element(T element) {
            this.next = null;
            this.prev = null;
            this.element = element;
        }



        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return this.element.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element<?> element1 = (Element<?>) o;
            return Objects.equals(element, element1.element);
        }

        @Override
        public int hashCode() {
            return Objects.hash(element);
        }

        public Element<T> getNext() {
            return next;
        }

        public void setNext(Element<T> next) {
            this.next = next;
        }

        public Element<T> getPrev() {
            return prev;
        }

        public void setPrev(Element<T> prev) {
            this.prev = prev;
        }
    }
    protected Element<T> first;
    protected Element<T> last;
    public int length;


    protected void init(){
        this.first = null;
        this.last = null;
        this.length = 0;
    }
    protected void init(T t){
        this.first = new Element<>(t);
        this.last = first;
        this.length = 1;

    }
    public List(){
        this.init();
    }
    public List(T t){
        this.init(t);
    }
    public List(T[] tab){
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
    public void insert(int index, T t){
        if(index>length || index<0)
            throw new IllegalArgumentException("Index hors limites.");
        if(this.last==null || index==length){
            this.append(t);
        }else{
            Element<T> targetElement = this.getElement(index);
            Element<T> newElement = new Element<>(t);
            newElement.next = targetElement;
            newElement.prev = targetElement.prev;
            targetElement.prev = newElement;
            if(newElement.prev!=null)
                newElement.prev.next = newElement;
            this.length++;
            if(index==0) this.first = newElement;
        }
    }

    protected Element<T> getElement(int index){
        if(index>=length || index <0)
            return null;

        boolean isAsc = index < ( this.length / 2 );
        Element<T> curr;
        if(isAsc){
            curr = this.first;
            int i = 0;
            while(index!=i){
                curr = curr.next;
                i++;
            }
        }else{
            curr = this.last;
            int i = this.length-1;
            while(index!=i){
                curr = curr.prev;
                i--;
            }
        }
        return curr;
    }

    public T get(int index){
        Element<T> tmp = this.getElement(index);
        return tmp==null? null: tmp.element;

    }
    public void set(int index, T t){
        if(index>=length || index< 0)
            throw new IllegalArgumentException("Index hors limites.");
        Element<T> e = this.getElement(index);
        if(e!=null) e.setElement(t);
    }
    public boolean isEmpty(){
        return this.last==null;
    }
    public void clear(){
        Element<T> curr = this.first;
        this.first = this.last = null;

        while(curr !=null){
            Element<T> next = curr.next;
            curr.next = null;
            curr.prev = null;
            curr.element = null;
            curr = next;
        }
        this.length=0;
    }
    public void remove(int index) {
        if(index>=this.length || index <0)
            throw new IndexOutOfBoundsException("Index hors limites.");
        Element<T> target = this.getElement(index);
        if(target.next!=null)
            target.next.prev = target.prev;
        if(target.prev!=null)
            target.prev.next = target.next;
        target.element = null;
        target.next = null;
        target.prev = null;
        this.length--;
    }

    public T find(Filtre<T> f){
        Element<T> curr = this.first;
        while(curr!=null) {
            if (f.apply(curr.element))
                return curr.element;
            curr = curr.next;
        }
        return null;
    }

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
