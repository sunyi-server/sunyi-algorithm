package com.sunyi.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 无重复字符的最长子串
 * </p>
 *
 * @author sunyi
 * @date 20191226
 */
public class MaxLengthNoReString {
    public int lengthOfLongestSubstring(String s) {
        char[] targetStrings = s.toCharArray();
        int maxLength = 0;
        //创建无重复字符串队列
        List<Character> list = new LinkedList<Character>();
        for (int i = 0; i < targetStrings.length; i++) {
            //遍历队列中是否有重复的字符
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(targetStrings[i])) {
                    //判断队列的长度是否为最长
                    if (maxLength < list.size()) {
                        maxLength = list.size();
                    }
                    //删除重复字符之前（包括重复字符）的所有字符
                    for (int k = 0; k <= j; k++) {
                        list.remove(0);
                    }
                    //有重复字符则取消这层循环
                    break;
                }
            }
            list.add(targetStrings[i]);
        }
        if (list.size() > maxLength) {
            return list.size();
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new MaxLengthNoReString().lengthOfLongestSubstring(" "));
    }
}
