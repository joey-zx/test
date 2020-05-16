package homework;

public class LinkedStack<T> {

    private Node<T> top = new Node<T>();

    private static class Node<U> {
        U item;
        Node nextNode;

        public Node() {
            this.item = null;
            this.nextNode = null;
        }

        public Node(U item, Node nextNode) {
            this.item = item;
            this.nextNode = nextNode;
        }

        public boolean end() {
            return this.item == null && this.nextNode == null ? true : false;

        }
    }

    public void push(T item) {
        top = new Node(item, top); //精妙
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.nextNode;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<String>();

        linkedStack.push("Zeng Xian");
        linkedStack.push("Love");
        linkedStack.push("I");

        while(!linkedStack.top.end()) {
            System.out.print(linkedStack.pop() + " ");
        }
    }
}
