package com.leecode;

public class Test1736 {
    public String maximumTime(String time) {
    char[] chars = time.toCharArray();
        for (int i = 0; i < 5; i++) {
            if (chars[i] == '?'){
                if (i==0){
                    if (chars[1] != '4')
                    chars[i] = '2';
                    else
                        chars[i] = '1';
                }else if (i == 1){
                    if (chars[0] == '2')
                    chars[i] = '4';
                    else
                        chars[i] = '9';
                }else if(i == 3){
                    chars[i] = '5';
                }else if(i == 4){
                    chars[i] = '9';
                }
            }
        }
        String str = new String(chars);
        return str;
    }
}
