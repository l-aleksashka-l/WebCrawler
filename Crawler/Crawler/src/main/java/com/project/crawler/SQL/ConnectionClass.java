package com.project.crawler.SQL;

import java.sql.*;

public class ConnectionClass {



    public static Connection getConnection(String string){
        String dbName="jdbc:h2:~/test3";
        String userName="sa";
        String password="";
        String jdbc_driver="org.h2.Driver";

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(jdbc_driver);

            System.out.println("Connected to db");
            connection= DriverManager.getConnection(dbName, userName,password);

            System.out.println("Create table");
            statement = connection.createStatement();
           String sql =  "CREATE TABLE   REGISTRATION " +
                    "(id INTEGER AUTO_INCREMENT not NULL, url VARCHAR(255), " + string +
                    " PRIMARY KEY ( id ))";
            //statement.executeUpdate(sql);
            System.out.println(sql);
            for(int i = 0; i < 3; i++) {
                int a =i, b=i + 48, c =i*6;
                String sql1 = "INSERT INTO REGISTRATION(id, url, hui, davalka, chlen, total) VALUES (" + i +", 'url', " + a +", "+ b + ", "+c+", "+(a+b+c)+")";
                //System.out.println(sql);
                statement.executeUpdate(sql1);
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception SQL !");
        }



        return connection;
    }
}
