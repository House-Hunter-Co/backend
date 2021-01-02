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
public interface DBManager {
    int get();
    int delete(int id);
    int update();
    int insertUser(String name,String phoneNumber,String emailAddress,String password);
    int insertHouse(String city,String phoneNumber,String emailAddress,String password);
}
