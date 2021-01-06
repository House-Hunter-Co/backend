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
                " usertype       CHAR(50)," +
                " createdat      CHAR(50))";
            
            String sqlForHouses = "CREATE TABLE IF NOT EXISTS houses " +
                "(ID             SERIAL     PRIMARY KEY," +
                " city           TEXT       NOT NULL, " +
                " owner    CHAR(10000)   NOT NULL, " +
                " rentorsale   CHAR(10)  , " +
                " address       CHAR(50)," +
                " hsedetails       CHAR(100)," +
                " nrbedrooms       CHAR(50)," +
                " rentorprice       CHAR(50)," +
                " isbooked       CHAR(50)," + 
                " createdat      CHAR(50))";
            
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
    public int insertUser(String name,String phoneNumber,String emailAddress,String password,String userType) {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        try {
            c.createStatement().executeUpdate("INSERT INTO \"users\" (\"name\", \"phonenumber\" , \"emailaddress\",\"password\",\"usertype\",\"createdat\") "
                    + "VALUES ('"+ name + "', '" + phoneNumber + "','"+ emailAddress + "', '" + password + "','" + userType + "', '" + timeStamp + "')");
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
                userinfo.add(rs.getString(7));
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
                userinfo.add(rs.getString(7));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return new ArrayList<String>();
        }
        return userinfo;
    }
    
    @Override
    public int insertHouse(String city,int ownerId,String rentOrsale,String address,String hsedetails,String Nrbedrooms,String rentorPrice,String isBooked) {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        try {
            c.createStatement().executeUpdate("INSERT INTO \"houses\" (\"city\", \"owner\" , \"rentorsale\",\"address\",\"hsedetails\",\"nrbedrooms\",\"rentorprice\",\"isbooked\",\"createdat\") "
                    + "VALUES ('"+ city + "', '" + ownerId + "','"+ rentOrsale + "','"+ address + "','"+ hsedetails + "','"+ Nrbedrooms + "','"+ rentorPrice + "','"+ isBooked + "', '" + timeStamp + "')");
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
        return 1;
    }
    
    public ArrayList<String> getHouseById(int id) {
        ArrayList<String> userinfo = new ArrayList<String>(); 
        try (Connection con = DriverManager.getConnection(url, user, password);
                
            PreparedStatement pst = con.prepareStatement("SELECT * FROM \"houses\" WHERE \"id\"="+"'"+id+"'");
            ResultSet rs = pst.executeQuery()) {
            System.out.println(rs);
            while (rs.next()) {
                userinfo.add(rs.getString(1));
                userinfo.add(rs.getString(2));
                userinfo.add(rs.getString(3));
                userinfo.add(rs.getString(4));
                userinfo.add(rs.getString(5));
                userinfo.add(rs.getString(6));
                userinfo.add(rs.getString(7));
                userinfo.add(rs.getString(8));
                userinfo.add(rs.getString(9));
                userinfo.add(rs.getString(10));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return new ArrayList<String>();
        }
        return userinfo;
    }
    
    public ArrayList<String> getHouseByOwner(int ownerId) {
        ArrayList<String> userinfo = new ArrayList<String>(); 
        try (Connection con = DriverManager.getConnection(url, user, password);
                
            PreparedStatement pst = con.prepareStatement("SELECT * FROM \"houses\" WHERE \"owner\"="+"'"+ownerId+"'");
            ResultSet rs = pst.executeQuery()) {
            System.out.println(rs);
            while (rs.next()) {
                userinfo.add(rs.getString(1));
                userinfo.add(rs.getString(2));
                userinfo.add(rs.getString(3));
                userinfo.add(rs.getString(4));
                userinfo.add(rs.getString(5));
                userinfo.add(rs.getString(6));
                userinfo.add(rs.getString(7));
                userinfo.add(rs.getString(8));
                userinfo.add(rs.getString(9));
                userinfo.add(rs.getString(10));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return new ArrayList<String>();
        }
        return userinfo;
    }
    
    public ArrayList<String> getHouseByCity(String city) {
        ArrayList<String> userinfo = new ArrayList<String>(); 
        try (Connection con = DriverManager.getConnection(url, user, password);
                
            PreparedStatement pst = con.prepareStatement("SELECT * FROM \"houses\" WHERE \"city\"="+"'"+city+"'");
            ResultSet rs = pst.executeQuery()) {
            System.out.println(rs);
            while (rs.next()) {
                userinfo.add(rs.getString(1));
                userinfo.add(rs.getString(2));
                userinfo.add(rs.getString(3));
                userinfo.add(rs.getString(4));
                userinfo.add(rs.getString(5));
                userinfo.add(rs.getString(6));
                userinfo.add(rs.getString(7));
                userinfo.add(rs.getString(8));
                userinfo.add(rs.getString(9));
                userinfo.add(rs.getString(10));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            return new ArrayList<String>();
        }
        return userinfo;
    }
}
