package basePractice;

import java.util.HashMap;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * @author: 蒋泽恩
 * @date: 2018/10/21 10:50
 * @description:
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int temp = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                temp++;
            }else{
                if(map.get(s.charAt(i)) + temp < i){
                    temp++;
                }else{
                    max = Math.max(temp,max);
                    temp = i - map.get(s.charAt(i));
                }
                map.put(s.charAt(i), i);
            }
        }
        return Math.max(max, temp);
    }
}
