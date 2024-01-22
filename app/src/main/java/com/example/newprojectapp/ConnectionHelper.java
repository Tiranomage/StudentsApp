package com.example.newprojectapp;

import static java.sql.DriverManager.getConnection;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionHelper {
    Connection conn;
    String name, pass, ip, port, database;

    public Connection connectionClass() {
        ip = "localhost";
        database = "urfuaparts";
        name = "root";
        pass = "";
        port = "3306";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ConnectionURL = "jdbc:mysql://" + ip + ":" + port + ";" + "databasename=" + database + ";user=" + name + ";password" + pass + ";";
            connection = getConnection(ConnectionURL);
        }
        catch (Exception ex) {
            Log.e("Error", ex.getMessage());
        }
        return connection;
    }

    public void addNewUser(String mail, String password, String name, String gender) {
        System.out.println("OK");
        Connection connection = connectionClass();
        System.out.println("OK");

        if (connection != null) {
            try {
                System.out.println("OK");
                String query = "INSERT INTO users (mail, password, name, gender) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, mail);
                preparedStatement.setString(2, password);

                if (name != null) {
                    preparedStatement.setString(3, name);
                }

                if (gender != null) {
                    preparedStatement.setString(4, gender);
                }

                preparedStatement.execute();

                System.out.println("User added successfully.");
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


