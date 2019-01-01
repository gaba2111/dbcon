package com.example.gaba.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Struct;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                insert();
            }
        }).start();
    }

    protected void insert() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://alkosmartband-mysql-db.mysql.database.azure.com:3306/new_smartband_db?useSSL=true&requireSSL=false";
            String user = "alkoadmin@alkosmartband-mysql-db";
            String password = "Alkomat211.";
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO test2 (first_name,last_name) VALUES (?, ?)");
            statement.setString(1, "blabla12");
            statement.setString(2, "nazwisko23");
            statement.execute();
//            statement.close();
//            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
