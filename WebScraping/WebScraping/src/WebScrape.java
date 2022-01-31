import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebScrape {
    public static void main(String[] args) {
         final String url = "https://en.wikipedia.org/wiki/Pineapple";
         try{
             final Document document = Jsoup.connect(url).get();
             System.out.println(Jsoup.parse(document.outerHtml()).text());
         }catch(Exception e){
             e.printStackTrace();
         }
    }
}
