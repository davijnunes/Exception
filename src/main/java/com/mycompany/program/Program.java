/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.program;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Davi Nunes
 */
public class Program {

    public static void main(String[] args) {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    System.out.print("Room number: ");
    int numberRoom = sc.nextInt();
    
    System.out.print("Check-in date (dd/MM/yyyy): ");
    LocalDate checkIn = LocalDate.parse(sc.next(),dtf);    
    
    System.out.print("Check-out date (dd/MM/yyyy): ");
    LocalDate checkOut = LocalDate.parse(sc.next(),dtf);
    
    System.out.println();
    
    if(!checkOut.isAfter(checkIn)){
        System.out.println("Error in reservation: Reservation dates for update must be future dates");     
    }else{
        Reservation reservation = new Reservation(numberRoom,checkIn,checkOut);
        
        System.out.println("Reservation: " + reservation.toString());
        
        System.out.println("");
        System.out.println("Enter date to update the reservation:");
        
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkIn = LocalDate.parse(sc.next(),dtf);
        
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkOut = LocalDate.parse(sc.next(),dtf);
        
        LocalDate date = LocalDate.now();
        
        System.out.println("");
        
        // If the entry date is before the current date
        if(checkIn.isBefore(date) || checkOut.isBefore(date)){
            System.out.println("Error in reservation: Reservation dates for update must be future dates");
        }
        // if the departure date is not after the entry date
        else{
            if(!checkOut.isAfter(checkIn)){
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            // if all conditions are valid, instantiate a fourth
            else{
                reservation.updateDate(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);    
            }
            
            }
        
        
        
        
        
    }
    
    sc.close();

    }
}
