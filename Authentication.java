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
public interface Authentication {
    Postgresql q = new Postgresql();
    public static int login(String email, String password){
        String pwd = "";
        try{
            pwd = q.getUserByEmail(email).get(4).trim();
        }catch(Exception e){
            return 0;
        }
        System.out.println(pwd+"-"+password);
        if(pwd.equals(password)){
            return 1;
        }
        else{
            return 0;
        }
        
    }
    public static int register(String name,String phoneNumber,String emailAddress,String password) {
        int r = q.insertUser(name, phoneNumber, emailAddress, password);
        return r;
    }
    public static int logout() {
        return 1;
    }
}
