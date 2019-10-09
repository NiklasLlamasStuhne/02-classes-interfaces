package de.thro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {
    private class Element{
        private Object o;
        private Element next;
        Element (Object obj ){
            o = obj;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    private Element head;

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void add(Object o){

        if (head == null ){
            head = new Element (o);
        }
        else {
            Element it = head;
            while (it.next != null) {
                it = it.next;
            }
            it.next = new Element(o);
        }
    }

    @Override
    public int size(){
        Element it = head;
        int count =0;
        while (it.next !=null){
           count++;
           it = it.next;
        }
        return count;
    }


    public SimpleList filter (SimpleFilter filter){
        SimpleList list = new SimpleListImpl();
        Element it = head;
        while(it.next !=null){

            if ( filter.include(it.o)){
                list.add(it.o);
            }
        it = it.next;
        }

        return list;

    }
}
