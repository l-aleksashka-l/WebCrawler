import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WebScrape {
    public static void main(String[] args) {
        final String url = "https://en.wikipedia.org/wiki/Pineapple";
        /*Map<Integer, word> words = new HashMap<Integer, word>();
        words.put(0, new word("Pineapple", 0));
        words.put(1, new word("is", 0));
        words.put(2, new word("log", 0));
        words.put(3, new word("fruit", 0));*/
        Map<Integer, word> wordsKMP = new HashMap<Integer, word>();
        wordsKMP.put(0, new word("ananas comosus", 0));
        wordsKMP.put(1, new word("s", 0));
        wordsKMP.put(2, new word("jump to", 0));
        wordsKMP.put(3, new word("fruit", 0));
        try {
            final Document document = Jsoup.connect(url).get();
            String site = Jsoup.parse(document.outerHtml()).text().toLowerCase();
            String[] text = site.split("");
            int a = 440, x = 0, y = 0;
            while(a < 540){
            System.out.print(text[a] ); a++;}
            String[] t = site.split(" ");
            System.out.print(1 + " ");
            for(String word : text){
                if(y == 100) {x+=100; System.out.print("\n" + x + " ");y=0;}
                System.out.print(word );
                y++;

            }
            /*
            for (String word : text) {
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).word.toLowerCase().equals(word.toLowerCase()))
                        words.get(i).counter++;
                }
            }
            for (int i = 0; i < words.size(); i++) {
                System.out.println(words.get(i));
            }*/
            System.out.println("");
             for (int i = 0; i < wordsKMP.size(); i++) {
                 word w = wordsKMP.get(i);
                 w.counter = (KMP.KMPSearch(site,w));
                 System.out.println(wordsKMP.get(i));
                 System.out.println(Arrays.toString(KMP.KMPSearch(site, w.word.toLowerCase()).toArray()));

             }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
