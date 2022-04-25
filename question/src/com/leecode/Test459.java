package com.leecode;

public class Test459 {
    public static void main(String[] args) {
        String str="aabaaba";
        System.out.println(repeatedSubstringPattern(str));
    }
    public static boolean repeatedSubstringPattern(String s) {
        int i = 1,k=0,n=0;
        boolean judg=true;
        for (; i < s.length()/2+1; i++) {
            if(s.charAt(i) == s.charAt(0)){
                judg = true;
                k=i;
                n=i;
                for(;n<s.length();){
                    if(judg == false){
                        break;
                    }
                    for(int j = 0; j<k; j++,n++){
                        if(n>=s.length()||s.charAt(j)!=s.charAt(n)){
                            judg=false;
                            break;
                        }
                    }
                }
                if(judg == true){
                    return judg;
                }
            }
        }
        return false;
    }
}
