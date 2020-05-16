package homework.Tree;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class BinaryTree<T extends Comparable<T>> {

    private Entry<T> root;

    private int size;

    private static class Entry<T extends Comparable<T>> {
        T item;
        Entry<T> left;
        Entry<T> right;
        Entry<T> parent;

        public Entry(T item, Entry<T> parent) {
            this.item = item;
            this.parent = parent;
        }
    }

    public Entry<T> getRoot() {
        return this.root;
    }

    public int getSize() {
        return this.size;
    }

    public boolean add(T item) {

        Entry<T> entry = root;
        if (entry == null) {
            root = new Entry<T>(item, null);
            size++;
            return true;
        }

        Entry<T> parent = entry;
        int ret = 0;

        while (entry != null) {

            ret = item.compareTo(entry.item);

            parent = entry;

            if (ret == 0) {
                entry.item = item;
                return false;
            } else if (ret > 0) {
                entry = entry.right;
            } else {
                entry = entry.left;
            }

        }

        Entry<T> newEntry = new Entry<T>(item, parent);

        if (ret > 0) {
            parent.right = newEntry;
        } else {
            parent.left = newEntry;
        }

        size++;
        return true;
    }

    public Entry<T> getEntry(T item) {
        Entry<T> entry = root;
        int ret;

        while (entry != null) {
            ret = item.compareTo(entry.item);
            if (ret == 0) {
                return entry;
            } else if (ret > 0) {
                entry = entry.right;
            } else {
                entry = entry.left;
            }
        }
        return null;
    }

    public boolean remove(T item) {

        Entry<T> delEntry = getEntry(item);

        if (delEntry == null) {
            return false;
        }

        size--;

        Entry<T> parent = delEntry.parent;

        if (delEntry.left == null && delEntry.right == null) {
            if (parent == null) {
                root = null;
            } else {
                if (parent.left == delEntry) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (delEntry.left == null) {
            Entry<T> rightEntry = delEntry.right;
            if (parent == null) {
                root = rightEntry;
                rightEntry.parent = null;
            } else {
                if (parent.left == delEntry) {
                    parent.left = rightEntry;
                } else {
                    parent.right = rightEntry;
                }
                rightEntry.parent = parent;
            }

        } else if (delEntry.right == null) {
            Entry<T> leftEntry = delEntry.left;
            if (parent == null) {
                root = leftEntry;
                leftEntry.parent = null;
            } else {
                if (parent.left == delEntry) {
                    parent.left = leftEntry;
                } else {
                    parent.right = leftEntry;
                }
                leftEntry.parent = parent;
            }
        } else {
            Entry<T> successor = getSucessor(delEntry);
            T temp = successor.item;
            boolean flag = remove(successor.item);
            if(flag) {
                delEntry.item = temp;
            }
            delEntry.item = successor.item;
            return true;
        }

        delEntry.parent = null;
        delEntry.left = null;
        delEntry.right = null;

        return true;
    }

    private Entry<T> getSucessor(Entry<T> entry) {
        Entry<T> rightEntry = entry.right;

        while (rightEntry.left != null) {
            rightEntry = rightEntry.left;
        }
        return rightEntry;
    }

    private Entry<T> getForward(Entry<T> entry) {
        Entry<T> leftEntry = entry.left;

        while (leftEntry.right != null) {
            leftEntry = leftEntry.right;
        }

        return leftEntry;
    }

    //前序遍历
    public void forwardIterator(Entry<T> root) {
        Entry<T> entry = root;
        if(entry != null) {
            System.out.println(entry.item);
            forwardIterator(entry.left);
            forwardIterator(entry.right);
        }
    }

    //中序遍历
    public void midIterator(Entry<T> root) {
        Entry<T> entry = root;
        if(entry != null) {
            midIterator(entry.left);
            System.out.println(entry.item);
            midIterator(entry.right);
        }
    }

    //后续遍历
    public void backIterator(Entry<T> root) {
        Entry<T> entry = root;
        if(entry != null) {
            backIterator(entry.left);
            backIterator(entry.right);
            System.out.println(entry.item);
        }
    }

}
