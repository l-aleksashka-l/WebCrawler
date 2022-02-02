package com.project.crawler.SQL;

import java.sql.Array;
import java.util.*;

public class Helper {
    public static String listToSQL(List<String> words) {
        int a = 0;
        String sql = "";
        while (a < words.size()) {
            sql = sql + words.get(a) + " INTEGER, ";
            a++;
        }
        return sql + "total INTEGER, ";
    }

    public static List<String> stringToList(String string) {
        String[] words = string.split(",");
        List<String> substring = new ArrayList<>();
        for (String word : words) {
            substring.add(word.toLowerCase(Locale.ROOT).trim());
        }
        return substring;
    }
}
