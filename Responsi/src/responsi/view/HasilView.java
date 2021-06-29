/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.view;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import responsi.controller.ControllerLihat;

/**
 *
 * @author Acer
 */
public class HasilView extends JFrame  implements ActionListener{
    private JLabel nama, massa, harga, inama, imassa,iharga,ltotal,itotal;
    private JButton kembali;
    public void hasilHitung(String[] data, double total) {
       setTitle(data[1]);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(350,320);
       
       nama = new JLabel("Nama: ");
       inama = new JLabel(data[1]);
       massa = new JLabel("Massa: ");
       imassa = new JLabel(data[2]);
       harga = new JLabel("Harga Satuan:");
       iharga = new JLabel(data[3]);
       ltotal = new JLabel("Total Harga: ");
       String convert = String.valueOf(total);
       itotal = new JLabel(convert);
       kembali = new JButton("Kembali");
       JLabel cok = new JLabel();
       
       add(ltotal);
       add(nama);
       add(inama);
       add(massa);
       add(imassa);
       add(harga);
       add(iharga);
       add(itotal);
       add(kembali);
       add(cok);
       
       nama.setBounds(10,10,120,20);
       inama.setBounds(130,10,100,20);
       massa.setBounds(10,35,120,20);
       imassa.setBounds(130,35,190,20);
       harga.setBounds(10,60,120,20);
       iharga.setBounds(130,60,190,20);
       ltotal.setBounds(10,85,120,20);
       itotal.setBounds(130,85,190,20);
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
        }
    }
}
