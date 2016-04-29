
package blooddonation;
import java.sql.*;
public class DBCon {
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/blooddonationsystemdb";
    private static String USERNAME = "root";
    private static String PASSWORD = "mysql";
    private static Connection con;

    public static void StartCon(){
        try{
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(ClassNotFoundException | SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
   
    public static void EndCon(){
        try{
            con.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
   
    public static boolean Insert(String Query){
        try{
            PreparedStatement statement = con.prepareStatement(Query);
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
   
    public static boolean Update(String Query){
        try{
            PreparedStatement statement = con.prepareStatement(Query);
            statement.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
   
    public static boolean Delete(String Query){
        try{
            PreparedStatement statement = con.prepareStatement(Query);
            statement.executeQuery();
            return true;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
   
    public static ResultSet Select(String Query){
        try{
            PreparedStatement statement = con.prepareStatement(Query);
            return statement.executeQuery();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    
    
}
