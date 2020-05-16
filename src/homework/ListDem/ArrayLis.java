package homework.ListDem;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayLis {

    private String[] data;

    private int size;

    private int initCapacity = -1;

    //默认构造方法，让list默认容量为10
    public ArrayLis() {
        data = new String[10];
    }

    //让用户指定初始化容量
    public ArrayLis(int initCapacity) {

        if (initCapacity < 0) {
            throw new IllegalArgumentException("初始容量不能小于0");
        }

        this.initCapacity = initCapacity;

        data = new String[initCapacity];
    }

    public void add(String str) {

        if (size == data.length) {
            grow();
        }

        data[size++] = str;
    }

    private void grow() {
        int newCapacity = data.length < 2 ? data.length + 1 : (data.length >> 1);

        if (newCapacity < data.length) {
            newCapacity = data.length;
        }

        data = Arrays.copyOf(data, data.length + newCapacity);
    }

    public void outOfBounds(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds " + size);
        }
    }

    public void add(int index, String str) {
        if (size == data.length) {
            grow();
        }
        outOfBounds(index);

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = str;

        size++;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        size = 0;

        int capacity = initCapacity == -1 ? 10 : initCapacity;

        data = new String[capacity];
    }

    public boolean contains(String str) {
        return indexOf(str) != -1;
    }

    public String get(int index) {

        outOfBounds(index);

        return data[index];
    }

    public int indexOf(String str) {

        for (int i = 0; i < size; i++) {
            if (str == data[i] || str != null && str.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int lastIndexOf(String str) {
        for (int i = size - 1; i >= 0; i--) {
            if (str == data[i] || str != null && str.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public String remove(int index) {
        outOfBounds(index);

        String str = data[index];

        System.arraycopy(data, index + 1, data, index,size - index - 1 );

       data[--size] = null;

        return str;
    }

    public boolean remove(String str) {
        int index = indexOf(str);
        if(index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    public void set(int index,String str) {
        outOfBounds(index);

        data[index] = str;
    }

    public int size() {
        return this.size;
    }

    public void quickSort(Comparator<String> c, int low, int high) {

        int beginIndex,endIndex;
        String exchange;

        if(low > high) {
            return;
        }

        beginIndex = low;
        endIndex = high;

        String temp = data[low];

        while(beginIndex < endIndex) {

            while(c.compare(temp,data[endIndex]) <= 0 && beginIndex < endIndex) {
                endIndex --;
            }

            while(c.compare(temp,data[beginIndex]) >= 0 && beginIndex < endIndex) {
                beginIndex ++;
            }

            //Find to exchange
            if(beginIndex < endIndex) {
                exchange = data[beginIndex];
                data[beginIndex] = data[endIndex];
                data[endIndex] = exchange;
            }

        }

        data[low] = data[beginIndex];
        data[beginIndex] = temp;

        //递归继续分别排序(左)

        quickSort(c,0,beginIndex - 1);

        // 递归继续分别排序(右)
        quickSort(c,beginIndex + 1,high);

    }

    public void selectSort(Comparator<String> c) {

        int temp;
        String exchange;

        for (int i = 0; i < size; i++) {
            temp = i;
            for (int j = temp + 1; j < size; j++) {
                if(c.compare(data[temp],data[j]) > 0) {
                    temp = j;
                }
            }
            if(temp != i) {
                exchange = data[temp];
                data[temp] = data[i];
                data[i] = exchange;
            }
        }
    }

    public void bubleSort(Comparator<String> c) {
        String exchange;

        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= i + 1; j--) {
                if(c.compare(data[j],data[j-1]) < 0) {
                    exchange = data[j];
                    data[j] = data[j-1];
                    data[j-1] = exchange;
                }
            }
        }
    }

    public void insertSort(Comparator<String> c) {
        String exhange;

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if(c.compare(data[j],data[j-1]) < 0) {
                    exhange = data[j];
                    data[j] = data[j-1];
                    data[j-1] = exhange;
                } else{
                    break;
                }
            }
        }
    }

    public ArrayLis subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IllegalArgumentException();
        }

        int size = toIndex - fromIndex;

        ArrayLis arrayLis = new ArrayLis(size);

        System.arraycopy(data,fromIndex,arrayLis.data,0,size);

        arrayLis.size = size;

        return arrayLis;
    }

    public String[] toArray() {
        return Arrays.copyOf(data,size);
    }

    public void trimToSize() {
       this.data = Arrays.copyOf(data,size);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(", ");
        }

        String result = sb.toString();

        if(size > 0) {
            result = result.substring(0,result.length() - 2);
        }

        return result + "]";
    }
}
