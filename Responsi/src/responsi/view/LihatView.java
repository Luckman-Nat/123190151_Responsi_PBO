/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import responsi.controller.ControllerLihat;
import responsi.controller.ControllerMenu;
import responsi.database.Conector;
import responsi.model.ModelLihat;

/**
 *
 * @author Acer
 */
public class LihatView extends JFrame implements ActionListener {
    private DefaultTableModel model;
    private JTable table1;
    private JButton kembali;
    public void openTable() {
        setTitle("Data Barang");
        kembali = new JButton("Kembali");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550,300);
        model = new DefaultTableModel(); 
        table1 = new JTable(model);
        add(table1);
        add(kembali);

        model.addColumn("Id");
        model.addColumn("Nama");
        model.addColumn("Massa");
        model.addColumn("Harga");
        
        table1.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        
        JScrollPane scroll = new JScrollPane(table1);
        getContentPane().add(scroll);
        this.getContentPane().add(BorderLayout.CENTER, scroll);
        kembali.setBounds(0,243,550,20);
        kembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kembali.addActionListener(this);
        ModelLihat mo = new ModelLihat(model);
        setResizable(false);
        setVisible(true);
    }

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {                                    
                // TODO add your handling code here:
        int i = table1.getSelectedRow();
        ModelLihat mo = new ModelLihat(i,model);
        this.dispose();
    }
                                       
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==kembali)
        {
            ControllerMenu men = new ControllerMenu();
            men.OpenMenu();
            this.dispose();
        }
    }
    
}
