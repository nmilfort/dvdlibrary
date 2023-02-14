/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmilfort.dvdlib.dao;

import com.nmilfort.dvdlib.dto.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nosha
 */
public interface DvdLibDao {
    Dvd addDvd(String title, Dvd dvd) throws DvdLibDaoException;
    List<Dvd> getAllDvds() throws DvdLibDaoException;
    Dvd getDvd(String title)throws DvdLibDaoException;
    Dvd removeDvd(String title)throws DvdLibDaoException;
    Dvd updateReleaseDate(String title, LocalDate releaseDate)throws DvdLibDaoException;
    Dvd updateMpaaRating(String title, String mpaaRating)throws DvdLibDaoException;
    Dvd updateDirectorName(String title, String directorName)throws DvdLibDaoException;
    Dvd updateUserRating(String title, String userRating)throws DvdLibDaoException;
    Dvd updateStudioName(String title, String studioName)throws DvdLibDaoException;
    Dvd searchDvd(String title)throws DvdLibDaoException;
}
