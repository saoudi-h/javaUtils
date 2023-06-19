package com.saoudi.javaUtils;

import java.util.Objects;

public class List<U> {

    public U getFirst() {
        if(this.first==null) return null;
        return first.element;
    }

    public void setFirst(U first) {
        if(this.first!=null)
            this.first.setElement(first);
    }

    public U getLast() {
        if(this.first==null) return null;
        return last.getElement();
    }

    public void setLast(U last) {
        if(this.first!=null)
            this.last.setElement(last);
    }

    private class Element<U>{
        private Element<U> next;
        private Element<U> prev;
        private U element;


        public Element(Element<U> next, Element<U> prev, U element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }
        public Element(U element) {
            this.next = null;
            this.prev = null;
            this.element = element;
        }



        public U getElement() {
            return element;
        }

        public void setElement(U element) {
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

        public Element<U> getNext() {
            return next;
        }

        public void setNext(Element<U> next) {
            this.next = next;
        }

        public Element<U> getPrev() {
            return prev;
        }

        public void setPrev(Element<U> prev) {
            this.prev = prev;
        }
    }
    private Element<U> first;
    private Element<U> last;
    public int length;


    public void init(){
        this.first = null;
        this.last = null;
        this.length = 0;
    }
    public void init(U u){
        this.first = new Element<U>(u);
        this.last = first;
        this.length = 1;

    }
    public List(){
        this.init();
    }
    public List(U u){
        this.init(u);
    }
    public List(U[] tab){
        if(tab==null || tab.length==0){
            this.init();
            return;
        }
        System.out.println("length: "+ tab.length);
        this.first = new Element<U>(tab[0]);
        Element<U> curr = this.first;
        for(int i = 1;i<tab.length;i++){
            Element<U> next = new Element<U>(tab[i]);
            curr.setNext(next);
            next.setPrev(curr);
            curr = next;
        }
        this.last = curr;
        this.length = tab.length;
    }

    public void push(U u){
        if(this.last==null){
            this.init(u);
        }else{
            Element<U> newElement = new Element<U>(u);
            newElement.next = this.first;
            this.first.prev = newElement;
            this.first = newElement;
            this.length++;
        }
    }
    public void append(U u){
        if(this.last==null){
            this.init(u);
        }else{
            Element<U> newElement = new Element<U>(u);
            newElement.prev = this.last;
            this.last.next = newElement;
            this.last = newElement;
            this.length++;
        }
    }
    public void insert(int index, U u){
        if(index>=length)
            throw new IllegalArgumentException("Index hors limites.");
        if(this.last==null){
            this.init(u);
        }else{
            Element<U> tagetElement = this.get(index);
            Element<U> newElement = new Element<U>(u);
            newElement.next = tagetElement;
            tagetElement.prev = newElement;
            this.length++;
        }
    }

    public Element<U> get(int index){
        if(index>=length)
            return null;

        boolean isAsc = index<(Math.floor(this.length/2));
        Element<U> curr;
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
    public void set(int index, U u){
        if(index>=length)
            throw new IllegalArgumentException("Index hors limites.");
        Element<U> e = this.get(index);
        e.setElement(u);
    }
    public boolean isEmpty(){
        return this.last==null;
    }
    public void clear(){
        Element<U> curr = this.first;
        this.first = this.last = null;

        while(curr !=null){
            Element<U> next = curr.next;
            curr.next = null;
            curr.prev = null;
            curr.element = null;
            curr = next;
        }
        this.length=0;
    }
    public void remove(int index) {
        Element<U> target = this.get(index);
        if(target.next!=null)
            target.next.prev = target.prev;
        if(target.prev!=null)
            target.prev.next = target.next;
        target.element = null;
        target.next = null;
        target.prev = null;
        this.length--;
    }

    public U getFirst(Filtre<U> f){
        Element<U> curr = this.first;
        int i = 0;
        while(curr!=null) {
            if (f.apply(curr.element))
                return curr.element;
            curr = curr.next;
            i++;
        }
        return null;
    }
}