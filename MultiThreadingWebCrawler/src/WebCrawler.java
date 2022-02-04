import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.print.Doc;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class WebCrawler implements Runnable {
    private static final int MAX_DEPTH = 3;
    private Thread thread;
    private String first_link;
    private ArrayList<String> visitedLinks = new ArrayList<String>();
    private int ID;
    private static int counter = 1;

    public WebCrawler(String link, int num) {
        System.out.println("WebCrawler created");
        first_link = link;
        ID = num;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        crawl(1, first_link);
    }

    private void crawl(int level, String url) {
        if (isUrlValid(url)) {
            if (level <= MAX_DEPTH && counter < 10000) {
                Document document = request(url, level);
                if (document != null) {
                    for (Element link : document.select("a[href]")) {
                        String next_link = link.absUrl("href");
                        if (!visitedLinks.contains(next_link)) {
                            crawl(level++, next_link);
                            
                        }
                    }
                }
            }
        }
    }

    private Document request(String url, int level) {
        try {
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();

            if (connection.response().statusCode() == 200) {
                System.out.println("\n" + counter + " **Bot ID: " + ID + " Recieved Webpage at " + url);
                System.out.println("Level: " + level);
                counter++;
                String title = document.title();
                System.out.println(title);
                visitedLinks.add(url);
                return document;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean isUrlValid(String url) {
        try {
            URL obj = new URL(url);
            obj.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public Thread getThread() {
        return thread;
    }
}
