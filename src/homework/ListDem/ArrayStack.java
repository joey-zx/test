package homework.ListDem;

import java.util.Arrays;

public class ArrayStack<E> {

    private Object[] elementData;
    private int size;

    public ArrayStack() {
        elementData = new Object[10];
    }

    public ArrayStack(int capacity) {
        elementData = new Object[capacity];
    }

    public E pop() {

        if(size > 0) {
            return (E)elementData[--size];
        }

        return null;
    }

    public void push(E element) {
        if(size == elementData.length) {
            grow();
        }

        elementData[size ++] = element;

    }

    private void grow() {

        int newCapacity = elementData.length < 2 ? elementData.length + 1 : (elementData.length >> 1);

        if (newCapacity < elementData.length) {
            newCapacity = elementData.length;
        }

        elementData = Arrays.copyOf(elementData,elementData.length + newCapacity);

    }

}
