package com.ywt.stack;

import java.util.Stack;

/**
 * @description: 匹配括号
 * @author: YwT
 * @create: 2018-10-16 13:56
 **/
public class Solution {

    public static boolean isValid(String s){
        //Stack<Character> stack = new Stack<>();
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                switch (c){
                    case ')': if (topChar != '(') return false;break;
                    case ']': if (topChar != '[') return false;break;
                    case '}': if (topChar != '{') return false;break;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
        System.out.println(isValid("({[}])"));
    }
}
