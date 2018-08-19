/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DManage;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Aman Nautiyal
 */
public class DataManager {
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/test";
    private static final String USERN="root";
    private static final String PASSW="root";
    static
    {
     try
     {
        Class.forName(DRIVER);
     }
     catch(Exception e)
     {
      System.out.println("Error in DMAnage Driver Initialisation.");
     }
    }
    public static void insertMarks(Student s)
    {
     try(Connection connect=DriverManager.getConnection(URL,USERN, PASSW))
     {
      PreparedStatement p=connect.prepareCall("INSERT INTO Marks values(?,?,?,?,?)");
      p.setInt(1,s.getRollNumber());
      p.setString(2,s.getName());
      p.setInt(3,s.getPhysics());
      p.setInt(4,s.getChemistry());
      p.setInt(5,s.getMaths());
      p.executeUpdate();
     }
     catch(Exception e)
     {
      System.out.println("DManage: Error in method insertMarks."+e);
     }
    }
    public static ArrayList<Student> getStudent(String name)
    {
        ArrayList<Student> stlist=new ArrayList<>();
       try(Connection connect=DriverManager.getConnection(URL,USERN, PASSW))
       {
        PreparedStatement p=connect.prepareCall("SELECT * FROM Marks WHERE Name like ?"); 
        p.setString(1,"%"+name+"%");
        ResultSet rs = p.executeQuery();
        while(rs.next())
        {
         Student st=new Student();
         st.setRollNumber(rs.getInt(1));
         st.setName(rs.getString(2));
         st.setPhysics(rs.getInt(3));
         st.setChemistry(rs.getInt(3));
         st.setMaths(rs.getInt(3));
         stlist.add(st);
        }
       }
       catch(Exception e)
       {
        System.out.println("DManage error in method getStudent");
       }
       return stlist;
    }
    public static ArrayList<Student> getStudent(int roll)
    {
        ArrayList<Student> stlist=new ArrayList<>();
       try(Connection connect=DriverManager.getConnection(URL,USERN, PASSW))
       {
        PreparedStatement p=connect.prepareCall("SELECT * FROM Marks WHERE RollNumber like ?"); 
        p.setString(1,"%"+roll+"%");
        ResultSet rs = p.executeQuery();
        while(rs.next())
        {
         Student st=new Student();
         st.setRollNumber(rs.getInt(1));
         st.setName(rs.getString(2));
         st.setPhysics(rs.getInt(3));
         st.setChemistry(rs.getInt(3));
         st.setMaths(rs.getInt(3));
         stlist.add(st);
        }
       }
       catch(Exception e)
       {
        System.out.println("DManage error in method getStudent");
       }
       return stlist;
    }
    public static ArrayList<Student> getAllStudents()
    {
        ArrayList<Student> stlist=new ArrayList<>();
       try(Connection connect=DriverManager.getConnection(URL,USERN, PASSW))
       {
        PreparedStatement p=connect.prepareCall("SELECT * FROM Marks"); 
        ResultSet rs = p.executeQuery();
        while(rs.next())
        {
         Student st=new Student();
         st.setRollNumber(rs.getInt(1));
         st.setName(rs.getString(2));
         st.setPhysics(rs.getInt(3));
         st.setChemistry(rs.getInt(3));
         st.setMaths(rs.getInt(3));
         stlist.add(st);
        }
       }
       catch(Exception e)
       {
        System.out.println("DManage error in method getStudent");
       }
       return stlist;
    }
}
