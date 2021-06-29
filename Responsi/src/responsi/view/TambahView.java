/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import responsi.controller.ControllerTambah;
import responsi.controller.ControllerMenu;

/**
 *
 * @author Acer
 */
public class TambahView extends JFrame implements ActionListener {
    private JTextField inama, imassa, iharga;
    private JLabel judul, lnama, lmassa, lharga;
    public int x=0;
    public String data1[];
    
    private JButton btnSubmit, btnReset, kembali;
    public void openForm() {
        setTitle("Input Daerah");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,225);

        inama = new JTextField(10);
        imassa = new JTextField(10);
        iharga = new JTextField(10);
        judul = new JLabel(" Input Barang ");
        lnama = new JLabel(" Nama ");
        lmassa = new JLabel(" Massa (gr) ");
        lharga = new JLabel(" Harga Satuan ");
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        kembali = new JButton("Kembali");

        setLayout(null);
        add(judul);
        add(inama);
        add(lnama);
        add(lmassa);
        add(imassa);
        add(lharga);
        add(iharga);
        add(btnSubmit);
        add(btnReset);
        add(kembali);

        judul.setBounds(10,10,120,20);
        lnama.setBounds(10,35,120,20);
        inama.setBounds(130,35,190,20);
        lmassa.setBounds(10,60,120,20);
        imassa.setBounds(130,60,190,20);
        lharga.setBounds(10,85,120,20);
        iharga.setBounds(130,85,190,20);
        btnSubmit.setBounds(75,125,120,20);
        btnSubmit.setBackground(Color.blue);
        btnSubmit.setForeground(Color.white);
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(this);
        btnReset.setBounds(200,125,120,20);
        btnReset.setBackground(Color.red);
        btnReset.setForeground(Color.white);
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset.addActionListener(this);
        kembali.setBounds(10,155,320,20);
        kembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kembali.addActionListener(this);

        setResizable(false);
        setLocation(450,200);
        setVisible(true);
        x=0;
    }

    public void edit(String[] data){
        this.data1=data;
        setTitle("Edit Daerah");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,225);

        inama = new JTextField(data[1]);
        imassa = new JTextField(data[2]);
        iharga = new JTextField(data[3]);
        judul = new JLabel(" Edit Barang ");
        lnama = new JLabel(" Nama ");
        lmassa = new JLabel(" Massa (gr) ");
        lharga = new JLabel(" Harga Satuan ");
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        kembali = new JButton("Kembali");

        setLayout(null);
        add(judul);
        add(inama);
        add(lnama);
        add(lmassa);
        add(imassa);
        add(lharga);
        add(iharga);
        add(btnSubmit);
        add(btnReset);
        add(kembali);

        judul.setBounds(10,10,120,20);
        lnama.setBounds(10,35,120,20);
        inama.setBounds(130,35,190,20);
        lmassa.setBounds(10,60,120,20);
        imassa.setBounds(130,60,190,20);
        lharga.setBounds(10,85,120,20);
        iharga.setBounds(130,85,190,20);
        btnSubmit.setBounds(75,125,120,20);
        btnSubmit.setBackground(Color.blue);
        btnSubmit.setForeground(Color.white);
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(this);
        btnReset.setBounds(200,125,120,20);
        btnReset.setBackground(Color.red);
        btnReset.setForeground(Color.white);
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset.addActionListener(this);
        kembali.setBounds(10,155,320,20);
        kembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kembali.addActionListener(this);

        setResizable(false);
        setLocation(450,200);
        setVisible(true);
        x=1;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSubmit) {
            if (inama.getText().equals("")) {
                setMessage("kolom nama harus diisi");
            }
            if (imassa.getText().equals("")) {
                setMessage("kolom massa harus diisi");
            }
            if (iharga.getText().equals("")) {
                setMessage("kolom harga harus diisi");
            }
            else {
                ControllerTambah tam = new ControllerTambah();
                if(x==0){
                    String[] data = {
                        inama.getText(), imassa.getText(), iharga.getText()
                    };
                    tam.createTambah(data);
                }else if(x==1){
                    String[] data = {
                        data1[0],inama.getText(), imassa.getText(), iharga.getText()
                    };
                    tam.editInput(data);
                }
                
            }
        }
        else if(e.getSource()==btnReset){
            reset();
        }
        else if(e.getSource()==kembali){
            dispose();
            ControllerMenu m = new ControllerMenu();
            m.OpenMenu();
        }
    }

    public void reset(){
        inama.setText("");
        imassa.setText("");
        iharga.setText("");
    }
    private void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
}
