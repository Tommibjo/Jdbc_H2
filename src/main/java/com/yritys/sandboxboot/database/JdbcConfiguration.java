/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.sandboxboot.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Tommi
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class JdbcConfiguration {

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.pass}")
    private String pass;

    @Value("${jdbc.url}")
    private String url;

    @Bean
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Properties connProps = new Properties();
        try {
            Class.forName("org.h2.Driver");
            connProps.put("user", user);
            connProps.put("password", pass);
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conne   ction succesfull!");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return conn;
    }
}
