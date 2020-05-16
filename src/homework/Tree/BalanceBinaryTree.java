package homework.Tree;

public class BalanceBinaryTree<T extends Comparable<T>> {

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private Entry<T> root;

    private int size;

    private static class Entry<T extends Comparable> {
        Entry<T> left;
        Entry<T> right;
        Entry<T> parent;
        T item;

        public Entry(Entry<T> parent, T item) {
            this.parent = parent;
            this.item = item;
        }
    }

    public Entry<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public boolean add(T item) {
        Entry<T> entry = root;

        if (entry == null) {
            root = new Entry<T>(null, item);
            size++;
            return true;

        }

        int ret = 0;

        Entry<T> parent = entry;

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

        Entry<T> newEntry = new Entry<>(parent, item);

        if (ret > 0) {
            parent.right = newEntry;
        } else {
            parent.left = newEntry;

        }
        rebuild(parent);
        size++;
        return true;
    }

    private void rebuild(Entry<T> parent) {
        while (parent != null) {
            if (calculateHeight(parent) == 2) { //用左子树高度减去右子树高度. 为正，表示左子树高，为负表示右子树高
                fixAfterInsertion(parent, LEFT);
            } else if (calculateHeight(parent) == -2) {
                fixAfterInsertion(parent, RIGHT);
            }
            parent = parent.parent;
        }
    }

    private void fixAfterInsertion(Entry<T> parent, int flag) {
        if (flag == LEFT) {
            Entry<T> leftEntry = parent.left;
            if (leftEntry.left != null) {
                rightPortation(parent);
            } else if (leftEntry.right != null) {
                leftPortation(leftEntry);
                rightPortation(parent);
            }
        } else {
            Entry<T> rightEntry = parent.right;
            if (rightEntry.right != null) {
                leftPortation(parent);
            } else if (rightEntry.left != null) {
                rightPortation(rightEntry);
                leftPortation(parent);
            }
        }
    }

    private Entry<T> leftPortation(Entry<T> entry) {
        if (entry == null) {
            return null;
        }

        Entry<T> rigthEntry = entry.right;
        rigthEntry.parent = entry.parent;

        if (entry.parent != null) {
            if (entry.parent.left == entry) {
                entry.parent.left = rigthEntry;
            } else {
                entry.parent.right = rigthEntry;
            }
        } else {
            this.root = rigthEntry;
        }

        if (rigthEntry.left != null) {
            rigthEntry.left.parent = entry;
            entry.right = rigthEntry.left;
        } else {
            entry.right = null;
        }

        rigthEntry.left = entry;
        entry.parent = rigthEntry;
        return rigthEntry;
    }

    private Entry<T> rightPortation(Entry<T> entry) {

        if (entry == null) {
            return null;
        }
        Entry<T> leftEntry = entry.left;
        leftEntry.parent = entry.parent;

        if (entry.parent != null) {
            if (entry.parent.left == entry) {
                entry.parent.left = leftEntry;
            } else {
                entry.parent.right = leftEntry;
            }
        } else {
            this.root = leftEntry;
        }

        if (leftEntry.right != null) {
            leftEntry.right.parent = entry;
            entry.left = leftEntry.right;
        } else {
            entry.left = null;
        }
        leftEntry.right = entry;
        entry.parent = leftEntry;
        return leftEntry;
    }

    private int calculateHeight(Entry<T> parent) {

        if (parent != null) {
            return getChildHeight(parent.left) - getChildHeight(parent.right);
        }
        return 0;
    }

    private int getChildHeight(Entry<T> p) {
        if (p == null) {
            return 0; //递归结束标志
        }
        return 1 + Math.max(getChildHeight(p.left), getChildHeight(p.right));
    }

    //中序遍历
    public void midIterator(Entry<T> root) {
        if (root != null) {
            midIterator(root.left);
            System.out.println(root.item);
            midIterator(root.right);
        }
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

    public boolean contains(T item) {
        return getEntry(item) != null;
    }


    public boolean remove(T item) {
        Entry<T> delEntry = getEntry(item);
        boolean isBulid = false;
        Entry<T> build = null;

        if (delEntry == null) {
            return false;
        }

        Entry<T> parent = delEntry.parent;

        if (delEntry.left == null && delEntry.right == null) {
            if (parent == null) {
                root = null;
            } else {
                if (delEntry.parent.left == delEntry) {
                    delEntry.parent.left = null;
                } else {
                    delEntry.parent.right = null;
                }
                delEntry.parent = null;
                delEntry.item = null;
                build = parent;
                isBulid = true;
            }
            size --;
        } else if (delEntry.left == null) {
            Entry<T> rightEntry = delEntry.right;
            if (parent == null) {
                root = rightEntry;
                rightEntry.parent = null;
            } else {
                if(delEntry.parent.left == delEntry) {
                    delEntry.parent.left = rightEntry;
                } else {
                    delEntry.parent.right = rightEntry;
                }
                rightEntry.parent = parent;
                isBulid = true;
                build = parent;
            }
            delEntry.right = null;
            delEntry.item = null;
            delEntry.parent = null;
            size --;
        } else if(delEntry.right == null) {
            Entry<T> leftEntry = delEntry.left;
            if(parent == null) {
                root = leftEntry;
                leftEntry.parent = null;
            } else {
                if(delEntry.parent.left == delEntry) {
                    delEntry.parent.left = leftEntry;
                } else {
                    delEntry.parent.right = leftEntry;
                }
                leftEntry.parent = parent;
                isBulid = true;
                build = parent;
            }
            delEntry.left = null;
            delEntry.parent = null;
            delEntry.item = null;
            size --;
        } else {
            Entry<T> successor = getSuccsssor(delEntry);
            T data = successor.item;
            boolean flag = remove(successor.item);
            if(flag) {
                delEntry.item = data;
            }

            successor.parent = null;
            successor.right = null;
            successor.left = null;
            successor.item = null;
        }

        if(isBulid) {
            rebuild(build);
        }
        return true;
    }
    private Entry<T> getSuccsssor(Entry<T> delEntry) {
        Entry<T> rigthEntry = delEntry.right;

        while(rigthEntry.left != null) {
            rigthEntry = rigthEntry.left;
        }
        return rigthEntry;
    }
}
