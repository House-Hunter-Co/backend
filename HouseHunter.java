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


import househunter.Postgresql;

public class HouseHunter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Postgresql q = new Postgresql();
        int a = q.insertUser("Hüseyin ERDAL", "5069887862", "huseyin@huse.com", "1058");
        q.insertUser("Serkan ERDAL", "5069887862", "serkan@huse.com", "1060");
        var i = q.getUserByEmail("serkan@huse.com");
        
        System.out.println(i);
    }
    
}
