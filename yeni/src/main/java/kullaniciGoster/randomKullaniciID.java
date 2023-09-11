/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kullaniciGoster;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class randomKullaniciID {
    
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
    
    //KULLANICI ID'LERİNİ OTOMATİK ATAMA
    public void randomizeKullaniciIds() throws SQLException {
        Connection connection = dbCon();
        String selectSql = "SELECT iduser FROM user";
        PreparedStatement selectStatement = connection.prepareStatement(selectSql);
        ResultSet resultSet = selectStatement.executeQuery();
        ArrayList<Integer> kullaniciIds = new ArrayList<>();
        while (resultSet.next()) {
            kullaniciIds.add(resultSet.getInt("iduser"));
        }
        Random random = new Random();
        String updateSql = "UPDATE user SET iduser = ? WHERE iduser = ?";
        PreparedStatement updateStatement = connection.prepareStatement(updateSql);
        for (int kullaniciId : kullaniciIds) {
            int yeniKullaniciId = random.nextInt(101);
            updateStatement.setInt(1, yeniKullaniciId);
            updateStatement.setInt(2, kullaniciId);
            updateStatement.executeUpdate();
        }
        resultSet.close();
        selectStatement.close();
        updateStatement.close();
        connection.close();
    }
}
