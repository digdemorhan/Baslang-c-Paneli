/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kullaniciGoster;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class kullaniciEkle {
    
        //VERİTABANI BAĞLANTISI
    public static Connection dbCon() {
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kullaniciolus", "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    
    //KULLANICI EKLEME METODU
    public int kullaniciEkle(int iduser, String username, String userpass) throws SQLException {
        Connection myConn = dbCon();
        String query = "Insert into kullaniciolus.user (iduser, username, userpass) "
                + "Values (?, ?, ?)";
        PreparedStatement ps = myConn.prepareStatement(query);
        ps.setInt(1, iduser);
        ps.setString(2, username);
        ps.setString(3, userpass);
        int durum = ps.executeUpdate();
        myConn.close();
        return durum;
    }
}
