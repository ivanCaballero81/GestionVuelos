/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.projectofinal.Controller;

//import com.mysql.jdbc.Connection;
import edu.upn.projectofinal.Model.PasajeroDto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

                    String info = idPais + ", " + nombre;

                    System.out.println(info);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Boolean InsertPasajero(PasajeroDto pasajeroDto) {
        con = getInstance();
        
        if (con != null) {
            try {

                PreparedStatement stmt = con.prepareStatement("INSERT INTO REGISTRO.PASAJERO("
                        + " idPasajero,"
                        + " nombre,"
                        + " paterno,"
                        + " materno,"
                        + " tipoDocumento,"
                        + " numeroDocumento,"
                        + " nacimiento,"
                        + " mail,"
                        //       + " clave,"
                        + " idPais) VALUES (?, ?, ?,?,?,?,?,?,?)");
                stmt.setInt(1, pasajeroDto.getId());
                stmt.setString(2, pasajeroDto.getNombre());
                stmt.setString(3, pasajeroDto.getPaterno());
                stmt.setString(4, pasajeroDto.getMaterno());
                stmt.setString(5, pasajeroDto.getTipodocumento().toString());
                stmt.setString(6, pasajeroDto.getNumeroDocumento());
                stmt.setDate(7, new java.sql.Date(pasajeroDto.getNacimiento().getTime()));
                stmt.setString(8, pasajeroDto.getMail());
                //stmt.setString(9, pasajeroDto.getMaterno());
                stmt.setInt(9, pasajeroDto.getIdPais());
                stmt.executeUpdate();
                
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static List<PasajeroDto> getPasajeros() {
        con = getInstance();
        List<PasajeroDto> listPasajeros = new ArrayList();
        if (con != null) {
            try {
                query = con.createStatement();
                String sql = "SELECT * FROM PASAJERO";
                result = query.executeQuery(sql);
                PasajeroDto pasajero;
                while (result.next()) {
                    pasajero = new PasajeroDto(
                            result.getInt("idPasajero"),
                            result.getString("nombre"),
                            result.getString("paterno"),
                            result.getString("materno"),
                            PasajeroDto.Tipo.valueOf(result.getString("tipoDocumento")),
                            result.getString("numeroDocumento"),
                            result.getDate("nacimiento"),
                            result.getString("mail"),
                            result.getInt("idPais")
                    );
                    listPasajeros.add(pasajero);
                    System.out.println(pasajero.getPaterno());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listPasajeros;
    }

    public static int getNewId() {
        con = getInstance();
        int id = 0;
        if (con != null) {
            try {
                query = con.createStatement();
                String sql = "SELECT max(idPasajero) FROM PASAJERO";
                result = query.executeQuery(sql);

                while (result.next()) {
                    id = result.getInt(1);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
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
