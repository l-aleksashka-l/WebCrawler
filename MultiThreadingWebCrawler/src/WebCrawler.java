import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.print.Doc;
import java.io.IOException;
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
        crawl(1,first_link);
    }

    private void crawl(int level, String url){
        if(level <= MAX_DEPTH && counter < 10000){
            Document document = request(url);

            if(document != null){
                for(Element link : document.select("a[href]")){
                    String next_link = link.absUrl("href");
                    if(!visitedLinks.contains(next_link)){
                        crawl(level++, next_link);

                    }
                }
            }
        }
    }

    private Document request(String url){
        try{
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();

            if(connection.response().statusCode()==200){
                System.out.println("\n" + counter + " **Bot ID: " + ID + " Recieved Webpage at " + url);
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

    public Thread getThread(){
        return thread;
    }
}
