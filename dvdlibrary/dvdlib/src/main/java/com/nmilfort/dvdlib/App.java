/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmilfort.dvdlib;

import com.nmilfort.dvdlib.controller.DvdLibController;
import com.nmilfort.dvdlib.dao.DvdLibDao;
import com.nmilfort.dvdlib.dao.DvdLibDaoFileImpl;
import com.nmilfort.dvdlib.ui.DvdLibView;
import com.nmilfort.dvdlib.ui.UserIO;
import com.nmilfort.dvdlib.ui.UserIOConsoleImpl;

/**
 *
 * @author nosha
 */
public class App {
    public static void main(String[] args) {
        //DvdLibController controller = new DvdLibController();
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibView myView = new DvdLibView(myIo);
        DvdLibDao myDao = new DvdLibDaoFileImpl();
        DvdLibController controller = new DvdLibController(myDao, myView);
        controller.run();
    }   
}
