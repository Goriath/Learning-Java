package com.kfryc;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Programming\\Databases\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            conn.setAutoCommit(false);  //does not automatically execute statements
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("Create Table IF NOT EXISTS " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + " TEXT, " +
                    COLUMN_PHONE + " Integer, " +
                    COLUMN_EMAIL + " Text)");


            insertContact(statement, "Krzysztof", 60145901, "krzysztof@email.com");
            insertContact(statement, "Anna", 151243, "anna@email.com");
            insertContact(statement, "Magda", 514443, "magda@email.com");
            insertContact(statement, "Pawel", 7433433, "pawel@email.com");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COLUMN_PHONE + "= 601450890" +
                    " WHERE " + COLUMN_NAME + " = 'Krzysztof'");

            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + " = 'Pawel'");

            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getInt(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL));
            }

            results.close();


//            conn.commit();  // if setAutoCommit is set to false

            // It is good practise to close the connection to manage resources.
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }


    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL + ") " +
                "VALUES('" + name + "', '" + phone + "', '" + email + "')");
    }
}
