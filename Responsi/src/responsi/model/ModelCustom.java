/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.model;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import responsi.controller.ControllerCustom;
import responsi.controller.ControllerTambah;
import responsi.database.Conector;

/**
 *
 * @author Acer
 */
public class ModelCustom {
    private Connection connection;
    private Statement statement;
    public ModelCustom() {
        Conector kon = new Conector();
        connection = kon.getConnection();
    }

    
    public void hapus(String[] data1) {
        try{
            String query = " delete from barang where id='"+data1[0]+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
            JOptionPane.showMessageDialog(null, "Hapus Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()+"Hapus gagal");
        }
    }

    public void hitung(String[] data1, double jml) {
        double harga,total,total1;
        if(jml>=12 && jml<20){
            harga= parseDouble(data1[3]);
            total = jml*harga;
            total1 = 0.05*total;
            total = total-total1;
        }
        else if(jml>=20 && jml<144){
            harga= parseDouble(data1[3]);
            total = jml*harga;
            total1 = 0.1*total;
            total = total-total1;
        }else{
            harga= parseDouble(data1[3]);
            total = jml*harga;
            total1 = 0.25*total;
            total = total-total1;total = 25*(harga/100);
            total = jml*total;
        }
        System.out.println(total);
        ControllerCustom cus=new ControllerCustom();
        cus.menghitung(data1,total);
    }

}
