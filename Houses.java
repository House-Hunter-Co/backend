/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package househunter;

/**
 *
 * @author hebil
 */

public abstract class Houses {

   
    public String city;
    public Owner owner;
    public String rentOrsale;
    public String address;
    public String hsedetails;
    public int Nrbedrooms;
    public double rentorPrice;
    public boolean isBooked = false;

    public Houses( String city, Owner owner, String rentOrsale, String address, String hsedetails, int Nrbedrooms, double rentorPrice, boolean isBooked) {
        this.city = city;
        this.owner = owner;
        this.rentOrsale = rentOrsale;
        this.address = address;
        this.hsedetails = hsedetails;
        this.Nrbedrooms = Nrbedrooms;
        this.rentorPrice = rentorPrice;
        this.isBooked = isBooked;
    }

    

   

    public abstract int getHouseId();

    public abstract String toString();

  

  
    
    
}