package homework.Tree;

public class BinaryTreeForBalance<E extends Comparable<E>> {

    private static final int LEFT = 0;

    private static final int RIGHT = 1;

    private Entry<E> root;

    private int size;

    public Entry<E> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public void add(E elemeent) {

        Entry<E> entry = root;

        if (entry == null) {
            root = new Entry<>(elemeent, null);
            size++;
            return;
        }

        Entry<E> parent = entry;

        int ret = 0;

        while (entry != null) {
            ret = elemeent.compareTo(entry.element);

            parent = entry;

            if (ret == 0) {
                entry.element = elemeent;

            } else if (ret > 0) {
                entry = entry.rigthEntry;
            } else {
                entry = entry.leftEntry;
            }

        }

        Entry<E> newEntry = new Entry<>(elemeent, parent);

        if (ret > 0) {
            parent.rigthEntry = newEntry;
        } else {
            parent.leftEntry = newEntry;
        }

        reBuild(parent); //插入新元素后自动平衡二叉树

        size++;
    }

    private void reBuild(Entry<E> p) {
        while (p != null) {
            if (calculateHeight(p) == 2) {
                fixTreeForInsertAction(p, LEFT);
            } else if (calculateHeight(p) == -2) {
                fixTreeForInsertAction(p, RIGHT);
            }
            p = p.parent;
        }
    }

    private void fixTreeForInsertAction(Entry<E> p, int flag) {
        if (flag == LEFT) {
            Entry<E> leftEntry = p.leftEntry;
            if (leftEntry.leftEntry != null) {
                rightPortation(p);
            } else {
                leftPortation(leftEntry);
                rightPortation(p);
            }
        } else {
            Entry<E> rightEntry = p.rigthEntry;
            if (rightEntry.rigthEntry != null) {
                leftPortation(p);
            } else {
                rightPortation(rightEntry);
                leftPortation(p);
            }
        }
    }

    private Entry<E> rightPortation(Entry<E> p) {
        if (p == null) {
            return null;
        }

        Entry<E> parent = p.parent;
        Entry<E> leftEntry = p.leftEntry;

        if (parent == null) {
            root = leftEntry;
            leftEntry.parent = null;
        } else {
            if (parent.leftEntry == p) {
                parent.leftEntry = leftEntry;
            } else {
                parent.rigthEntry = leftEntry;
            }
            leftEntry.parent = parent;
        }

        if (leftEntry.rigthEntry != null) {
            leftEntry.rigthEntry.parent = p;
            p.leftEntry = leftEntry.rigthEntry;
        } else {
            p.leftEntry = null;
        }

        leftEntry.rigthEntry = p;
        p.parent = leftEntry;

        return leftEntry;
    }


    private Entry<E> leftPortation(Entry<E> p) {

        if (p == null) {
            return null;
        }

        Entry<E> rightEntry = p.rigthEntry;
        Entry<E> parent = p.parent;

        if (parent != null) {
            if (parent.leftEntry == p) {
                parent.leftEntry = rightEntry;
            } else {
                parent.rigthEntry = rightEntry;
            }
            rightEntry.parent = parent;
        } else {
            root = rightEntry;
            rightEntry.parent = null;
        }

        if (rightEntry.leftEntry != null) {
            rightEntry.leftEntry.parent = p;
            p.rigthEntry = rightEntry.leftEntry;
        } else {
            p.rigthEntry = null;
        }

        rightEntry.leftEntry = p;
        p.parent = rightEntry;

        return rightEntry;
    }

    private int calculateHeight(Entry<E> p) {
        if (p == null) {
            return 0;
        }
        return (getChildHeight(p.leftEntry) - getChildHeight(p.rigthEntry));
    }

    private int getChildHeight(Entry<E> p) {
        if (p == null) {
            return 0;
        }
        return 1 + Math.max(getChildHeight(p.leftEntry), getChildHeight(p.rigthEntry));
    }


    public Entry<E> getEntry(Comparable<? super E> element) {

        Entry<E> entry = root;

        if (root == null) {
            return null;
        }

        if(element == null) {
            throw new NullPointerException();
        }

        int ret;
        while (entry != null) {
            ret = element.compareTo(entry.element);
            if (ret == 0) {
                return entry;
            } else if (ret > 0) {
                entry = entry.rigthEntry;
            } else {
                entry = entry.leftEntry;
            }
        }
        return null;
    }

    public boolean contains(Comparable<? super E> key) {
        return getEntry(key) != null;
    }

    public boolean remove(E element) {
        Entry<E> delEntry = getEntry(element);

        if(delEntry == null) {
            return false;
        }
        Entry<E> parent = delEntry.parent;

        Entry<E> rebuildEntry = null;

        if(delEntry.rigthEntry == null && delEntry.leftEntry == null) {
            if(parent == null) {
                root = null;
            } else{
                if(parent.leftEntry == delEntry) {
                    parent.leftEntry = null;
                } else {
                    parent.rigthEntry = null;
                }
                rebuildEntry = parent;
            }
            disable(delEntry);
            size --;
        } else if(delEntry.leftEntry == null && delEntry.rigthEntry != null) {
            Entry<E> rightEntry = delEntry.rigthEntry;
            if(parent == null) {
                root = rightEntry;
                rightEntry.parent = null;
            } else {
                if(parent.leftEntry == delEntry) {
                    parent.leftEntry = rightEntry;
                } else {
                    parent.rigthEntry = rightEntry;
                }
                rightEntry.parent = parent;
                rebuildEntry = parent;
            }

            disable(delEntry);
            size --;
        } else if(delEntry.leftEntry != null && delEntry.rigthEntry == null) {
            Entry<E> leftEntry = delEntry.leftEntry;
            if(parent == null) {
                root = leftEntry;
                leftEntry.parent = null;
            } else{
                if(parent.leftEntry == delEntry) {
                    parent.leftEntry = leftEntry;
                } else {
                    parent.rigthEntry = leftEntry;
                }
                leftEntry.parent = parent;
                rebuildEntry = parent;
            }
            disable(delEntry);
            size --;
        } else {
            Entry<E> successor = getSussessor(delEntry);
            E ele = successor.element;
            if(ele != null) {
                remove(ele);
                delEntry.element = ele;
            }
            disable(successor);
        }

        if(rebuildEntry != null) {
            reBuild(rebuildEntry);
        }
        return true;
    }

    private Entry<E> getSussessor(Entry<E> entry) {

        Entry<E> rightEntry = entry.rigthEntry;

        while(rightEntry.leftEntry != null) {
            rightEntry = rightEntry.leftEntry;
        }

        return rightEntry;
    }

    private void disable(Entry<E> delEntry) {
        delEntry.rigthEntry = null;
        delEntry.leftEntry = null;
        delEntry.parent = null;
        delEntry.element = null;
    }

    //中序遍历
    public void midIterator(Entry<E> eEntry) {

        if (eEntry != null) {
            midIterator(eEntry.leftEntry);
            System.out.println(eEntry.element);
            midIterator(eEntry.rigthEntry);
        }
    }


    private static class Entry<E extends Comparable<E>> {
        E element;
        Entry<E> leftEntry;
        Entry<E> rigthEntry;
        Entry<E> parent;

        public Entry(E element, Entry<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
