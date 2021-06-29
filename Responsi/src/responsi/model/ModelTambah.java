/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import responsi.database.Conector;

/**
 *
 * @author Acer
 */
public class ModelTambah {
    private Connection connection;
    private Statement statement;

    public ModelTambah() {
        Conector kon = new Conector();
        connection = kon.getConnection();
    }

    public void createTambah(String[] data) {
         try{
            String query = " insert into barang (id, nama, massa, harga) values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, 0);
            preparedStmt.setString (2, data[0]);
            preparedStmt.setDouble (3, Double.parseDouble(data[1]));
            preparedStmt.setDouble (4, Double.parseDouble(data[2]));
            preparedStmt.execute();
            connection.close();
            JOptionPane.showMessageDialog(null, "Input Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"Input Gagal");
        }
    }

    public void edit(String[] data) {
        try{
            String query = " update barang set nama='"+data[1]+"',massa='"+data[2]+"',harga='"+data[3]+"' where id='"+data[0]+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
            JOptionPane.showMessageDialog(null, "Edit Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"Edit Gagal");
        }
    }
}
