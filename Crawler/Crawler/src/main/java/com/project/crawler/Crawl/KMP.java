package com.project.crawler.Crawl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class KMP {

    public static List<Integer> KMPSearch(String text, List<String> strings) {
        List<Integer> integers = new ArrayList<>();
        for(String word:strings){
            int[] prefixFunc = prefixFunction(word);
            int i = 0, j = 0, counter = 0;
            while (i < text.length()) {
                if (word.toLowerCase().charAt(j) == text.charAt(i)) {
                    i++;
                    j++;
                }
                if (j == word.length()) {
                    counter++;
                    j = prefixFunc[j - 1];
                } else if (i < text.length() && word.toLowerCase().charAt(j) != text.charAt(i)) {
                    if (j != 0) {
                        j = prefixFunc[j - 1];
                    } else {
                        i++;
                    }
                }
            }
            integers.add(counter);
        }
        return integers;
    }


    static int[] prefixFunction(String sample) {
        int[] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }
}
