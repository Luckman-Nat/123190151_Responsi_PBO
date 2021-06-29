/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.controller;

import responsi.model.ModelTambah;
import responsi.view.TambahView;

/**
 *
 * @author Acer
 */
public class ControllerTambah {

    public void createTambah() {
        TambahView tam = new TambahView();
        tam.openForm();
    }

    public void createTambah(String[] data) {
        ModelTambah mod = new ModelTambah();
        mod.createTambah(data);
    }

    public void editTambah(String[] data){
        TambahView mod = new TambahView();
        mod.edit(data);
    }
    
    public void editInput(String[] data){
        ModelTambah mod = new ModelTambah();
        mod.edit(data);
    }
}
