package com.leecode;

public class Test583 {
    public static void main(String[] args) {
        String word1 = "intention",word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }
    public static int minDistance(String word1, String word2) {
        int count = 0,max = 0,x = 0;
        for (int k = 0; k < word1.length(); k++) {
            for (int i = k; i < word1.length(); i++) {
                for (int j = x; j < word2.length(); j++) {
                    if (word2.charAt(j) == word1.charAt(i)){
                        count ++;
                        i++;
                        x = j + 1;
                        if (i==word1.length())
                            break;
                    }
                }
                if(x == word2.length()){
                    break;
                }
            }
            max = Math.max(max,count);
            count = 0;
            x = 0;
        }
        String str;
        str = word1;
        word1 = word2;
        word2 = str;
        for (int k = 0; k < word1.length(); k++) {
            for (int i = k; i < word1.length(); i++) {
                for (int j = x; j < word2.length(); j++) {
                    if (word2.charAt(j) == word1.charAt(i)){
                        count ++;
                        i++;
                        x = j + 1;
                        if (i==word1.length())
                            break;
                    }
                }
                if(x == word2.length()){
                    break;
                }
            }
            max = Math.max(max,count);
            count = 0;
            x = 0;
        }
        return word1.length() - max + word2.length() - max;
    }
}
