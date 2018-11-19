package com.ywt.leetcode.problem804;

import java.util.TreeSet;

/**
 * @author: YwT
 * @description: LeetCode 804号问题
 * @create: 2018-11-19 15:07
 **/
public class UniqueMorseCodeWords804 {
    public int  uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....",
                "..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++){
                res.append(codes[word.charAt(i) - 'a']);
            }
            set.add(res.toString());
            res.setLength(0);
        }

        return set.size();
    }
}
