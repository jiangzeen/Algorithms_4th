package basePractice;

import java.util.*;


/**
 *给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组
 * @author: 蒋泽恩
 * @date: 2018/10/19 18:37
 * @description: LeetCode 15
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            /**
             * 优化:分别从左右查找(时间复杂度控制在O(n^2))
             */
            if(i==0|| (i > 0 && nums[i] != nums[i - 1]) ){
                int low = i + 1, high = nums.length - 1, sum = -nums[i];
                while (low < high){
                    if(nums[low] + nums[high] == sum) {
                        lists.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //跳过已排序数组中的重复值{-2,0,0,1,1,2}
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        //查找到了以后同时改变low,high的值
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] > sum){
                        high--;
                    }else {
                        low++;
                    }
                }
            }
        }
        return lists;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,1,2};
        Arrays.sort(nums);
        System.out.println(new Solution().threeSum(nums));
    }
}