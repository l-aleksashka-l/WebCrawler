import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class KMP {
    static String text = "abxldlkklllvlvllllvlllvl";
    static String word = "lllvl";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prefixFunction(word)));
        System.out.println(Arrays.toString(KMPSearch(text, word).toArray()));
    }

    public static int KMPSearch(String text, word word) {
        int[] prefixFunc = prefixFunction(word.word);
        int i = 0, j = 0, counter = 0;
        while (i < text.length()) {
            if (word.word.toLowerCase().charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == word.word.length()) {
                counter++;
                j = prefixFunc[j - 1];
            } else if (i < text.length() && word.word.toLowerCase().charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i++;
                }
            }
        }
        return counter;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();
        int[] prefixFunc = prefixFunction(sample);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i++;
                }
            }

        }
        return found;
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
