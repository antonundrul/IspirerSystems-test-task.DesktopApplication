package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUsr<E> {

    private int size;
    private Object elements[];
    private static final int DEFAULT_CAPACITY = 1;

    public ListUsr(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e){
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++]=e;
    }

    public E get(int i){
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public E remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = elements[i];
        int elementsNumber = elements.length - ( i + 1 ) ;
        System.arraycopy( elements, i + 1, elements, i, elementsNumber ) ;
        size--;
        return (E) item;
    }

    public int getSize(){
        return size;
    }

    private void ensureCapacity() {
        int newSize = elements.length +1;
        elements = Arrays.copyOf(elements, newSize);
    }

    public List<E> castToList(){
        List<E> resultList = (List<E>) List.of(elements);
        return resultList;
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size ;i++) {
            sb.append(elements[i].toString());
            if(i<size-1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}