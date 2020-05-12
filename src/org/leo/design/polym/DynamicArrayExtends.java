package org.leo.design.polym;

/**
 * @description: 继承实现多态
 * @author: leo.mao
 * @createDate: 2020/5/11
 */
public class DynamicArrayExtends {


    private static final int DEFAULT_CAPACITY = 10;
    protected  int size = 0;
    protected  int capacity  = DEFAULT_CAPACITY;
    protected  Integer[] ele = new Integer[DEFAULT_CAPACITY];

    public int size() {
        return  this.size;
    }
    public Integer get(int index ){
        return ele[index];
    }

    public void add(Integer e){
        ensureCapacity();
        ele[size++] = e ;
    }

    protected void ensureCapacity() {
        //扩容
    }
}

 class SortedDynamicArray extends DynamicArrayExtends {
    @Override
    public void add(Integer e) {
        ensureCapacity();
        int i ;
        for (i = size - 1  ; i >= 0 ; --i) {
            if (ele[i] > e){
                ele[i + 1] = ele[i];
            } else {
                break;
            }
        }
        ele[i + 1] = e;
        ++size;
    }
}

 class Example{
    public static void test(DynamicArrayExtends dynamicArray){
        dynamicArray.add(5);
        dynamicArray.add(1);
        dynamicArray.add(3);
        for (int i = 0; i <  dynamicArray.size; ++i) {
            System.out.println(dynamicArray.get(i));
        }
    }

    public static void main(String[] args) {
        //多态的三个机制
        //1.父类对象应用子类对象
        //2.支持继承
        //3.支持子类对象重写父类方法
        DynamicArrayExtends dynamicArray = new SortedDynamicArray();
        test(dynamicArray);
    }
}