package chapter02.sort;

import java.util.Arrays;

/**
 * @author: 蒋泽恩
 * @date: 2018/12/4 16:41
 * @description: 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] number = {5,2,10,7,9,15,8,11,12,1};
        quickSort(number, 0, number.length -1);
        System.out.println(Arrays.toString(number));
    }

    /**
     * @return
     */
    public static void quickSort(int[] a, int low, int high){
        if(high <= low) {
            return;
        }
        int temp = partition(a,low, high);
        quickSort(a, low, temp - 1);
        quickSort(a, temp+1, high);
    }
    /**
     *
     * @param a
     * @param low
     * @param high
     * @return 获取基准位
     */
    private static int partition(int[] a, int low, int high){
        int v = a[low];
        while(high > low){
            while(a[high] >= v && high > low){
                high--;
            }
            //填坑
            a[low] = a[high];
            if(a[low] <= v && low < high){
                low++;
            }
            a[high] = a[low];
        }
        a[high] = v;
        return high;
    }

}

