/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmilfort.dvdlib.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author nosha
 */
public class UserIOConsoleImpl implements UserIO {
    
    final private Scanner console = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String msg) {
          while (true){
           try {
               return Double.parseDouble(this.readString(msg));
           } catch (NumberFormatException e){
               this.print("Input error. Please try again.");
           }
       }
    }

    @Override
    public double readDouble(String msg, double min, double max) {
        double result;
        do {
            result = readDouble(msg);
        } while (result < min||result > max);
        return result;
    }

    @Override
    public float readFloat(String msg) {
       while (true){
           try {
               return Float.parseFloat(this.readString(msg));
           } catch (NumberFormatException e){
               this.print("Input error. Please try again.");
           }
       }
    }

    @Override
    public float readFloat(String msg, float min, float max) {
        float result;
        do {
            result = readFloat(msg);
        } while (result < min||result > max);
        return result;
    }

    @Override
    public int readInt(String msg) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput){
            try{
                String sValue = this.readString(msg);
                num = Integer.parseInt(sValue);
                invalidInput = false;
            } catch (NumberFormatException e){
              this.print("Input error. Please try again.");  
            }
        }
        return num;
    }

    @Override
    public int readInt(String msg, int min, int max) {
        int result;
        do {
            result = readInt(msg);
        } while (result < min||result > max);
        return result;
    }

    @Override
    public long readLong(String msg) {
        while (true){
           try {
               return Long.parseLong(this.readString(msg));
           } catch (NumberFormatException e){
               this.print("Input error. Please try again.");
           }
        }
    }

    @Override
    public long readLong(String msg, long min, long max) {
       long result;
       do {
           result = readLong(msg);
       } while (result < min || result > max);
       return result;
    }

    @Override
    public String readString(String msg) {
        //this.print(msg);
        System.out.println(msg);
        return console.nextLine();
    }
    
    @Override
    public LocalDate readDate(String msg){
         LocalDate date = null;
         boolean validInput = true;
         do {
             try {
                 System.out.println(msg); 
                 System.out.println("Please input DVD date in the format YYYY-MM-DD");
                 
                 //DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-DD-YYYY");
                 String dateInput = console.nextLine();
                 //DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-DD-YYYY");
                 date = LocalDate.parse(dateInput); 
                validInput = true;
             } catch (DateTimeException e) {
                 this.print("Error. Date is not in the correct format");
                 validInput = false;
             }
         } while(!validInput);
         return date;
    }
}
