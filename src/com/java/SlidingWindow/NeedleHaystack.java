package com.java.SlidingWindow;

public class NeedleHaystack {
    public static void main(String[] args) {
        NeedleHaystack c = new NeedleHaystack();
        System.out.println(c.strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;

        for(int i = 0; i<haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                // found a match start window iteration
                int index = 1;
                int start = i;
                i++;
                while(index<needle.length() && i<haystack.length()) {
                    if(haystack.charAt(i) == needle.charAt(index)) {
                        i++;
                        index++;
                    } else break;
                }

                if(index == needle.length()) return start;
                i -= 2;
            }
        }

        return -1;
    }
}
