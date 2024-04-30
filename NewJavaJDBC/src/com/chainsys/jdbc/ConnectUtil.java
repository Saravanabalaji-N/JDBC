package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConnectUtil{

  public static void main(String[] args) throws ClassNotFoundException, SQLException {

  Connection connection = getConnection();
      System.out.println(connection);
      
  	String query="select * from details";
  	PreparedStatement prepareStatement = connection.prepareStatement(query);
        
        ResultSet rows = prepareStatement.executeQuery();
        
        ResultSetMetaData metaData = rows.getMetaData();
        
        int columnCount = metaData.getColumnCount();
        
        for(int i=1; i<=columnCount; i+=1)
        {
            System.out.print(metaData.getColumnName(i) + "\t");
            
        }
        System.out.println();
        
        while(rows.next())
        {
            for(int i=1; i<=columnCount; i+=1)
            {
                System.out.print(rows.getString(i) + "\t");
            }
            System.out.println();
        }
        
        insert();
        update();     
        delete();  }
  
  public static void insert() throws ClassNotFoundException, SQLException {
      Connection connection = getConnection();
      
      String query = "insert into details values('Harish','kumar',2001,123456787,'sivakasi',466,479)";
      
      PreparedStatement prepare = connection.prepareStatement(query);
      
      int rows = prepare.executeUpdate();
      
      System.out.println("Rows Affected : " + rows);
  }
  
  public static void update() throws ClassNotFoundException, SQLException {
      Connection connection = getConnection();
      
      String query = "update details set lastname='kalyan' where firstname='Harish'";
      
      PreparedStatement prepare = connection.prepareStatement(query);
      
      int rows = prepare.executeUpdate();
      
      System.out.println("Rows Affected : " + rows);
  }
  
  public static void delete() throws ClassNotFoundException, SQLException {
      Connection connection = getConnection();
      
      String query = "delete from details where firstname='Akash'";
      
      PreparedStatement prepare = connection.prepareStatement(query);
      
      int rows = prepare.executeUpdate();
      
      System.out.println("Rows Affected : " + rows);
  }

  public static Connection getConnection() throws ClassNotFoundException, SQLException {

     Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeManagement", "root", "Saravana#026");
      return connection;
      
    

  }

}
