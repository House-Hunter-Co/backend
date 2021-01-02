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

public class ForSale extends Houses {
    public double price;
    public int houseId = 1000;


    public ForSale(){
        
    }
    
    public ForSale(String city, Owner owner, String rentOrsaile, double mounthlyRent) {
        super(city, owner, rentOrsaile, mounthlyRent);
        this.price = price;
        houseId++;

    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {

        this.city = city;
    }

    @Override
    public int getHouseId() {
        return houseId;
    }


    public double getMounthlyRent() {
        return mounthlyRent;
    }
    public void setMounthlyRent(double mounthlyRent) {
        this.mounthlyRent = mounthlyRent;
    }

    @Override
    public String getRentOrsaile() {
        return this.getRentOrsaile();
    }

    @Override
    public void setRentOrsaile(String rentOrsaile) {

        this.rentOrsaile = rentOrsaile;
    }
    
    

    //tostring methoed for customer and owner can be the same becouse it contains the same elements 
    public String toStringForCustomer() {
        return "ForSale{" + "City " + this.city + "price= " + price + ", houseId= " + houseId + "rentOrsaile " + this.rentOrsaile + "Owner " + this.owner + '}';
    }

    public String toStringForOwner() {
        return "ForSale{" + "City " + this.city + "price= " + price + ", houseId= " + houseId + "rentOrsaile " + this.rentOrsaile + "Owner " + this.owner + '}';
    }
}