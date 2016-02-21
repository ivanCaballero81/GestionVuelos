/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.projectofinal.db;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ivan
 */
public class DBConnection {

    private static Connection con = null;
    private static String dbHost = "localhost"; // Hostname
    private static String dbPort = "3306";      // Port -- Standard: 3306
    private static String dbName = "REGISTRO";   // Datenbankname
    private static String dbUser = "root";     // Datenbankuser
    private static String dbPass = "root";      // Datenbankpasswort
    private static Statement query;
    private static ResultSet result;

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.

            // Verbindung zur JDBC-Datenbank herstellen.
            con = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + "user=" + dbUser + "&" + "password=" + dbPass);
        } catch (ClassNotFoundException e) {
            System.out.println("Treiber nicht gefunden");
        } catch (SQLException e) {
            System.out.println("Verbindung nicht moglich");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    private static Connection getInstance() {
        if (con == null) {
            new DBConnection();
        }
        return con;
    }
    //Gebe Tabelle in die Konsole aus

    public static void getPais() {
        con = getInstance();

        if (con != null) {
            // Abfrage-Statement erzeugen.

            try {
                query = con.createStatement();

                // Tabelle anzeigen
                String sql = "SELECT idPais,nombre FROM PAIS";
                result = query.executeQuery(sql);

                // Ergebnisstabelle durchforsten
                while (result.next()) {
                    String idPais = result.getString("idPais");
                    String nombre = result.getString("nombre");
      
                    String info = idPais + ", " + nombre ;

                    System.out.println(info);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (result != null) {
                result.close();
            }

            if (query != null) {
                query.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

        }
    }
}
