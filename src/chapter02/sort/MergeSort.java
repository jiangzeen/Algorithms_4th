package chapter02.sort;

import java.util.Arrays;

/**
 * @author: 蒋泽恩
 * @date: 2018/12/3 15:40
 * @description: 归并排序
 */
public class MergeSort {
    private static int[] aux;  //设为类成员--避免每次使用时创建数组
    public static void main(String[] args) {
        int[] number2 = {6,3,10,5,8,9,11,12,20,15,9,30};
        sort(number2);
    }
    /**
     * 原地归并的排序--a[low...mid]与a[mid...high]都是有序的数组
     * @param a
     * @param low
     * @param mid
     * @param high
     * @return
     */
    public static int[] merge(int[] a, int low, int mid, int high){
        int i = low, j = mid + 1;
        for (int k = 0; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if(i > mid) {
                a[k] = aux[j++];
            }else if(j > high){
                a[k] = aux[i++];
            }else if(aux[i] >  aux[j]){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
        }
        return a;
    }

    /**
     * 自定向下的归并排序
     * @param a
     * @param low
     * @param high
     */
    public static void merge_sort(int[] a, int low, int high){
           if(low >= high) {
               return;
           }
            int mid = low + (high - low) / 2;
            merge_sort(a, low, mid);
            merge_sort(a, mid + 1, high);
            merge(a, low, mid, high);
    }
    public static void sort(int[] a){
        aux = new int[a.length];
        merge_sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
