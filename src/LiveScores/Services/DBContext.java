
package LiveScores.Services;


import java.sql.*; //DB operations!

//User defined classes!

/**
 *
 * @author Debug Entity
 */

public class DBContext {
    public Connection getConnection(String url,String user,String pass){
        Connection connection;
        try{
            connection = DriverManager.getConnection(url,user,pass);
            return connection;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
