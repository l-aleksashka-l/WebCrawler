package com.project.crawler.SQL;

import com.project.crawler.Crawl.WebCrawler;

import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionClass {


    public static Connection getConnection(int dep, int bread, Boolean t, Boolean f, String urlSite, List<String> strings) {
        String dbName = "jdbc:h2:~/test4";
        String userName = "sa";
        String password = "";
        String jdbc_driver = "org.h2.Driver";

        Connection connection = null;
        Statement statement = null;

        //https://en.wikipedia.org/wiki/Computer_programming
        //kids, game, help, si, i, program

        try {
            Class.forName(jdbc_driver);

            System.out.println("Connected to db");
            connection = DriverManager.getConnection(dbName, userName, password); //Connect to DB
            statement = connection.createStatement();
            int a = (int) (Math.random()*10000);
            System.out.println("Create table");
            SqlRequests.CreateDb(a, strings,statement); //Create table

            WebCrawler w = new WebCrawler(dep,bread,urlSite, strings,statement);
            WebCrawler.crawl(a,1,urlSite, strings,statement);

            if(t&&f){ SqlRequests.writeToCSVtop(a, statement);SqlRequests.writeToCSVFull(a,statement);}
            else if(f) SqlRequests.writeToCSVFull(a,statement);
            else if (t)SqlRequests.writeToCSVtop(a,statement);
            else System.out.println("File was not converted!");

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception SQL !");
        }


        return connection;
    }
}
