package homework.ListDem;

import java.nio.file.NotDirectoryException;

public class LinkedStack {

    public Node top = new Node();

    public void push(String item) {
        top = new Node(item,top);
    }

    public Node getTop() {
        return new Node();
    }


    public String pop() {
        String item = null;

        if(!top.end()) {
            item = top.item;
            top = top.next;
        }
        return item;
    }

    private class Node implements MyList {
        String item;
        Node next;

        public Node() {
        }

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }

        public boolean end() {
            return item == null && next == null;
        }
    }

}
