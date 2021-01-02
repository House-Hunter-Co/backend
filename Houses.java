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

    private int houseId;
    public String city;
    public Owner owner;
    public String rentOrsaile;
    public double mounthlyRent;
    public boolean isBooked;

    public Houses(String city, Owner owner, String rentOrsaile, double mounthlyRent) {
        this.owner = owner;
        this.rentOrsaile = rentOrsaile;
        this.city = city;
        //insertHouse();
    }
    
    
    
    public abstract String getCity();

    public abstract void setCity(String city);

    public abstract int getHouseId();

    public abstract String getRentOrsaile();

    public abstract void setRentOrsaile(String rentOrsaile);

    public abstract String toStringForCustomer();

    public abstract String toStringForOwner();

    public abstract double getMounthlyRent();

    public abstract void setMounthlyRent(double mounthlyRent);
    
    
}
