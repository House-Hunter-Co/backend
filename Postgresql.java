/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package househunter;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author hebil
 */
public class Postgresql implements DBManager {
    Connection c = null;
    Statement stmt = null;
    String url = "jdbc:postgresql://localhost:5433/househunter";
    String user = "postgres";
    String password = "1058";
    private static final String QUERY = "select id,name,email,country,password from Users where id =?";
    
    public Postgresql() {
        
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                .getConnection(url,user, password);
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users " +
                "(ID             SERIAL     PRIMARY KEY," +
                " name           TEXT       NOT NULL, " +
                " phonenumber    CHAR(13)   NOT NULL, " +
                " emailaddress   CHAR(50)   UNIQUE, " +
                " password       CHAR(50)," +
                " createdat      CHAR(50))";
            
            String sqlForHouses = "CREATE TABLE IF NOT EXISTS houses " +
                "(ID             SERIAL     PRIMARY KEY," +
                " city           TEXT       NOT NULL, " +
                " owner    TEXT   NOT NULL, " +
                " rentOrsaile   CHAR(10)   UNIQUE, " +
                " mounthlyRent       CHAR(50)," +
                " isBooked       NUMBER," +  // 0 or 1
                " createdat      CHAR(50))";
            
            /*These are columns for houses
    public String city;
    public Owner owner;
    public String rentOrsale;
    public String address;
    public String hsedetails;
    public int Nrbedrooms;
    public double rentorPrice;
    public boolean isBooked = false;*/
            
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sqlForHouses);
            stmt.close();
            //c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        
        
    }

    @Override
    public int get() {
        System.out.println(c);
        return 1;
    }

    @Override
    public int delete(int id) {
        try {
            c.createStatement().executeUpdate("DELETE FROM \"users\" WHERE id="+id);
        } catch (SQLException ex) {
            return 0;
        }
        return 1;
    }

    @Override
    public int update() {
        return 1;
    }

    @Override
    public int insertUser(String name,String phoneNumber,String emailAddress,String password) {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        try {
            c.createStatement().executeUpdate("INSERT INTO \"users\" (\"name\", \"phonenumber\" , \"emailaddress\",\"password\",\"createdat\") "
                    + "VALUES ('"+ name + "', '" + phoneNumber + "','"+ emailAddress + "', '" + password + "', '" + timeStamp + "')");
        } catch (SQLException ex) {
            return 0;
        }
        return 1;
    }
    
    public ArrayList<String> getUserById(int id) {
        ArrayList<String> userinfo = new ArrayList<String>();
        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE id="+id);
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                userinfo.add(rs.getString(1));
                userinfo.add(rs.getString(2));
                userinfo.add(rs.getString(3));
                userinfo.add(rs.getString(4));
                userinfo.add(rs.getString(5));
                userinfo.add(rs.getString(6));
            }

        } catch (SQLException ex) {
            return new ArrayList<String>();
        }
        return userinfo;
    }
    
    public ArrayList<String> getUserByEmail(String email) {
        ArrayList<String> userinfo = new ArrayList<String>(); 
        try (Connection con = DriverManager.getConnection(url, user, password);
                
            PreparedStatement pst = con.prepareStatement("SELECT * FROM \"users\" WHERE \"emailaddress\"="+"'"+email+"'");
            ResultSet rs = pst.executeQuery()) {
            System.out.println(rs);
            while (rs.next()) {
                userinfo.add(rs.getString(1));
                userinfo.add(rs.getString(2));
                userinfo.add(rs.getString(3));
                userinfo.add(rs.getString(4));
                userinfo.add(rs.getString(5));
                userinfo.add(rs.getString(6));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return new ArrayList<String>();
        }
        return userinfo;
    }
     @Override
    public int insertHouse(String city,String owner,String rentOrsaile,String mounthlyRent) {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        try {
            c.createStatement().executeUpdate("INSERT INTO \"houses\" (\"city\", \"owner\" , \"rentOrsaile\",\"mounthlyRent\",\"createdat\") "
                    + "VALUES ('"+ city + "', '" + owner + "','"+ rentOrsaile + "', '" + mounthlyRent + "', '" + timeStamp + "')");
        } catch (SQLException ex) {
            return 0;
        }
        return 1;
    }
//@huseyin could you please implement the following  

/*
    public String getHouseDetailsById(int houseid)  // returns only one house with the id given
    public ArrayList<String> getHousesforRent(String Rentorsale)   
    public ArrayList<String> getHousesforSale(String Rentorsale)
    public ArrayList<String> getHousesbycity(String Rentorsale)
    public ArrayList<String> getHousesbyowner(Owner sahibi)
    public ArrayList<String> getHousesbyrentorprice(double rentorprice) // returns houses with that  price or less than that price
    public ArrayList<String> getHousesbynumofbedrooms(int Nrbedrooms)
    public Owner getOwnerbyhseId(int hseid)  // returns owner of the house with the houseid parameter passed
    public void deletebookedhouses()  // if isbooked == true delete house from table
    
    
    
 */   
     
    
    
   
    
    
    
}
