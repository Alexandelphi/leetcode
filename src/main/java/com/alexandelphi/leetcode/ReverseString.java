package com.alexandelphi.leetcode;

class ReverseString {
    public String reverseString(String s) {
        char[] temp = new char[s.length()];
        int i = 0;
        int j = s.length()-1;
        
        while (i <= j) {
            temp[i] = s.charAt(j);
            temp[j] = s.charAt(i);
            i++;
            j--;
        }
        return new String(temp);
    }

    public static void main(String[] args) {
        ReverseString reverse = new ReverseString();

        String input = "hello";
        System.out.println(reverse.reverseString(input));
    }
}