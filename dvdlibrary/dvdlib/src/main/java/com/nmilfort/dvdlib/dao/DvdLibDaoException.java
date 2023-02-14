/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmilfort.dvdlib.dao;

/**
 *
 * @author nosha
 */
public class DvdLibDaoException extends Exception{
    public DvdLibDaoException(String message){
        super(message);
    }
  public DvdLibDaoException(String message, Throwable cause) {
        super(message, cause);
    }  
}
