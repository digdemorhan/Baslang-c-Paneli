/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kullaniciGoster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    
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
    
    public static void main(String[] args) throws SQLException {
        
        kullaniciEkle obje = new kullaniciEkle();
        obje.kullaniciEkle(433, "fdgdf","6666");
        
        
         randomKullaniciID nsn = new randomKullaniciID();
        try {
            nsn.randomizeKullaniciIds();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
}
