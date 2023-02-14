/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmilfort.dvdlib.controller;

import com.nmilfort.dvdlib.dao.DvdLibDao;
import com.nmilfort.dvdlib.dao.DvdLibDaoException;
import com.nmilfort.dvdlib.dao.DvdLibDaoFileImpl;
import com.nmilfort.dvdlib.dto.Dvd;
import com.nmilfort.dvdlib.ui.DvdLibView;
import com.nmilfort.dvdlib.ui.UserIO;
import com.nmilfort.dvdlib.ui.UserIOConsoleImpl;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author nosha
 */
public class DvdLibController {
    private UserIO io = new UserIOConsoleImpl();
    
    //private DvdLibView view = new DvdLibView();
    private DvdLibView view;
    private DvdLibDao dao;
    
    //private DvdLibDao dao = new DvdLibDaoFileImpl();
    
    public DvdLibController(DvdLibDao dao, DvdLibView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        while (keepGoing) {
            
            menuSelection = view.printMenu();

            switch (menuSelection) {
                case 1:
                    //io.print("CREATE DVD");
                    createDvd();
                    break;
                case 2:
                    //io.print("REMOVE DVD");
                    removeDvd();
                    break;
                case 3:
                    //io.print("EDIT DVD");
                    editDvd();        
                    break;
                case 4:
                    //io.print("LIST DVD");
                    listDvds();
                    break;
                case 5:
                    //io.print("VIEW DVD");
                    viewDvds();
                    break;
                case 6:
                    //io.print("SEARCH DVD");
                    searchDvd();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    //io.print("UNKNOWN COMMAND");
                    unknownCommand();
            }

        }
        //io.print("GOOD BYE");
        exitMessage();
    } catch (DvdLibDaoException e){
    
    view.displayErrorMessage(e.getMessage());
}
    }

    
    private void createDvd() throws DvdLibDaoException{
        view.createDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(),newDvd);
        view.createSuccessBanner();
    }
    private void listDvds() throws DvdLibDaoException{
        view.displayDvdListBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }
    private void viewDvds() throws DvdLibDaoException{
        view.displayDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }
    private void removeDvd() throws DvdLibDaoException{
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    private void exitMessage(){
        view.displayExitBanner();
    }
    
    private void editDvd() throws DvdLibDaoException  {
        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvdToEdit = dao.getDvd(title);
        if (dvdToEdit==null) {
            view.displayNullDvd();
        } else {
            view.displayDvd(dvdToEdit);
            int editMenuSelection = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                editMenuSelection = view.printEditMenu();

                switch (editMenuSelection){
                    case 1:
                        editReleaseDate(title);
                        break;
                    case 2:
                        editMpaaRating(title);
                        break;
                    case 3:
                        editDirectorName(title);
                        break;
                    case 4:
                        editUserRating(title);
                        break;
                    case 5:
                        editStudioName(title);
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                if (keepGoing == false) {
                    break;
            } 
        }
        }
    }
    
     private void editReleaseDate(String title) throws DvdLibDaoException {
        view.displayEditReleaseDateBanner();
        LocalDate newReleaseDate = view.getReleaseDate();
        Dvd editedDvd = dao.updateReleaseDate(title, newReleaseDate);
        view.displayEditResult();
    }
    private void editMpaaRating(String title) throws DvdLibDaoException {
        view.displayEditMpaaBanner();
        String newMpaaRating = view.getMpaaRating();
        Dvd editedDvd = dao.updateMpaaRating(title, newMpaaRating);
        view.displayEditResult();
    }
    private void editDirectorName(String title) throws DvdLibDaoException {
        view.displayEditDirectorBanner();
        String newDirectorName = view.getDirectorName();
        Dvd editedDvd = dao.updateDirectorName(title, newDirectorName);
        view.displayEditResult();
    }
    private void editUserRating(String title) throws DvdLibDaoException {
        view.displayEditUserRatingBanner();
        String newUserRating = view.getUserRating();
        Dvd editedDvd = dao.updateUserRating(title, newUserRating);
        view.displayEditResult();
    }
    private void editStudioName(String title) throws DvdLibDaoException {
        view.displayEditStudioBanner();
        String newStudioName = view.getStudioName();
        Dvd editedDvd = dao.updateStudioName(title, newStudioName);
        view.displayEditResult();
    }
    
    private void searchDvd() throws DvdLibDaoException{
        view.displaySearchBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }
     
}



