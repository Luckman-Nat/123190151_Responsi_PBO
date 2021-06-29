/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.view;

import responsi.controller.ControllerLihat;
import responsi.controller.ControllerTambah;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Acer
 */
public class MenuView extends JFrame implements ActionListener {
    private JLabel judul;
    private JButton tambah, lihat;

    public MenuView() {
        setTitle("-");
        judul = new JLabel("Main Menu");
        tambah = new JButton("Tambah Barang");
        lihat = new JButton("Lihat Barang");
        judul.setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(new GridLayout(4,2));
        add(judul);
        add(tambah);
        add(lihat);
        pack();
        setResizable(false);
        setLocation(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        tambah.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lihat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tambah.addActionListener(this);
        lihat.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== tambah){
            ControllerTambah tam = new ControllerTambah();
            tam.createTambah();
            dispose();
        }
        else{
            ControllerLihat li = new ControllerLihat();
            li.createLihat();
            dispose();
        }
    }
}
