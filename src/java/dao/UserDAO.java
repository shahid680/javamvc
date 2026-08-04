/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.MyDbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
/**
 *
 * @author Passcom
 */
public class UserDAO {
    
    User user=null;
    //this function talks to controller 
    public User login(String username , String password)
    {
        try {
            //getting connection from dbconnection of util package
            Connection mycon=MyDbConnection.getConnection();
            
            String query="select * from users where username=? and password=?";
          PreparedStatement ps=  mycon.prepareStatement(query);
          ps.setString(1,username);
          ps.setString(2,password);
          
          ResultSet rs=ps.executeQuery();
          if(rs.next())
          {
              user=new User();
              user.setId(rs.getInt("id"));
              user.setUsername(rs.getString("username"));
              user.setPassword(rs.getString("password"));
          }
          
            
            
            
            
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
}