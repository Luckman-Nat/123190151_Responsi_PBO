/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.database;
import java.sql.*;
/**
 *
 * @author Acer
 */
public class Conector {
    String DBurl = "jdbc:mysql://localhost:3306/barang";
    String DBusername= "root";
    String DBpassword= "";
    Connection koneksi;
    Statement statement;
    public Conector() {
        try{
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println(ex.getMessage()+"koneksi gagal");
        }
    }
    public Connection getConnection(){
        return  koneksi;
    }
}
