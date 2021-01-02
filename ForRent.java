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
public class ForRent extends Houses {

    public int numberOfMounthes;
    public double allPaiment;
    public int houseId = 2000;
    public double discount = 0.0;

    public ForRent(String city, Owner owner, String rentOrsaile, double mounthlyRent) {
        
        super(city, owner, rentOrsaile, mounthlyRent);

        this.numberOfMounthes = numberOfMounthes;
    }

    public int getNumberOfMounthes() {

        return numberOfMounthes;
    }

    public void setNumberOfMounthes(int numberOfMounthes) {

        this.numberOfMounthes = numberOfMounthes;
    }

    public double getAllPaiment() {

        allPaiment = (mounthlyRent * numberOfMounthes);
        return allPaiment - this.discount;
    }

    public double getMounthlyRent() {

        return mounthlyRent;
    }

    public void setMounthlyRent(double mounthlyRent) {

        this.mounthlyRent = mounthlyRent;
    }

    public double getDiscount() {

        return discount;
    }

    public void setDiscount(double discount) {

        this.discount = discount;
    }

    @Override
    public int getHouseId() {

        return houseId;
    }

    @Override
    public String getCity() {

        return city;
    }

    @Override
    public void setCity(String city) {

        this.city = city;
    }

    @Override
    public String getRentOrsaile() {

        return this.rentOrsaile;
    }

    @Override
    public void setRentOrsaile(String rentOrsaile) {

        this.rentOrsaile = rentOrsaile;

    }
    public String toStringForCustomer() {
    return "ForRent{" + "City " + this.city + "mounthlyRent= " + mounthlyRent + ", numberOfMounthes= " + numberOfMounthes + ", allPaiment= " + allPaiment + ", houseId= " + houseId + "Owner " + this.owner.toString() + "Discount " + this.discount + '}';
}

    public String toStringForOwner() {
        return "ForRent{" + "City " + this.city + "mounthlyRent= " + mounthlyRent + ", houseId= " + houseId + "Owner " + this.owner.toString() + '}';
    }
}
