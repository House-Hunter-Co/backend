/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package househunter;

import java.util.ArrayList;

/**
 *
 * @author hebil
 */
public class Owner extends User {
    ArrayList<Appointment> myAppointments  = new ArrayList<Appointment>();
    public Owner(String name, String phoneNumber, String emailAddress, String password) {
        super(name, phoneNumber, emailAddress, password);
    }
    
    public static String[] myHouses;
    public static int addHouse(){
        return 1;
    }
    
  
  

  public boolean addApt(Appointment x)
    {
     for (int i = 0 ;i< myAppointments.size(); i++)
          {
             if (myAppointments.get(i).getAptDate().equals(x.getAptDate())  && myAppointments.get(i).getTime() == x.getTime()  )
                {
                    return false;
                }

           }
     myAppointments.add(x);
     return true;
    
    }

  public String displayAppointments()
    {
       String output= "";
        for (int i = 0 ;i<myAppointments.size();i++)
        {
        output += myAppointments.get(i).toString() + "\n";
        
        } 
        return output;
    } 

}
