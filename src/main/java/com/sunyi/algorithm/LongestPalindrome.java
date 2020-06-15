package com.sunyi.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 最长回文子串(即这个子串倒过来和正过来是一样的)
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * </p>
 *
 * @author sunyi
 * @date 20200101
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().solution("babadada"));
    }

    public String solution(String s) {
        if (s.equals("") || s.length() == 1) {
            return s;
        }
        char[] sChar = s.toCharArray();
        String maxLengthString = sChar[0] + "";
        int maxLength = 1;
        HashMap<Character, List<Integer>> charContainer = new HashMap<Character, List<Integer>>(10);
        for (int i = 0; i < sChar.length; i++) {
            String stringTemp = null;
            if (charContainer.containsKey(sChar[i])) {
                List<Integer> indexList = charContainer.get(sChar[i]);
                indexList.add(i);
                //判断是否为回文子串
                int start = indexList.get(0);
                int end = indexList.get(indexList.size() - 1);
                if ((end - start + 1) <= maxLength) {
                    continue;
                } else {
                    char[] charTemp = new char[end - start + 1];
                    boolean flag = (start - end + 1) % 2 == 0;
                    char[] oneTemp, twoTemp;
                    String tempString = "";
                    int f;
                    if (flag) {
                        oneTemp = new char[(end - start) / 2 + 1];
                        twoTemp = new char[(end - start) / 2 + 1];
                        f = (end - start) / 2;
                    } else {
                        oneTemp = new char[(end - start) / 2];
                        twoTemp = new char[(end - start) / 2];
                        f = (end - start) / 2 - 1;
                    }
                    int k = 0;
                    int e = 0;
                    for (int j = start; j <= end; j++, k++) {
                        charTemp[k] = sChar[j];
                        tempString = tempString + sChar[j];
                        if (flag) {
                            //偶数
                            int middle = charTemp.length / 2 + start - 1;
                            if (j <= middle) {
                                oneTemp[e] = sChar[j];
                                e++;
                            } else {
                                twoTemp[f] = sChar[j];
                                f--;
                            }
                        } else {
                            //奇数
                            int middle = charTemp.length / 2 + start;
                            if (j < middle) {
                                oneTemp[e] = sChar[j];
                                e++;
                            } else if (j > middle) {
                                twoTemp[f] = sChar[j];
                                f--;
                            }
                        }
                    }
                    if (Arrays.toString(oneTemp).equals(Arrays.toString(twoTemp))) {
                        maxLength = end - start + 1;
                        maxLengthString = tempString;
                    }
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                charContainer.put(sChar[i], list);
            }
        }
        return maxLengthString;
    }
}
