/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package househunter;
import java.util.Calendar;

/**
 *
 * @author Regina Gachomba
 */
public class Appointment {

    /**
     * @param args the command line arguments
     */
    
   private Calendar aptDate;
   private String  fullName;
   private String phone ;
   private int time;

    public Appointment(Calendar aptDate, String fullName, String phone, int time) {
        this.aptDate = aptDate;
        this.fullName = fullName;
        this.phone = phone;
        this.time = time;
    }
   

   
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
 

    public Calendar getAptDate() {
        return aptDate;
    }

    public void setAptDate(Calendar aptDate) {
        this.aptDate = aptDate;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTime() {
        return time;
    }

    
    

    @Override
    public String toString() {
        return ("Appointment\n" + "\naptDate=" + aptDate + "\nfullName=" + fullName + "\nphone=" + phone + "\ntime=" + time  +"\n");
    }
    

   
}
/*Add the code below to House owner class*/
/*        
*/