/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import responsi.view.CustomView;
import responsi.view.HasilView;

/**
 *
 * @author Acer
 */
public class ControllerCustom {

    ControllerCustom(String[] data) {
        new CustomView(data);
    }

    public ControllerCustom() {
        
    }

    public void editTambah(String[] data1) {
        ControllerTambah tam = new ControllerTambah();
        tam.editTambah(data1);
    }

    public void menghitung(String[] data,double total) {
        HasilView ve = new HasilView();
        ve.hasilHitung(data, total);
    }

}
