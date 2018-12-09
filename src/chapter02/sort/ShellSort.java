package chapter02.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: 蒋泽恩
 * @date: 2018/12/2 20:14
 * @description: 希尔排序和插入排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] numbers = {8,1,9,7,0,4,5,2,3,6};
        int[] arrays = new int[100];
        numbers = shell_sort(numbers);
        System.out.println(Arrays.toString(arrays));
        int[] number2 = insert_sort(numbers);
        System.out.println(Arrays.toString(number2));
    }
    public static int[] shell_sort(int[] numbers){
        //确定希尔常量
        long startTime = System.currentTimeMillis();
        int length = numbers.length / 2;
        while (length >= 1){
            for (int i = length; i < numbers.length; i++) {
                for (int j = i; j >= length; j -= length){
                    if(numbers[j] < numbers[j - length]) {
                        swap(numbers, j, j - length);
                    }
                }
            }
            length /= 2;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序所用时间:" + (endTime - startTime) + "毫秒");
        return numbers;
    }
    public static int[] insert_sort(int[] numbers){
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if(numbers[j - 1] > numbers[j]){
                    swap(numbers, j, j-1);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序所用时间:" + (endTime - startTime) + "毫秒");
        return numbers;
    }
    public static void swap(int[] numbers,int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
