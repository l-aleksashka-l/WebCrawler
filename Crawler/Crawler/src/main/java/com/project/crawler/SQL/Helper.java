package com.project.crawler.SQL;

import java.sql.Array;
import java.util.*;

public class Helper {
    public static String listToSQLCreate(List<String> words) {
        int a = 0;
        String sql = "";
        while (a < words.size()) {
            sql = sql + words.get(a) + " INTEGER, ";
            a++;
        }
        return sql + "total INTEGER)";
    }
    public static String listToSQLRequest(List<String> words) {
        int a = 0;
        String sql = "";
        while (a < words.size()) {
            sql = sql + words.get(a) + ", ";
            a++;
        }
        return sql + "total";
    }
    public static String listToSQLRequestInt(List<Integer> words) {
        int a = 0, sum = 0;
        String sql = "";
        while (a < words.size()) {
            sql = sql + words.get(a) + ", ";
            sum+=words.get(a);
            a++;
        }
        return sql + sum + ")";
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
