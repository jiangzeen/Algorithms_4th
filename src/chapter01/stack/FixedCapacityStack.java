package chapter01.stack;

/**《算法(第四版)》--1.3.2
 * @author: 蒋泽恩
 * @date: 2018/10/18 17:22
 * @description: 自定义的栈结构
 */
public class FixedCapacityStack<T> {
    private T[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        //不允许直接创建泛型数组
        a = (T[])new Object[cap];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(T item){
        if(N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }
    public T pop(){
        T item = a[--N];
        if(N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    /**
     * 扩充栈的数组大小,是数组永远不会溢出
     * @param max:
     */
    public void resize(int max){
        T[] item = (T[]) new Object[max];
        for (int i = 0; i < a.length ; i++) {
            item[i] = a[i];
        }
        a = item;
    }
}
