/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import responsi.controller.ControllerCustom;
import responsi.controller.ControllerLihat;
import responsi.controller.ControllerMenu;
import responsi.controller.ControllerTambah;
import responsi.model.ModelCustom;

/**
 *
 * @author Acer
 */
public class CustomView extends JFrame  implements ActionListener {
    private JLabel nama, massa, harga, inama, imassa,iharga,jml,itotal,ltotal;
    private JTextField ijml;
    private JButton btnEdit, btnHapus, kembali ,total;
    public String data1[];

    public CustomView(String[] data) {
       this.data1=data;
       setTitle(data[1]);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(350,320);
       
       nama = new JLabel("Nama: ");
       inama = new JLabel(data[1]);
       massa = new JLabel("Massa: ");
       imassa = new JLabel(data[2]);
       harga = new JLabel("Harga Satuan:");
       iharga = new JLabel(data[3]);
       jml = new JLabel("banyak: ");
       ijml = new JTextField(10);
       btnEdit = new JButton("Edit");
       btnHapus = new JButton("Hapus");
       kembali = new JButton("Kembali");
       total = new JButton("Total Harga");
       JLabel cok = new JLabel();
       
       add(ijml);
       add(nama);
       add(inama);
       add(massa);
       add(imassa);
       add(harga);
       add(iharga);
       add(jml);
       add(btnEdit);
       add(btnHapus);
       add(kembali);
       add(total);
       add(cok);
       
       nama.setBounds(10,10,120,20);
       inama.setBounds(130,10,100,20);
       massa.setBounds(10,35,120,20);
       imassa.setBounds(130,35,190,20);
       harga.setBounds(10,60,120,20);
       iharga.setBounds(130,60,190,20);
       jml.setBounds(10,85,120,20);
       ijml.setBounds(130,85,190,20);
       total.setBounds(100,180,120,20);
       total.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       total.addActionListener(this);
       btnEdit.setBounds(110,255,90,20);
        btnEdit.setBackground(Color.blue);
        btnEdit.setForeground(Color.white);
        btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEdit.addActionListener(this);
        btnHapus.setBounds(210,255,90,20);
        btnHapus.setBackground(Color.red);
        btnHapus.setForeground(Color.white);
        btnHapus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnHapus.addActionListener(this);
        kembali.setBounds(10,255,90,20);
        kembali.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kembali.addActionListener(this);
        setResizable(false);
       setLocation(450,200);
       setVisible(true);
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==kembali)
        {
            ControllerLihat men = new ControllerLihat();
            men.createLihat();
            this.dispose();
        }else if(e.getSource()==btnEdit){
            ControllerCustom tam = new ControllerCustom();
            tam.editTambah(data1);
            this.dispose();
        }else if(e.getSource()==btnHapus){
            ModelCustom mo= new ModelCustom();
            mo.hapus(data1);
            ControllerLihat men = new ControllerLihat();
            men.createLihat();
            this.dispose();
        }else if(e.getSource()==total){
            double jml1 = parseInt(ijml.getText());
            ModelCustom mo = new ModelCustom();
            mo.hitung(data1,jml1);
            this.dispose();
        }
    }

    
}
