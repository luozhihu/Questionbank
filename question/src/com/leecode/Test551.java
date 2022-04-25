package com.leecode;

public class Test551 {
    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(checkRecord(s));

    }
    public static boolean checkRecord(String s) {
        int countA = 0, countL = 0;
        int i = 0;
        while (i<s.length()){
            if(s.charAt(i) == 'A'){
                countA++;
            }
            if(s.charAt(i) == 'L'){
                countL++;
            }else {
                countL=0;
            }
            if(countL>=3){
                return false;
            }
            i++;
        }
        if (countA<2) {
            return true;
        }else {
            return false;
        }
    }
}
