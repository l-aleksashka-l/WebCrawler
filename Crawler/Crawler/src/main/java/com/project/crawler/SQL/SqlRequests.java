package com.project.crawler.SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SqlRequests {


    public static void CreateDb(int sult, List<String> words, Statement statement) throws SQLException {
        String sql =  "CREATE TABLE CRAWLER" + sult +
                " ( url VARCHAR(255), " + Helper.listToSQLCreate(words) ;
        statement.executeUpdate(sql);
    };

    public static void addToDb(int sult,String urlSite, List<String> words, List<Integer> integers, Statement statement) throws SQLException {
        String sql = String.format("INSERT INTO CRAWLER"+sult+ " (url, "+ Helper.listToSQLRequest(words) + ") VALUES ('%s', " + Helper.listToSQLRequestInt(integers), urlSite);
        statement.executeUpdate(sql);
    }

    public static void writeToCSVFull(int sult,Statement statement) throws SQLException {
        String sql = "CALL CSVWRITE('D:/Download/Projects/WebCrawler/Crawler/Crawler/target/test/full.csv', 'SELECT * FROM CRAWLER"+sult+"')";
        statement.executeUpdate(sql);
    }

        public static void writeToCSVtop(int sult,Statement statement) throws SQLException {
        String sql = "CALL CSVWRITE('D:/Download/Projects/WebCrawler/Crawler/Crawler/target/test/top.csv', 'SELECT * FROM CRAWLER"+sult+" ORDER BY total DESC LIMIT 10')";
        statement.executeUpdate(sql);
    }

}
