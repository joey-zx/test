package homework.ListDem;

public class LinkedStackTmp<E> {

    private Entry<E> top = new Entry<>();

    public Entry<E> getTop() {
        return top;
    }

    public void push(E element) {
        top = new Entry<>(element,top);
    }


    public E pop() {
        E element = null;

        if(!top.end()) {
            element = top.item;
            top = top.next;
        }
        return element;
    }

    private static class Entry<E> implements MyList {

        E item;
        Entry<E> next;

        public Entry() {

        }

        public Entry(E item, Entry<E> next) {
            this.item = item;
            this.next = next;
        }

        public boolean end() {
            return item == null && next == null;
        }

        public Entry<E> getNext() {
            return this.next;
        }

    }
}
