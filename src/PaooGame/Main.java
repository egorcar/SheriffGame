package PaooGame;

//---------------------------------------------------------SHERIFF--------------------------------------------------------------------

import java.sql.Connection;
import java.sql.DriverManager;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = new Game("Sheriff", 816, 576);
        paooGame.StartGame();
    }

    /*public static void main(String[] args) {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:paooL10.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
    }*/

}
