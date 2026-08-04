package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Passcom
 */
public class MyDbConnection {
    
    
    static Connection mycon=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","");
        System.out.println("Connection Established ++++++++++++++++++++++++++");
        
        return mycon;
        
    }
    
    
    
   
}