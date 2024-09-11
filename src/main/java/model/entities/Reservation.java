/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.time.LocalDate;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Davi Nunes
 */
public class Reservation {
    
    private Integer numberRoom;
    private LocalDate checkIn;
    private LocalDate checkOut;
    
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Reservation(){
    }
    
    public Reservation(Integer numberRoom, LocalDate checkIn,LocalDate checkOut){
        
        this.numberRoom = numberRoom;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }    
    
    public Integer getNumberRoom(){
        
        return numberRoom;
    }
    
    public void setNumberRoom(Integer numberRoom){
        
        this.numberRoom = numberRoom;
    }
    
    public LocalDate getCheckIn(){
        
        return checkIn;
    }
    
    public LocalDate getCheckOut(){
        
        return checkOut;
    }
    
    public long duration(){
       
      // return difference of dates in day
      return Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
        
    }
    
    public void updateDate(LocalDate checkIn, LocalDate checkOut){
        
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        
    }
    
    @Override
    public String toString(){
       
        return "Room " + getNumberRoom() +
        ", check-in: " + dtf.format(checkIn) +
        ", check-out: " + dtf.format(checkOut) +
        ", " + duration() + " nigths";
                
        
    }
    
}
