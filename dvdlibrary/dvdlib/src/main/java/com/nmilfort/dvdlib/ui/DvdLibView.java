/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmilfort.dvdlib.ui;

import com.nmilfort.dvdlib.dto.Dvd;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author nosha
 */
public class DvdLibView {
    //private UserIO io = new UserIOConsoleImpl();
    
    private UserIO io;
    
    public DvdLibView(UserIO io){
        this.io = io;
    }

    public int printMenu() {
        io.print("||||||***** Main Menu *****||||||");
        io.print("1. Create DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. List DVD");
        io.print("5. View DVD");
        io.print("6. Search DVD");
        io.print("7. Exit");


        return io.readInt("Please select from the above choices.", 1, 7);
    }
    public Dvd getNewDvdInfo(){
        String title = io.readString("Please Enter DVD Title");
        LocalDate releaseDate = io.readDate("Please Enter DVD Release Date");
        String mpaaRating = io.readString("Please Enter the Mpaa Rating");
        String directorName = io.readString("Please Enter the Director's Name");
        String userRating = io.readString("Please Enter User Rating");
        String studio = io.readString("Please Enter the DVD studio");
        
        Dvd currentDvd = new Dvd(title);
        
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorName(directorName);
        currentDvd.setUserRating(userRating);
        currentDvd.setStudio(studio);
        
        return currentDvd;
    }
    
     public void createDvdBanner() {
        io.print("====== ||| CREATE DVD ||| ======");  
    }
    
    public void createSuccessBanner() {
        io.readString("DVD successfully created. Please hit enter to continue");
    }
    
    public void displayDvdList(List<Dvd>dvdList){
        for (Dvd currentDvd : dvdList){
            String dvdInfo = String.format("%s | %s | %s | %s | %s | %s ", currentDvd.getTitle(), currentDvd.getReleaseDate(), currentDvd.getMpaaRating(), currentDvd.getDirectorName(), currentDvd.getUserRating(), currentDvd.getStudio());   
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue");
    }
    public void displayDvdListBanner() {
        io.print("=== ||| DISPLAY ALL DVDs ||| ===");
    }
    
    public void displayDvdBanner() {
        io.print("=== ||| DISPLAY DVDs ||| ===");
    }
    
    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD title.");
    }
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print("Title: " + dvd.getTitle());
            io.print("Release date: " + dvd.getReleaseDate());
            io.print("MPAA rating: " + dvd.getMpaaRating());
            io.print("Director's name: " + dvd.getDirectorName());
            io.print("User rating: " + dvd.getUserRating());
            io.print("Studio: "+ dvd.getStudio());
        } else {
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayRemoveDvdBanner() {
        io.print("===||| REMOVE DVD |||===");
    }
    public void displayRemoveResult(Dvd dvdRecord) {
        if (dvdRecord != null) {
            io.print("DVD successfully removed.");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayExitBanner(){
        io.print("GOOD BYE!");
    } 
    public void displayUnknownCommandBanner(){
        io.print("UNKNOWN COMMAND!");
    }
    public void displayErrorMessage(String errorMsg){
        io.print("===||| ERROR |||===");
        io.print(errorMsg);
    }
    
    public void displayEditDvdBanner() {
        io.print("===||| EDIT DVD |||==="); 
    }
    
    public int printEditMenu() {
        io.print("What would you like to update?");
        io.print("Edit DVD menu");
        io.print("1. Release date");
        io.print("2. MPAA rating");
        io.print("3. Director's name");
        io.print("4. User rating");
        io.print("5. Studio name");
        io.print("6. Exit edit menu");
        return io.readInt("Please select from the above choices.", 1,6);
    }
    
    public void displayEditReleaseDateBanner() {
        io.print("===||| EDIT RELEASE DATE |||===");
        
    }
    
    public void displayEditMpaaBanner() {
        io.print("===||| EDIT MPAA RATING |||===");
        
    }
    
    public void displayEditDirectorBanner() {
        io.print("===||| EDIT DIRECTOR NAME |||===");
        
    }
    
    public void displayEditUserRatingBanner() {
        io.print("===||| EDIT USER RATING |||===");
        
    }
    
    public void displayEditStudioBanner() {
        io.print("===||| EDIT STUDIO NAME |||===");
        
    }
    
    public void displayNullDvd(){
        io.print("No such DVD");
    }
    
    public void displayEditResult(){
        io.print("DVD Successfully edited.");
    }
    
    public LocalDate getReleaseDate() {
        return io.readDate("Please enter the updated DVD release date");
    }
    
    public String getMpaaRating() {
        return io.readString("Please enter the updated DVD MPAA rating");
    }
    
    public String getDirectorName() {
        return io.readString("Please enter the updated Director name.");
    }
    
    public String getUserRating() {
        return io.readString("Please enter the updated User rating.");
    }
    
    public String getStudioName() {
        return io.readString("Please enter the updated Studio name.");
    }
    
    public void displaySearchBanner() {
        io.print("===||| SEARCH BY TITLE |||===");
    }
}

