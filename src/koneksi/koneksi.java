/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;
/**
 *
 * @author One For All
 */
public class koneksi {
    
    public static Connection getConnection(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static ResultSet getData(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Connection koneksi;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException ex){
            System.out.println("Koneksi Gagal");
        }
        String url ="jdbc:mysql://localhost/rental";
        try{
            koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("Berhasil Koneksi database");
        }catch(SQLException ex){
            System.out.println("Gagal Koneksi Database"+ ex);
        }
        return koneksi;
    }
}
