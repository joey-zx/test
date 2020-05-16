package homework.ListDem;

public class LinkList {

    private int size;

    private Node first;

    private Node last;

    public void add(String str) {

        Node node = new Node(null, str, null);

        if (size == 0) {
            this.first = this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
        size++;
    }

    public void outOfBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(int index, String str) {
        outOfBounds(index);

        if (index == size) {
            add(str);
            return;
        }

        Node node = new Node(null, str, null);

        if (index == 0) {
            node.next = this.first;
            this.first.prev = node;
            this.first = node;
        } else {
            Node no = getNode(index);
            node.prev = no.prev;
            node.next = no;
            no.prev.next = node;
            no.prev = node;
        }
        size++;
    }

    private Node getNode(int index) {

        outOfBounds(index);
        Node node = null;
        int i;
        if (size > 0) {
            if (index <= size / 2) {
                node = this.first;
                i = 0;
                while (i != index) {
                    node = node.next;
                    i++;
                }
            } else {
                node = this.last;
                i = size - 1;
                while (i != index) {
                    node = node.prev;
                    i--;
                }
            }

        }
        return node;
    }

    public void clear() {

        Node node = this.first;

        if (size > 0) {
            while (true) {
                node.item = null;
                node = node.next;
                if (node == null) {
                    break;
                }
                node.prev.next = null;
                node.prev = null;
            }
        }
        size = 0;
    }

    public boolean contains(String str) {
        return this.indexOf(str) != -1;
    }

    public String get(int index) {
        return getNode(index).item;
    }

    public int indexOf(String str) {
        Node node = this.first;
        int index = 0;
        while (true) {
            if (str == node.item || str != null && str.equals(node.item)) {
                return index;
            }
            node = node.next;
            if (node == null) {
                break;
            }
            index++;
        }

        return -1;
    }

    public int lastIndexOf(String str) {
        Node node = this.last;
        int index = size - 1;
        while (true) {
            if (str == node.item || str != null && str.equals(node.item)) {
                return index;
            }
            node = node.prev;
            if (node == null) {
                break;
            }

            index--;
        }
        return -1;
    }


    public String remove(int index) {

        Node node = getNode(index);

        if (size == 1) {
            this.first = this.last = null;
            this.first.item = null;
        } else if (index == size - 1) {
            this.last.item = null;
            this.last.prev.next = null;
            this.last = this.last.prev;
        } else if (index == 0) {
            this.first.item = null;
            this.first.next.prev = null;
            this.first = this.first.next;
        } else {
            node.item = null;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;

        return node.item;
    }


    public String remove(String str) {
        int index = indexOf(str);
        return remove(index);
    }

    public void set(int index, String str) {
        outOfBounds(index);
        if (size == 0) {
            Node node = new Node(null, str, null);
            this.first = this.last = node;
            size++;
            return;
        }
        Node node = getNode(index);
        node.item = str;
    }


    public int size() {
        return this.size;
    }

    public String[] toArray() {
        String[] strings = new String[size];
        Node node = this.first;
        for (int i = 0; i < size; i++) {
            strings[i] = node.item;
            node = node.next;
        }

        return strings;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        Node node = this.first;

        for (int i = 0; i < size; i++) {
            stringBuilder.append(node.item).append(", ");
            node = node.next;
        }

        String result = stringBuilder.toString();

        if (size > 0) {
            result = result.substring(0, result.length() - 2);
        }

        return result + "]";
    }

    private class Node {
        Node prev;
        String item;
        Node next;

        public Node(Node prev, String item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

}
