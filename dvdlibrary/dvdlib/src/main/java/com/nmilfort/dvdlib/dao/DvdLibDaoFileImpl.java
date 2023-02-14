/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmilfort.dvdlib.dao;

import com.nmilfort.dvdlib.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author nosha
 */
public class DvdLibDaoFileImpl implements DvdLibDao {
    
    private Map<String, Dvd> library = new HashMap<>();
    
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    

    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibDaoException {
        loadLibrary();
        Dvd newDvd = library.put(title, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibDaoException{
        loadLibrary();
        return new ArrayList(library.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibDaoException{
        loadLibrary();
        return library.get(title);
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibDaoException {
        loadLibrary();
        Dvd removedDvd = library.remove(title);
        writeLibrary();
        return removedDvd;
    }

    @Override
    public Dvd updateReleaseDate(String title, LocalDate releaseDate) throws DvdLibDaoException {
        loadLibrary();
        Dvd dvdToEdit = library.get(title);
        dvdToEdit.setReleaseDate(releaseDate);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd updateMpaaRating(String title, String mpaaRating) throws DvdLibDaoException {
        loadLibrary();
        Dvd dvdToEdit = library.get(title);
        dvdToEdit.setMpaaRating(mpaaRating);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd updateDirectorName(String title, String directorName) throws DvdLibDaoException {
        loadLibrary();
        Dvd dvdToEdit = library.get(title);
        dvdToEdit.setDirectorName(directorName);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd updateUserRating(String title, String userRating) throws DvdLibDaoException {
        loadLibrary();
        Dvd dvdToEdit = library.get(title);
        dvdToEdit.setUserRating(userRating);
        writeLibrary();
        return dvdToEdit;
    }

    @Override
    public Dvd updateStudioName(String title, String studioName) throws DvdLibDaoException {
        loadLibrary();
        Dvd dvdToEdit = library.get(title);
        dvdToEdit.setStudio(studioName);
        writeLibrary();
        return dvdToEdit;
    }
    
    @Override
    public Dvd searchDvd(String title) throws DvdLibDaoException {
        loadLibrary();
        return library.get(title);
    }
   
    

    
    private Dvd unmarshallDvd(String dvdAsText){
       String [] dvdTokens = dvdAsText.split(DELIMITER);
       
       String title = dvdTokens[0];
       Dvd dvdFromFile = new Dvd(title);
       
       String releaseDate = dvdTokens[1];
       dvdFromFile.setReleaseDate(LocalDate.parse(releaseDate));
       
       String mpaaRating = dvdTokens[2];
       dvdFromFile.setMpaaRating(mpaaRating);
       
       String directorName = dvdTokens[3];
       dvdFromFile.setDirectorName(directorName);
       
       String userRating = dvdTokens[4];
       dvdFromFile.setUserRating(userRating);
       
       
       String studio = dvdTokens[5];
       dvdFromFile.setStudio(studio);
       
       return dvdFromFile;
    }
    
    private void loadLibrary() throws DvdLibDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        Dvd currentDvd;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            
            library.put(currentDvd.getTitle(),currentDvd);
        }
        scanner.close();
    }
    
    private String marshallDvd(Dvd aDvd) {
        String dvdAsText = aDvd.getTitle() + DELIMITER;
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;
        dvdAsText += aDvd.getDirectorName() + DELIMITER;
        dvdAsText += aDvd.getUserRating() + DELIMITER;
        dvdAsText += aDvd.getStudio();
        return dvdAsText;
    }
    
    private void writeLibrary() throws DvdLibDaoException{
        PrintWriter out;
    
    try {
        out = new PrintWriter(new FileWriter(LIBRARY_FILE));
    } catch (IOException e) {
        throw new DvdLibDaoException("Could not save DVD data", e);
    }
    String dvdAsText;
    List <Dvd> dvdList = this.getAllDvds();
    for (Dvd currentDvd : dvdList) {
        dvdAsText = marshallDvd(currentDvd);
        out.println(dvdAsText);
        out.flush();
    }
    out.close();
    }


   
    
    }
    

