/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi.controller;

import responsi.view.LihatView;
import responsi.view.TambahView;

/**
 *
 * @author Acer
 */
public class ControllerLihat {
    public void createLihat() {
        LihatView li = new LihatView();
        li.openTable();
    }

    public void getEditDelete(String[] data) {
        ControllerCustom co = new ControllerCustom(data);
    }
    
}
