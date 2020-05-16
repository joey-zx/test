package homework.ListDem;

import org.w3c.dom.ls.LSException;

import java.util.Iterator;
import java.util.Stack;

public class MinStack {

    private Stack<String> dataStack = new Stack<String>();

    private Stack<String> minStack = new Stack<String>();

    public MinStack() {
    }

    public Stack<String> getMinStack() {
        return this.minStack;
    }


    public boolean empty() {
        return dataStack.empty();
    }

    public String peek() {
        return dataStack.peek();
    }

    public String pop() {
        String item = dataStack.pop();
        if(item.equals(minStack.peek())) {
            minStack.pop();
            minStack.push(findMinInDataStack());
        }
        return item;
    }

    public String findMinInDataStack() {

        Iterator iterator = dataStack.iterator();

        String min = (String)iterator.next();

        while(iterator.hasNext()) {
            String compare = (String) iterator.next();
            if(compare.compareTo(min) < 0) {
                min = compare;
            }
        }

        return min;
    }

    public void push(String t) {
        if(t != null) {
            dataStack.push(t);
        }else {
            return;
        }

        if(minStack.empty()) {
            minStack.push(t);
        } else {
            String min = minStack.pop();
            if(min.compareTo(t) < 0) {
                minStack.push(min);
            } else{
                minStack.push(t);
            }

        }

    }

    public int search(String s) {
        return dataStack.search(s);
    }

    @Override
    public String toString() {
        return dataStack.toString();
    }
}
