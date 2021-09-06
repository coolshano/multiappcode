package com.MyActualProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection extends HelloWorld {


    public void selectDB() {
        String selectSQL = "SELECT \"Full_Name\", \"Contact_Number\" FROM public.\"MyDetails\"";

        Connection c = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5050/JAVA",
                            "JavaUser", "Cool@shan200");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        try {
            String sql = selectSQL;

            var pst = c.prepareStatement(sql);
            var rs = pst.executeQuery();

            while (rs.next()) {
                System.out.print("Full Name: " + rs.getString(1));
                System.out.println(" ");
                System.out.println("Phone Number: " + rs.getInt(2));
            }

            c.close();
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(DBConnection.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
        }

    }

    public void insertDB(String F_Name, String email, int phone) {


        String newSQL = "INSERT INTO public.\"MyDetails\" (\"Full_Name\", \"Email\", \"Contact_Number\") "
                + "VALUES(?,?,?)";

        Connection c = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5050/JAVA",
                            "JavaUser", "Cool@shan200");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        try {
            String sql = newSQL;

            var pst = c.prepareStatement(sql);
            pst.setString(1, F_Name);
            pst.setString(2, email);
            pst.setInt(3, phone);
            pst.executeUpdate();
            pst.close();
            c.close();

            System.out.println("Records: " + ' ' + F_Name + ' ' + email + ' ' + phone + ' ' + "has been inserted succesfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void insertDB(String entry, String Mood, java.sql.Date myDate) {


        String entrySQL = "INSERT INTO public.\"Entry\"(\"Entry\", \"Mood\", \"Date\")"
                + "VALUES(?,?,?)";

        Connection c = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5050/JAVA",
                            "JavaUser", "Cool@shan200");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        try {
            String sql = entrySQL;

            var pst = c.prepareStatement(sql);
            pst.setString(1, entry);
            pst.setString(2, Mood);
            pst.setDate(3, myDate);
            //pst.setInt(4, ID);
            pst.executeUpdate();
            pst.close();
            c.close();

            //System.out.println("Records: " + ' ' + F_Name + ' ' + email + ' ' + phone + ' ' + "has been inserted succesfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
