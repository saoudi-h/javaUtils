package com.saoudi.javaUtils;

public class ListCloneable<T extends Cloneable> extends List<T>{

    private T copyT(T t){
        try {
            return (T) t.getClass().getMethod("clone").invoke(t);
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
            newElement.prev = this.last;
            this.last.next = newElement;
            this.last = newElement;
            this.length++;
        }
    }

    @Override
    public List<T> findAll(Filtre<T> f) {
        List<T> newList = new ListCloneable<>();
        Element<T> curr = this.first;
        while (curr != null) {
            if (f.apply(curr.element))
                newList.append(copyT(curr.element));
            curr = curr.next;
        }
        return newList;
    }
}
