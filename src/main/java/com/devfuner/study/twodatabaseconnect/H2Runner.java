package com.devfuner.study.twodatabaseconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

    @Autowired
    @Qualifier(value = "dataSource")
    DataSource dataSource;

    @Autowired
    @Qualifier(value = "subDataSource")
    DataSource subDataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getMetaData().getURL());
        System.out.println(connection.getMetaData().getUserName());

        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE MAIN (ID INTEGER NOT NULL, MAIN_NAME VARCHAR(255), PRIMARY KEY (ID))";
        statement.executeUpdate(sql);

        statement.executeUpdate("INSERT INTO MAIN (ID, MAIN_NAME) VALUES (1, 'MAIN MAIN MAIN')");

        connection.close();

        Connection connection2 = subDataSource.getConnection();
        System.out.println(connection2.getMetaData().getURL());
        System.out.println(connection2.getMetaData().getUserName());
        Statement statement2 = connection2.createStatement();
        String sql2 = "CREATE TABLE sub (ID INTEGER NOT NULL, sub_NAME VARCHAR(255), PRIMARY KEY (ID))";
        statement2.executeUpdate(sql2);

        statement2.executeUpdate("insert into sub (id, sub_name) values (1, 'sub sub sub')");

        connection.close();
    }
}
