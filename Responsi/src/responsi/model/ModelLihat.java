/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import responsi.controller.ControllerLihat;
import responsi.database.Conector;
import responsi.view.LihatView;

/**
 *
 * @author Acer
 */
public class ModelLihat {
    private Connection connection;
    private Statement statement;

    public ModelLihat(DefaultTableModel model) {
        Conector kon = new Conector();
        connection = kon.getConnection();
        loadData(model);
    }

    public ModelLihat(int i,DefaultTableModel model) {
        if (i == -1) {
            return;
        }
        String id = (String) model.getValueAt(i, 0);
        String nama = (String) model.getValueAt(i, 1);
        String massa = (String) model.getValueAt(i, 2);
        String harga = (String) model.getValueAt(i, 3);
        String data[] = {
          id,nama,massa,harga  
        };
        LihatView ve = new LihatView();
        ControllerLihat co = new ControllerLihat();
        co.getEditDelete(data);
    }

    public final void loadData(DefaultTableModel model){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM barang";
            ResultSet r = statement.executeQuery(sql);

            while (r.next()) {
                Object[] obj = new Object[4];
                obj[0] = r.getString("id");
                obj[1] = r.getString("nama");
                obj[2] = r.getString("massa");
                obj[3] = r.getString("harga");
                
                model.addRow(obj);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR !!"+ex.getMessage());
        }
    }
}
