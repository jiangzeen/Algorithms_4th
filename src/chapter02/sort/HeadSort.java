package chapter02.sort;

import java.util.Arrays;

import static chapter02.sort.ShellSort.swap;

/**
 * @author: 蒋泽恩
 * @date: 2018/12/9 15:32
 * @description: 堆排序
 */
public class HeadSort {
    public static void main(String[] args) {
        int[] arr = {10,2,8,1,9,15,30,12,16,20};
        head_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * @param a
     */
    public static void head_sort(int[] a){
        /**
         * 1.构建最大堆
         * 2.交换数据后调整最大堆
         */
        for(int i = a.length /2 - 1; i >= 0; i--){
            //从第一个非叶子节点开始构建最大堆--从右至左
            adjust_head(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
           swap(a, i, 0);
           adjust_head(a, 0, i);
        }
    }

    /**
     * 调整堆
     * @param a
     * @param k
     * @param length
     */
    public static void adjust_head(int[] a, int k, int length) {
        int temp = a[k];
        for (int i = 2*k + 1; i < length; i = 2*i+1) {
             if(i+1 < length && a[i] < a[i+1]){
                 i++;
             }
             if(temp < a[i]){
                a[k] = a[i];
                k = i;
             }else{
                 break;
             }
        }
        a[k] = temp;
    }

}
