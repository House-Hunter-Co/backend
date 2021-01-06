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

public class HouseHunterBack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Postgresql q = new Postgresql();
        q.insertHouse("Ankara",1,"rent","123.street any city any region","Lorem ipsum dolor sit amet, consectetur adipisicing elit","3","100","true");
        q.insertHouse("Istanbul",1,"sale","123.street any city any region","Lorem ipsum dolor sit amet, consectetur adipisicing elit","3","100","true");
        var h = q.getHouseById(1);
        var user = q.getUserById(1);
        //var hi = q.getHouseByOwner("Serkan ERDAL");
        var s = q.getHouseByOwner(222);
        System.out.println(h);
        System.out.println(s);
    }
    
}
