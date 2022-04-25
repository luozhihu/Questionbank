package com.leecode;

public class Test678 {
    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidString(s));
    }
    public static boolean checkValidString(String s) {
        int low = 0,high = 0;
        char[] c=s.toCharArray();
        for ( char item : c ) {
            if(item == '('){
                low++;
                high++;
            }else if(item == ')'){
                low--;
                high--;
            }else {
                low --;
                high ++;
            }
            if(low<0){
                low = 0;
            }
            if(high < low){
                return false;
            }
        }
        return low == 0;
    }
}
