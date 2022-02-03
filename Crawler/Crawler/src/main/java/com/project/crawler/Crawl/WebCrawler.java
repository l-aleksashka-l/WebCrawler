package com.project.crawler.Crawl;

import com.project.crawler.SQL.SqlRequests;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WebCrawler {
    private static int MAX_DEPTH;
    private static int MAX_BREADTH;
    private Thread thread;
    private String first_link;
    private Statement statement;
    private static ArrayList<String> visitedLinks = new ArrayList<String>();
    private List<String> strings = new ArrayList<String>();
    private static int counter = 1;

    public WebCrawler(int MAX_DEPTH, int MAX_BREADTH, String urlSite, List<String> strings, Statement statement) {
        System.out.println("WebCrawler created");
        first_link = urlSite;
        this.statement = statement;
        this.MAX_BREADTH = MAX_BREADTH;
        this.MAX_DEPTH = MAX_DEPTH;
        this.strings = strings;

    }


    public static void crawl(int sult, int level, String url, List<String> strings, Statement statement) {
        if(isUrlValid(url)){
            if (level <= MAX_DEPTH && counter <= MAX_BREADTH) {
                Document document = request(sult,url, level, strings, statement);
                if (document != null) {
                    for (Element link : document.select("a[href]")) {
                        String next_link = link.absUrl("href");
                        if (!visitedLinks.contains(next_link)) {
                            crawl(sult, level++, next_link, strings, statement);
                        }
                    }
                }
            }
        }
    }

    private static Document request(int sult,String url, int level, List<String> strings, Statement statement) {
        try {
            Connection connection = Jsoup.connect(url);
            Document document = connection.get();

            if (connection.response().statusCode() == 200) {
                System.out.println("\n" + counter + " Recieved Webpage at " + url);
                System.out.println("Level: " + level);

                SqlRequests.addToDb(sult, url, strings, Scrapper.scrapping(url, strings), statement);
                counter++;
                String title = document.title();
                System.out.println(title);
                visitedLinks.add(url);
                return document;
            }
            return null;
        } catch (IOException | SQLException e) {
            return null;
        }
    }

    public static boolean isUrlValid(String url) {
        try {
            URL obj = new URL(url);
            obj.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Not Valid Url!");
            return false;
        }
    }


}
