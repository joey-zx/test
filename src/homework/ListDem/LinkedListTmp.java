package homework.ListDem;

public class LinkedListTmp<E> implements List<E> {

    private Node<E> first;

    private Node<E> last;

    private int size;

    public void add(E element) {
        Node<E> newNode = new Node<>(element, null, null);

        if (size == 0) {
            this.first = this.last = newNode;
        } else {
            this.last.next = newNode;
            newNode.prev = this.last;
            this.last = newNode;
        }
        size++;

    }

    public void outOfBounds(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }

    public void add(int index, E element) {
        outOfBounds(index);
        Node<E> newNode = new Node<>(element, null, null);
        if (index == size) {
            add(element);
        } else if (index == 0) {
            this.first.prev = newNode;
            newNode.next = this.first;
            this.first = newNode;
        } else {
            Node<E> targetNode = getNode(index);
            newNode.next = targetNode;
            newNode.prev = targetNode.prev;
            targetNode.prev.next = newNode;
            targetNode.prev = newNode;
        }
        size++;
    }

    private Node<E> getNode(int index) {

        outOfBounds(index);

        Node<E> node;

        if (index < size / 2) {
            int i = index;
            node = first;
            while (i >= 0) {
                node = node.next;
                i--;
            }
        } else {
            node = last;
            int i = size - index - 1;
            while (i >= 0) {
                node = node.prev;
                i--;
            }
        }
        return node;
    }

    public void clear() {
        Node<E> node = this.first;

        if(size > 0) {
            while(true) {
                node.element = null;
                node = node.next;
                if(node == null) {
                    break;
                }
                node.prev = null;
                node.prev.next = null;
            }
        }
    }

    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    public E get(int index) {
        outOfBounds(index);
        return getNode(index).element;
    }

    public int indexOf(Object o) {
        Node<E> node = first;
        int index = 0;
        while(first != null) {
            if(first.element == o || o != null && o.equals(first.element)) {
                return index;
            }
            first = first.next;
            index ++;
        }

        return -1;
    }

    public boolean remove(int index) {
        outOfBounds(index);

        Node<E> delNode = getNode(index);

        if(index == size - 1) {
            this.last.element = null;
            this.last.prev.next = null;
            this.last = this.last.prev;

        } else if(index == 0) {
            this.first.element = null;
            this.first.next.prev = null;
            this.first = this.first.next;
        } else {
            delNode.prev.next = delNode.next;
            delNode.next.prev = delNode.prev;
            delNode.element = null;
        }
        size --;
        return true;
    }

    public boolean remove(Object o) {
        return remove(indexOf(o));
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator<E> implements Iterator<E> {

        private Node<E> node = (Node<E>) first;

        @Override
        public E next() {
            E element = node.element;
            node = node.next;
            return element;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
