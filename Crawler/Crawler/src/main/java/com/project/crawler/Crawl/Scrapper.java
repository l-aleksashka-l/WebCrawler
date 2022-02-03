package com.project.crawler.Crawl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;

public class Scrapper {
    public static List<Integer> scrapping(String urlSite, List<String> strings) throws IOException {

        final Document document = Jsoup.connect(urlSite).get();
        String site = Jsoup.parse(document.outerHtml()).text().toLowerCase();
        return KMP.KMPSearch(site,strings);
    }
}

