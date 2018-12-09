package javaBase;

/**
 * @author: 蒋泽恩
 * @date: 2018/11/1 09:55
 * @description: 探究java值传递与引用传递
 */
public class Transmit {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("a");
        change(a);
        Integer b = 10;
        changeInt(b);
        String c = "hello";
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
    /**StringBuffer为可变化的字符串，拼接的时候不会产生新的对象,
     * 所以使用引用传递的时候改变的也改变了方法之外的StringBuffer**/
    public static void change(StringBuffer a){
        a .append(100);
    }
    /**Integer等基本类型的包装类以及原始类型传递的时候都是值传递,改变的只是方法内的参数**/
    public static void changeInt(Integer a){
        a = 100;
    }
    /**String可以理解为char[]类型的包装类,而且String类型在传入方法后
     * 进行赋值和拼接都是返回一个新的String,即new String,方法内外的String参数所以指向了不同的对象
     */
    public static void changeString(String a){
        a +="world";
    }
}
