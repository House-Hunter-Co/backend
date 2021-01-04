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

    public int houseId ;
    private  static int idCounter = 20000;
   

    public ForRent (int houseId, String city, Owner owner, String rentOrsale,String address, String hsedetails, int Nrbedrooms, double rentorPrice, boolean isBooked) {
       super( city,  owner,  rentOrsale,address,hsedetails,Nrbedrooms, rentorPrice,isBooked);
       
       houseId = idCounter++;
       
    }

  



    
    @Override
    public int getHouseId() {

        return houseId;
    }

  
   
    
    @Override
    public String toString() {
    return "ForRent{" + ", houseId= " + houseId + "City: " +  city + "Address: " +  address +"Number of bedrooms: " +  Nrbedrooms +" mounthlyRent= " + rentorPrice +  "Owner " + owner.toString() + '}';
}
 
    
}
