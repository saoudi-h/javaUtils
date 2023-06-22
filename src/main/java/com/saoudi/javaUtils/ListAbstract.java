package com.saoudi.javaUtils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class ListAbstract<T> implements Iterable<T> {
    public int length;
    protected Element<T> first;
    protected Element<T> last;

    public ListAbstract(){
        this.init();
    }
    public ListAbstract(T t){
        this.init(t);
    }
    public ListAbstract(T[] tab){
        this.init(tab);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    public T getFirst() {
        if (this.first == null) return null;
        return first.element;
    }

    public void setFirst(T first) {
        if (this.first != null)
            this.first.setElement(first);
    }

    public T getLast() {
        if (this.first == null) return null;
        return last.getElement();
    }

    public void setLast(T last) {
        if (this.first != null)
            this.last.setElement(last);
    }

    protected void init() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    protected abstract void init(T t);
    protected abstract void init(T[] tab);

    public abstract void push(T t);

    public abstract void append(T t);


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

    public boolean isEmpty() {
        return this.last == null;
    }

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

    public T find(Filtre<T> f) {
        Element<T> curr = this.first;
        while (curr != null) {
            if (f.apply(curr.element))
                return curr.element;
            curr = curr.next;
        }
        return null;
    }

    public abstract ListAbstract<T> findAll(Filtre<T> f);

    protected static class Element<T> {
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
}
