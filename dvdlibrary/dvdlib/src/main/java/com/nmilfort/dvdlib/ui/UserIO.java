/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmilfort.dvdlib.ui;

import java.time.LocalDate;

/**
 *
 * @author nosha
 */
public interface UserIO {
    
    void print(String msg);
    
    String readString(String msg);

    int readInt(String msg);

    int readInt(String msg, int min, int max);

    double readDouble(String msg);

    double readDouble(String msg, double min, double max);

    float readFloat(String msg);

    float readFloat(String msg, float min, float max);

    long readLong(String msg);

    long readLong(String msg, long min, long max);
    
    LocalDate readDate(String msg);
 
}
