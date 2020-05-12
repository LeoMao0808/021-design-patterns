package org.leo.design.polym;

/**
 * @description: 接口类实现多态
 * @author: leo.mao
 * @createDate: 2020/5/11
 */
public interface Iterator {
    String hasNext();
    String next();
    String remove();
}
class Array implements  Iterator {

    @Override
    public String hasNext() {
        return "array hasNext";
    }

    @Override
    public String next() {
        return "array next";
    }

    @Override
    public String remove() {
        return "array remove";
    }
}

class LinkedList implements Iterator {
    @Override
    public String hasNext() {
        return "LinkedList hasNext";
    }

    @Override
    public String next() {
        return "LinkedList next";
    }

    @Override
    public String remove() {
        return "LinkedList remove";
    }
}

class Demo {
    private static void print(Iterator iterator){
        System.out.println(iterator.hasNext());
    }

    public static void main(String[] args) {
        Iterator iterator = new Array();
        print(iterator);
        Iterator iteratorLinkedList = new LinkedList();
        print(iteratorLinkedList);
    }
}
