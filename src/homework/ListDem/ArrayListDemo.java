package homework.ListDem;

import java.util.Arrays;

public class ArrayListDemo<T> implements List<T> {
    private Object[] elementData;
    private int size;
    private int capacity = -1;

    public ArrayListDemo() {
        elementData = new Object[10];
    }

    public ArrayListDemo(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("The initial capacity can't be less than zero");
        }
        this.capacity = capacity;
        elementData = new Object[capacity];
    }

    public void add(T item) {

        if (size >= elementData.length) {
            ensureCapacity();
        }

        elementData[size++] = item;
    }

    private void ensureCapacity() {

        int capacity = this.capacity;

        if (capacity < 2) {
            capacity++;
        }

        if (capacity < elementData.length) {
            capacity = elementData.length;
        }

        elementData = Arrays.copyOf(elementData, elementData.length + capacity >> 1);

    }

    private void outOfBound(int index) {
        if (index < 0 && index > elementData.length) {
           throw new IllegalArgumentException("Out of Bounds" + index);
        }
    }

    public void add(int index, T item) {
        outOfBound(index);

        if (size >= elementData.length) {
            ensureCapacity();
        }

        System.arraycopy(elementData,index,elementData,index + 1,size - index);
        elementData[index] = item;
        size ++;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }

        if(capacity != -1) {
            elementData = new Object[capacity];
        } else {
            elementData = new Object[10];
        }

        size = 0;

    }

    public T get(int index) {

        outOfBound(index);

        return (T)elementData[index];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if(elementData[i] == o || (o != null && o.equals(elementData[i]))) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {

        outOfBound(index);

        T t = (T) elementData[index];

        System.arraycopy(elementData,index + 1,elementData,index,size - index - 1);

        elementData[--size] = null;

        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<>();
    }

    private class ArrayListIterator<T> implements Iterator<T>{

        private int currentIndex;

        @Override
        public T next() {
            return (T) elementData[currentIndex++];
        }

        @Override
        public boolean hasNext() {

            if(currentIndex >= size) {
                return false;
            }

            return true;
        }
    }

}
