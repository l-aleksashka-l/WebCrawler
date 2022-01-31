import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<WebCrawler> bots = new ArrayList<>();
        bots.add(new WebCrawler("http://abcnews.go.com", 1));
        //bots.add(new WebCrawler("https://www.reddit.com/",2));
        //bots.add(new WebCrawler("http://www.nytimes.com", 3));

        for(WebCrawler w : bots){
            w.getThread();
        }
    }
}
