package com.leecode;

public class Test838 {
    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        System.out.println(pushDominoes(dominoes));
    }
    public static String pushDominoes(String dominoes) {
        char[] ch = dominoes.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n-1;) {
            for (int j = i+1; j < n; j++) {
                if (ch[j] == 'L'){
                    if (ch[i] == 'L'||ch[i] == '.'){
                        int x = i;
                        while (x<=j){
                            ch[x] = 'L';
                            x++;
                        }
                    }else {
                        int x=i,y=j;
                        while (x<y){
                            ch[x] = 'R';
                            ch[y] = 'L';
                            x++;y--;
                        }
                    }
                    i=j;
                    break;
                }else if (ch[j] == 'R'){
                    if (ch[i] == 'L'||ch[i] == '.'){

                    }else {
                        int x = i;
                        while (x<=j){
                            ch[x] = 'R';
                            x++;
                        }
                    }
                    i=j;
                    break;
                }else if (j == n-1){
                    if (ch[i] == 'L'||ch[i] == '.'){

                    }else {
                        int x = i;
                        while (x<=j){
                            ch[x] = 'R';
                            x++;
                        }
                    }
                    i=j;
                    break;
                }
            }
        }
       return new String(ch);
    }
}
